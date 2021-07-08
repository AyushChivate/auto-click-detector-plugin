package io.github.ayushchivate.autoclickdetector;

import net.dohaw.corelib.CoreLib;
import net.dohaw.corelib.JPUtils;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class AutoClickDetectorPlugin extends JavaPlugin {

    private CpsDetectionConfig cpsDetectionConfig;

    @Override
    public void onEnable() {
        CoreLib.setInstance(this);
        getDataFolder().mkdirs();
        validateFiles("config.yml");
        JPUtils.validateFiles("config.yml");
        this.cpsDetectionConfig = new CpsDetectionConfig();
        JPUtils.registerEvents(new PlayerWatcher(this));
        JPUtils.registerCommand("autoclickdetector", new AutoClickDetectorCommands(this));
    }

    public CpsDetectionConfig getCpsDetectionConfig() {
        return cpsDetectionConfig;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void validateFiles(String... fileNames){
        for(String name : fileNames){
            File file = new File(this.getDataFolder(), name);
            if(!file.exists()){
                this.saveResource(name, false);
            }
        }
    }
}