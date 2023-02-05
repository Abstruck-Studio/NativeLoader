package org.abstruck.native_loader;

import org.abstruck.native_loader.config.ModConfig;
import org.abstruck.native_loader.library.NativeLibrary;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Goulixiaoji
 */
public class Util {
    public static final Map<String, String> DIR_TO_NAME = new HashMap<>();

    public static void initLibs() {
        List<String> dirs = ModConfig.getLoadLibDirs();
        for (String filePath : dirs) {
            File file = new File(filePath);
            if (file.exists()) {
                System.load(file.getAbsolutePath());
                String fileName = filePath.substring(filePath.lastIndexOf("/")+1);
                String name = fileName.substring(0,fileName.lastIndexOf("."));
                DIR_TO_NAME.put(filePath, fileName);
            }
        }
    }

    public static List<NativeLibrary.NativeClass> getNativeClasses() {
        List<NativeLibrary.NativeClass> classes = new ArrayList<>();
        for (Map.Entry<String, String> entry : DIR_TO_NAME.entrySet()) {
            classes.add(NativeLibrary.NativeClass.getInstance(entry.getValue()));
        }
        return classes;
    }
}
