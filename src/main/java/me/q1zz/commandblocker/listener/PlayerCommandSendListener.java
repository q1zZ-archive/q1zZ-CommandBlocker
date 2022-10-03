package me.q1zz.commandblocker.listener;

import me.q1zz.commandblocker.configuration.PluginConfig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;

public class PlayerCommandSendListener implements Listener {

    private final PluginConfig pluginConfig;

    public PlayerCommandSendListener(PluginConfig pluginConfig) {
        this.pluginConfig = pluginConfig;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCmdSend(PlayerCommandSendEvent event) {
        if(!event.getPlayer().hasPermission("q1zz.commandblocker.bypass")) {
            event.getCommands().removeAll(this.pluginConfig.getBlockedCommands());
        }
    }

}
