package org.abstruck.native_loader.library;

import com.sun.jna.Library;
import com.sun.jna.Native;
import org.abstruck.native_loader.library.logger.JNALogger;

/**
 * @author Goulixiaoji
 */
public class NativeLibrary {
    public static interface NativeClass extends Library {
        void onInitialize(JNALogger logger);
        void onInitializeClient(JNALogger logger);
        static NativeClass getInstance(String libName) {
            return (NativeClass) Native.load(libName, NativeClass.class);
        }
    }
}
