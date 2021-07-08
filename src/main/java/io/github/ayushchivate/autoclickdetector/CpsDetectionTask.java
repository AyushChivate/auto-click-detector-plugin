package io.github.ayushchivate.autoclickdetector;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Map;
import java.util.UUID;

public class CpsDetectionTask extends BukkitRunnable {

    private final AutoClickDetectorPlugin plugin;
    private Map<UUID, Integer> playerCps;
    private CpsDetectionConfig cpsDetectionConfig;

    public CpsDetectionTask(AutoClickDetectorPlugin plugin, Map<UUID, Integer> playerCps) {
        this.plugin = plugin;
        this.playerCps = playerCps;
        this.cpsDetectionConfig = plugin.getCpsDetectionConfig();
    }

    @Override
    public void run() {

        for (Map.Entry<UUID, Integer> entry : this.playerCps.entrySet()) {

            if (entry.getValue() >= this.cpsDetectionConfig.getClicksPerSecond()) {
                Player player = Bukkit.getPlayer(entry.getKey());

                if (player != null) {
                    plugin.getLogger().severe(String.format("Alert! A player with the name of %s is " +
                            "clicking at a rate of %d clicks per second.", player.getName(), entry.getValue()));
                }
            }
        }

        this.playerCps.clear();
    }
}
