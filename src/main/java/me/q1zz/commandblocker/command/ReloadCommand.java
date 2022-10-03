package me.q1zz.commandblocker.command;

import me.q1zz.commandblocker.configuration.PluginConfig;
import me.q1zz.commandblocker.helper.ChatHelper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {

    private PluginConfig pluginConfig;

    public ReloadCommand(PluginConfig pluginConfig) {
        this.pluginConfig = pluginConfig;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!sender.hasPermission("q1zz.commandblocker.reload")) {
            ChatHelper.sendMessage(sender, this.pluginConfig.getMessages().getNoPermission().replace("{PERMISSION}", "q1zz.commandblocker.reload"));
            return false;
        }

        this.pluginConfig.load();
        ChatHelper.sendMessage(sender, this.pluginConfig.getMessages().getSuccessReload());

        return false;
    }
}
