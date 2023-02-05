package org.abstruck.native_loader.client;

import com.sun.jna.JNIEnv;
import net.fabricmc.api.ClientModInitializer;
import org.abstruck.native_loader.Util;
import org.abstruck.native_loader.library.NativeLibrary;
import org.abstruck.native_loader.library.logger.JNALogger;

import java.io.File;
import java.util.List;

/**
 * @author Goulixiaoji
 */
public class NativeLoaderClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        List<NativeLibrary.NativeClass> nativeClasses = Util.getNativeClasses();
        for (NativeLibrary.NativeClass nativeClass: nativeClasses){
            nativeClass.onInitializeClient(new JNALogger());
        }
    }
}
