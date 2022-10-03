package me.q1zz.commandblocker.configuration;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.configs.annotation.CustomKey;
import eu.okaeri.configs.annotation.Header;
import me.q1zz.commandblocker.configuration.sections.MessagesSection;

import java.util.Arrays;
import java.util.List;

@Header("######################################################################")
@Header("#                                                                    #")
@Header("#                     q1zZ-CommandBlocker                            #")
@Header("#                          by q1zZ                                   #")
@Header("#                                                                    #")
@Header("#                       Permissions:                                 #")
@Header("#   q1zz.commandblocker.bypass - bypassing blocked commands.         #")
@Header("#   q1zz.commandblocker.reload - access to reload command.           #")
@Header("#                                                                    #")
@Header("#                        Commands:                                   #")
@Header("#   /q1zz-reload - reloading configuration.                          #")
@Header("#                                                                    #")
@Header("######################################################################")
public class PluginConfig extends OkaeriConfig {

    @Comment("PL: Zablokowane komendy")
    @Comment("EN: Blocked commands")
    @CustomKey("blocked-commands")
    private List<String> blockedCommands = Arrays.asList("pl", "plugins", "ver", "version", "about");

    @Comment("PL: Konfiguracja wiadomości.")
    @Comment("EN: Messages configuration.")
    private MessagesSection messages = new MessagesSection();

    public List<String> getBlockedCommands() {
        return blockedCommands;
    }

    public boolean isBlockedCommand(String command) {
        return this.getBlockedCommands().stream().filter(cmd -> command.equalsIgnoreCase("/" + cmd)).findFirst().orElse(null) != null;
    }

    public MessagesSection getMessages() {
        return messages;
    }
}
