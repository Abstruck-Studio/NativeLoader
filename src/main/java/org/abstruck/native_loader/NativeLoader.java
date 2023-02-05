package org.abstruck.native_loader;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import org.abstruck.native_loader.config.ModConfig;
import org.abstruck.native_loader.library.NativeLibrary;
import org.abstruck.native_loader.library.logger.JNALogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author Goulixiaoji
 */
public class NativeLoader implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger(NativeLoader.class);
    public static final String MOD_ID = "native_loader";

    @Override
    public void onInitialize() {
        LOGGER.info("Welcome to use Native Library!");
        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
        Util.initLibs();
        List<NativeLibrary.NativeClass> nativeClasses = Util.getNativeClasses();
        for (NativeLibrary.NativeClass nativeClass: nativeClasses){
            nativeClass.onInitialize(new JNALogger());
        }
    }

}
