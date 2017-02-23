package com.arirangJS.Util;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

public class Misc {
    public static File[] getFileList(String dir) {
        return getFileList(new File(dir));
    }

    public static File[] getOnlyFileList(String dir) {
        return getOnlyFileList(new File(dir));
    }

    public static File[] getOnlyFileList(String dir, String... extension) {
        return getOnlyFileList(new File(dir), extension);
    }

    public static File[] getFileList(File dir) {
        if(dir == null)
            return new File[]{};

        if(!dir.isDirectory())
            return new File[]{};

        return dir.listFiles();
    }

    public static File[] getOnlyFileList(File dir) {
        if(dir == null)
            return new File[]{};

        if(!dir.isDirectory())
            return new File[]{};

        return dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });
    }

    public static File[] getOnlyFileList(File dir, String... extension) {
        if(dir == null)
            return new File[]{};

        if(!dir.isDirectory())
            return new File[]{};

        return dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                for(String arg : extension) {
                    if(file.getName().endsWith(arg))
                        if(file.isFile())
                            return true;
                }
                return false;
            }
        });
    }
}
