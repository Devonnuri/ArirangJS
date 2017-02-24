package com.arirangJS.Script;

import com.arirangJS.Debug.Debug;
import com.arirangJS.Lang.ErrReporter;
import com.arirangJS.Main.SyntaxHighlighter;
import com.arirangJS.Script.Classes.*;
import com.arirangJS.Script.Classes.org.bukkit._Bukkit;
import com.arirangJS.Script.Classes.org.bukkit._ChatColor;
import com.arirangJS.Script.Classes.org.bukkit.inventory._Inventory;
import com.arirangJS.Util.FileSystem;
import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.event.block.Action;
import org.mozilla.javascript.*;
import org.mozilla.javascript.annotations.JSFunction;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Script {
    public String filename;
    public ArrayList<String> errors = new ArrayList();
    public Scriptable scope = null;

    public Script(String filename) {
        Context context = Context.enter();
        Scriptable scope = getScope(context);

        try {
            defineClass(scope);
            FileInputStream inStream = new FileInputStream(FileSystem.LOC_SCRIPT + filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream, "UTF-8"));
            context.evaluateReader(scope, reader, filename, 0, null);

            this.filename = filename;
            this.scope = scope;
        } catch (RhinoException e) {
            this.errors.add(e.getMessage());
            Debug.log(SyntaxHighlighter.highlight(FileSystem.readLine(FileSystem.LOC_SCRIPT + filename, e.lineNumber())));

            String gap = new String(new char[e.columnNumber()]).replace("\0", " ");
            Debug.log(gap + "| Here");
            Debug.danger(e.getMessage());
        } catch (IOException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            this.errors.add(e.getMessage());
            ErrReporter.send("err.compile", filename);
        } finally {
            Context.exit();
        }
    }

    public static String test(String code) {
        Context context = Context.enter();
        Scriptable scope = getScope(context);
        Object result = null;

        try {
            defineClass(scope);
            result = context.evaluateString(scope, code, "<test>", 1, null);
        } catch (RhinoException e) {
            Debug.log(SyntaxHighlighter.highlight(code));

            String gap = new String(new char[e.columnNumber()]).replace("\0", " ");
            Debug.log(gap + "| Here");
            Debug.danger(e.getMessage());
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            ErrReporter.send("err.compile", "<test>");
        } finally {
            Context.exit();
        }

        if (result == null) return null;
        return result.toString();
    }

    private static void defineClass(Scriptable scope) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        ScriptableObject.putProperty(scope, "Action", enumClassToObj(Action.class));
        ScriptableObject.putProperty(scope, "Biome", enumClassToObj(Biome.class));
        ScriptableObject.putProperty(scope, "BlockFace", enumClassToObj(BlockFace.class));
        ScriptableObject.defineClass(scope, _Bukkit.class);
        ScriptableObject.putProperty(scope, "ChatColor", constantsToObj(_ChatColor.class));
        ScriptableObject.putProperty(scope, "Difficulty", enumClassToObj(Difficulty.class));
        ScriptableObject.defineClass(scope, _Effect.class);
        ScriptableObject.putProperty(scope, "EntityType", enumClassToObj(EntityType.class));
        ScriptableObject.defineClass(scope, _Event.class);
        ScriptableObject.defineClass(scope, _Inventory.class);
        ScriptableObject.defineClass(scope, _Request.class);
        ScriptableObject.putProperty(scope, "Sound", enumClassToObj(Sound.class));
        ScriptableObject.putProperty(scope, "TreeType", enumClassToObj(TreeType.class));
        ScriptableObject.defineClass(scope, _Var.class);
        ScriptableObject.putProperty(scope, "WorldType", enumClassToObj(WorldType.class));
        ScriptableObject.putProperty(scope, "World.Environment", enumClassToObj(World.Environment.class));
    }

    private static Scriptable getScope(Context context) {
        Scriptable scope = context.initStandardObjects(new _TopClass(), false);
        String[] names = getJSFunctions(_TopClass.class);
        ((ScriptableObject) scope).defineFunctionProperties(names, _TopClass.class, ScriptableObject.DONTENUM);
        return scope;
    }

    private static ScriptableObject constantsToObj(Class<?> clazz) {
        ScriptableObject obj = new NativeObject();
        for (Field field : clazz.getFields()) {
            try {
                obj.putConst(field.getName(), obj, field.get(null));
            } catch (IllegalArgumentException | IllegalAccessException e) {
                ErrReporter.send("err.compile.translateObj");
                e.printStackTrace();
            }
        }
        return obj;
    }

    private static ScriptableObject enumClassToObj(Class<?> clazz) {
        ScriptableObject obj = new NativeObject();
        for (Object temp : clazz.getEnumConstants()) {
            try {
                Enum<?> _enum = (Enum<?>) temp;
                obj.putConst(_enum.name(), obj, _enum.ordinal());
            } catch (IllegalArgumentException e) {
                ErrReporter.send("err.compile.translateObj");
                e.printStackTrace();
            }
        }
        return obj;
    }

    private static String[] getJSFunctions(Class<? extends ScriptableObject> clazz) {
        ArrayList<String> result = new ArrayList();
        for (Method method : clazz.getMethods()) {
            if (method.getAnnotation(JSFunction.class) != null) {
                result.add(method.getName());
            }
        }
        return result.toArray(new String[0]);
    }
}
