package org.abstruck.native_loader.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import org.abstruck.native_loader.NativeLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Goulixiaoji
 */
@Config(name = NativeLoader.MOD_ID)
@Config.Gui.Background("minecraft:textures/block/dirt.png")
public class ModConfig implements ConfigData {
    public static ModConfig get() {
        return AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }

    public static void save() {
        AutoConfig.getConfigHolder(ModConfig.class).save();
    }

    public static List<String> getLoadLibDirs() {
        ModConfig config = ModConfig.get();
        return config.loadLibDirs;
    }

    @ConfigEntry.Gui.PrefixText
    public List<String> loadLibDirs = new ArrayList<>();
}
