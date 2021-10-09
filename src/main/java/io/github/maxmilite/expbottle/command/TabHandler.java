package io.github.maxmilite.expbottle.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TabHandler implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String string, String[] args) {
        if (!(sender instanceof Player)) {
            return null;
        }
        switch (args.length) {
            case 1:
                return Arrays.asList(
                        "getitem",
                        "set"
                );

            case 2:
                if (args[0].equals("set"))
                    return Collections.singletonList("<value>");
                else
                    return null;
            default:
                return null;
        }
    }
}
