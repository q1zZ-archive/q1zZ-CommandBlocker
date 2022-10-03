package me.q1zz.commandblocker;

import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.yaml.bukkit.YamlBukkitConfigurer;
import me.q1zz.commandblocker.command.ReloadCommand;
import me.q1zz.commandblocker.configuration.PluginConfig;
import me.q1zz.commandblocker.listener.PlayerCommandPreprocessListener;
import me.q1zz.commandblocker.listener.PlayerCommandSendListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class CommandBlockerPlugin extends JavaPlugin {

    private PluginConfig pluginConfig;

    @Override
    public void onEnable() {

        this.initConfig();
        this.registerListener();
        this.registerCommand();

    }

    private void registerListener() {

        PluginManager manager = this.getServer().getPluginManager();

        manager.registerEvents(new PlayerCommandPreprocessListener(this.pluginConfig), this);
        manager.registerEvents(new PlayerCommandSendListener(this.pluginConfig), this);

    }

    private void registerCommand() {
        this.getCommand("q1zz-reload").setExecutor(new ReloadCommand(this.pluginConfig));
    }

    private void initConfig() {
        this.pluginConfig = ConfigManager.create(PluginConfig.class, (it) -> {
            it.withConfigurer(new YamlBukkitConfigurer());
            it.withBindFile(new File(this.getDataFolder(), "configuration.yml"));
            it.withRemoveOrphans(true);
            it.saveDefaults();
            it.load(true);
        });
    }

}
