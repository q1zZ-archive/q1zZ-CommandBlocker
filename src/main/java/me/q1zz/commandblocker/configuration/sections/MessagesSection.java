package me.q1zz.commandblocker.configuration.sections;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.configs.annotation.CustomKey;

import java.util.Collections;
import java.util.List;

public class MessagesSection extends OkaeriConfig {

    @Comment("PL: Wiadomość o pomyślnym przeładowaniu konfiguracji.")
    @Comment("EN: Message when successfully reloaded configuration.")
    @CustomKey("reload-success")
    private String successReload = "&aYou successfully reloaded configuration!";

    @Comment("PL: Wiadomość do gracza gdy użyta komenda jest zablokowana.")
    @Comment("EN: Message to the player when the command used is blocked.")
    @CustomKey("blocked-message")
    private List<String> blockedMessage = Collections.singletonList("&cYou don't have permission to use this command!");

    @Comment("PL: Wiadomość gdy gracz nie ma permisji.")
    @Comment("EN: Message when player doesn't have permission.")
    @CustomKey("no-permission")
    private String noPermission = "&cYou don't have permission to do this!";

    public String getSuccessReload() {
        return successReload;
    }

    public List<String> getBlockedMessage() {
        return blockedMessage;
    }

    public String getNoPermission() {
        return noPermission;
    }
}
