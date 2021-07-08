package io.github.ayushchivate.autoclickdetector;

import net.dohaw.corelib.Config;

public class CpsDetectionConfig extends Config {

    public CpsDetectionConfig() {
        super("config.yml");
    }

    public int getClicksPerSecond() {
        return config.getInt("Clicks Per Second", 14);
    }
}
