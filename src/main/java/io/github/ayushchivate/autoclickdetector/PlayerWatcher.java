package io.github.ayushchivate.autoclickdetector;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerWatcher implements Listener {

    private final AutoClickDetectorPlugin plugin;
    private Map<UUID, Integer> playerCps;


    public PlayerWatcher(AutoClickDetectorPlugin plugin) {
        this.plugin = plugin;
        this.playerCps = new HashMap<>();
        new CpsDetectionTask(this.plugin, this.playerCps).runTaskTimer(this.plugin, 0, 20);
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        if (this.playerCps.containsKey(player.getUniqueId())) {
            Integer i = this.playerCps.get(player.getUniqueId());
            i++;
            this.playerCps.put(player.getUniqueId(), i);
        } else {
            this.playerCps.put(player.getUniqueId(), 1);
        }
    }
}
