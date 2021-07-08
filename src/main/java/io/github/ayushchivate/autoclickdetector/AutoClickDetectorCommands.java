package io.github.ayushchivate.autoclickdetector;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AutoClickDetectorCommands implements CommandExecutor {

    AutoClickDetectorPlugin plugin;

    public AutoClickDetectorCommands(AutoClickDetectorPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length > 0 && args[0].equals("reload")) {

            if (sender.hasPermission("autoclickerdetector.reload")) {
                this.plugin.getCpsDetectionConfig().reloadConfig();
                sender.sendMessage("AutoClickDetector has been reloaded successfully!");
                return true;
            }

            sender.sendMessage("You do not have permissions to use this command!");
            return false;
        }

        sender.sendMessage("Not a valid command!");
        return false;
    }
}
