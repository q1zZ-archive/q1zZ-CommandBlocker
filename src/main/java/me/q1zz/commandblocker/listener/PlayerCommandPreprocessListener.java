package me.q1zz.commandblocker.listener;

import me.q1zz.commandblocker.configuration.PluginConfig;
import me.q1zz.commandblocker.helper.ChatHelper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommandPreprocessListener implements Listener {

    private final PluginConfig pluginConfig;

    public PlayerCommandPreprocessListener(PluginConfig pluginConfig) {
        this.pluginConfig = pluginConfig;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCmdPreproces(PlayerCommandPreprocessEvent event) {

        final Player player = event.getPlayer();

        if(player.hasPermission("q1zz.commandblocker.bypass")) {
            return;
        }

        final String[] message = event.getMessage().split(" ");

        if(!this.pluginConfig.isBlockedCommand(message[0])) {
            return;
        }

        event.setCancelled(true);
        ChatHelper.sendMessage(player, this.pluginConfig.getMessages().getBlockedMessage());
    }
}
