package me.q1zz.commandblocker.helper;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatHelper {

    private static final Pattern HEX_REGEX = Pattern.compile("#[a-fA-F0-9]{6}");

    @NotNull
    public static String fixColor(@NotNull String message) {
        if (message.isEmpty()) {
            return "";
        }
        for (Matcher matcher = HEX_REGEX.matcher(message); matcher.find(); matcher = HEX_REGEX.matcher(message)) {
            String color = message.substring(matcher.start(), matcher.end());
            message = message.replace(color, org.bukkit.ChatColor.valueOf(color) + "");
        }
        return ChatColor.translateAlternateColorCodes('&', message)
                .replace("<<", "«")
                .replace(">>", "»");
    }

    public static void sendMessage(@NotNull CommandSender sender, String message) {
        sender.sendMessage(fixColor(message));
    }

    public static void sendMessage(@NotNull CommandSender sender, List<String> message) {
        message.forEach(msg -> sendMessage(sender, msg));
    }


}
