package io.github.maxmilite.expbottle.bottle;

import io.github.maxmilite.expbottle.message.Message;
import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Objects;

public class BottleMethod {


    public Message message = new Message();

    public String error = message.prefix + message.error;

    public int isExpBottle(ItemStack item) {
        if (item == null)
            return -1;
        if (item.getType() != Material.EXPERIENCE_BOTTLE)
            return 1;
        if (item.getAmount() != 1)
            return 2;
        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta == null)
            return -1;
        if (!itemMeta.getDisplayName().equals(ChatColor.GOLD + "经验之瓶"))
            return 3;
        return 0;
    }

    public void exceptionMessage(CommandSender commandSender, int x) {
        String name = commandSender.getName();
        Player player = Bukkit.getPlayer(name);
        exceptionMessage(player, x);
    }

    public void exceptionMessage(Player player, int x) {
        player.playSound(
                player.getLocation(),
                Sound.ENTITY_PLAYER_LEVELUP,
                SoundCategory.PLAYERS,
                1,
                1
        );
        switch (x) {
            case -1:
                player.sendMessage(error + "运行时出现错误，可能是由于服务器卡顿导致.");
                break;
            case 1:
                player.sendMessage(error + "手持的物品不是经验之瓶.");
                break;
            case 2:
                player.sendMessage(error + "请确保手中仅手持一个经验之瓶.");
                break;
            case 3:
                player.sendMessage(error + "手持的是一个假瓶子.");
                break;
        }
    }

    public int getExpValue(ItemStack item) {
        ItemMeta itemMeta = item.getItemMeta();
        int res = 0;
        if (itemMeta != null) {
            res = Integer.parseInt(Objects.requireNonNull(itemMeta.getLore()).get(3).substring(2));
        }
        return res;
    }

    public ItemStack setExpValue(ItemStack item, int x) {
        if (x < 0)
            x = 0;
        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta != null) {
            List<String> list = itemMeta.getLore();
            Objects.requireNonNull(list).set(3, ChatColor.YELLOW + Integer.toString(x));
            itemMeta.setLore(list);
        }
        item.setItemMeta(itemMeta);
        return item;
    }
}
