package com.arirangJS.Util;

import java.io.File;
import java.io.FileFilter;

public class Misc {
    public static File[] getFileList(String dir) {
        return getFileList(new File(dir));
    }

    public static File[] getOnlyFileList(String dir) {
        return getOnlyFileList(new File(dir));
    }

    public static File[] getFileList(File dir) {
        if (dir == null)
            return new File[]{};

        if (!dir.isDirectory())
            return new File[]{};

        return dir.listFiles();
    }

    public static File[] getOnlyFileList(File dir) {
        if (dir == null)
            return new File[]{};

        if (!dir.isDirectory())
            return new File[]{};

        return dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });
    }
}
