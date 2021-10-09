package io.github.maxmilite.expbottle.command;

import io.github.maxmilite.expbottle.bottle.BottleMethod;
import io.github.maxmilite.expbottle.item.ExperienceBottle;
import io.github.maxmilite.expbottle.message.Message;
import io.github.maxmilite.expbottle.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class CommandHandler implements CommandExecutor {

    public Message message = new Message();
    public ExperienceBottle experienceBottle = new ExperienceBottle();
    public BottleMethod bottleMethod = new BottleMethod();
    public Utils utils = new Utils();

    public void notValid(CommandSender sender) {
        sender.sendMessage(message.prefix + message.error + "命令无效.");
    }

    public void nullException(CommandSender sender) {
        sender.sendMessage(message.prefix + message.error + "运行时出现错误，可能是由于服务器卡顿导致.");
    }

    public void giveItem(CommandSender sender) {
        String name = sender.getName();
        Player player = Bukkit.getPlayer(name);
        if (player == null) {
            nullException(sender);
            return;
        }
        Inventory inventory = player.getInventory();
        inventory.addItem(experienceBottle.bottle);
        player.playSound(
                player.getLocation(),
                Sound.ENTITY_PLAYER_LEVELUP,
                SoundCategory.PLAYERS,
                1,
                1
        );
        sender.sendMessage(message.prefix + "已给予 " + name + " 一个经验之瓶.");
    }

    public void setExperience(CommandSender sender, int value) {
        String name = sender.getName();
        Player player = Bukkit.getPlayer(name);
        if (player == null) {
            nullException(sender);
            return;
        }
        PlayerInventory playerInventory = player.getInventory();
        ItemStack itemStack = playerInventory.getItemInMainHand();
        if (bottleMethod.isExpBottle(itemStack) != 0) {
            bottleMethod.exceptionMessage(sender, bottleMethod.isExpBottle(itemStack));
            return;
        }
        playerInventory.setItemInMainHand(bottleMethod.setExpValue(itemStack, value));
        player.playSound(
                player.getLocation(),
                Sound.ENTITY_PLAYER_LEVELUP,
                SoundCategory.PLAYERS,
                1,
                1
        );
        player.sendMessage(message.prefix + "已设置当前经验之瓶经验为 " + value + ".");
    }

    public void getExperience(CommandSender sender) {
        String name = sender.getName();
        Player player = Bukkit.getPlayer(name);
        if (player == null) {
            nullException(sender);
            return;
        }
        PlayerInventory playerInventory = player.getInventory();
        ItemStack itemStack = playerInventory.getItemInMainHand();
        if (bottleMethod.isExpBottle(itemStack) != 0) {
            bottleMethod.exceptionMessage(sender, bottleMethod.isExpBottle(itemStack));
            return;
        }
        player.playSound(
                player.getLocation(),
                Sound.ENTITY_PLAYER_LEVELUP,
                SoundCategory.PLAYERS,
                1,
                1
        );
        player.sendMessage(message.prefix + "当前经验之瓶经验为 " + bottleMethod.getExpValue(itemStack) + ".");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            notValid(sender);
            return true;
        }
        int v;
        switch (args[0]) {
            case "getitem":
                giveItem(sender);
                break;
            case "set":
                if (args.length == 1) {
                    notValid(sender);
                    return true;
                }
                if (!args[1].matches("[0-9]+")) {
                    notValid(sender);
                    return true;
                }
                if (args[1].length() >= 8) {
                    sender.sendMessage(message.prefix + message.error + "请输入一个合法的数字 (0 ~ 9999999).");
                    return true;
                }
                v = Integer.parseInt(args[1]);
                setExperience(sender, v);
                break;
            case "get":
                getExperience(sender);
                break;
            case "debug":
                v = Integer.parseInt(args[1]);
                sender.sendMessage(message.prefix + utils.getExp(v));
                break;
            default:
                notValid(sender);
                break;
        }
        return true;
    }
}
