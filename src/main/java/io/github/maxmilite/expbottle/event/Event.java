package io.github.maxmilite.expbottle.event;

import io.github.maxmilite.expbottle.bottle.BottleMethod;
import io.github.maxmilite.expbottle.inventory.GuiMenu;
import io.github.maxmilite.expbottle.message.Message;
import io.github.maxmilite.expbottle.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.InventoryView;

public class Event implements Listener {

    public Message message = new Message();
    public BottleMethod bottleMethod = new BottleMethod();
    public GuiMenu guiMenu = new GuiMenu();
    public Utils utils = new Utils();

    public void sendSuccess(Player player) {
        player.sendMessage(message.prefix + "操作成功.");
    }

    public void sendFailure(Player player) {
        player.sendMessage(message.prefix + message.error + "操作失败，可能是不合法的操作.");
    }

    @EventHandler
    public void interactEvent(PlayerInteractEvent e) {
        if (!(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK))
            return;
        if (e.getHand() != EquipmentSlot.HAND)
            return;
        if (bottleMethod.isExpBottle(e.getItem()) == 2) {
            e.getPlayer().sendMessage(message.prefix + "请仅手持一个经验之瓶打开.");
            e.setCancelled(true);
            e.setUseItemInHand(org.bukkit.event.Event.Result.DENY);
        }
        if (bottleMethod.isExpBottle(e.getItem()) != 0)
            return;
        guiMenu.createMenu(e.getPlayer(), 0);
        e.setCancelled(true);
        e.setUseItemInHand(org.bukkit.event.Event.Result.DENY);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        InventoryView view = player.getOpenInventory();
        if (view.getTitle().equals(message.title) || view.getTitle().equals(ChatColor.GREEN + "经验之瓶 (修改等级)")) {
            e.setCancelled(true);
        }
        if (view.getTitle().equals(message.title)) {
            int bottleValue = bottleMethod.getExpValue(player.getInventory().getItemInMainHand());
            int slot = e.getRawSlot();
            switch (slot) {
                case 9:
                    if (utils.ifValid(player, 1, guiMenu.valueToChange, bottleValue)) {
                        utils.HandleOperation(player, 1, guiMenu.valueToChange, bottleValue);
                        sendSuccess(player);
                        player.closeInventory();
                        player.playSound(
                                player.getLocation(),
                                Sound.ENTITY_PLAYER_LEVELUP,
                                SoundCategory.PLAYERS,
                                1,
                                1
                        );
                    } else {
                        sendFailure(player);
                        player.closeInventory();
                        player.playSound(
                                player.getLocation(),
                                Sound.ENTITY_PLAYER_LEVELUP,
                                SoundCategory.PLAYERS,
                                1,
                                1
                        );
                    }
                    break;
                case 10:
                    if (utils.ifValid(player, 2, guiMenu.valueToChange, bottleValue)) {
                        utils.HandleOperation(player, 2, guiMenu.valueToChange, bottleValue);
                        sendSuccess(player);
                        player.closeInventory();
                        player.playSound(
                                player.getLocation(),
                                Sound.ENTITY_PLAYER_LEVELUP,
                                SoundCategory.PLAYERS,
                                1,
                                1
                        );
                    } else {
                        sendFailure(player);
                        player.closeInventory();
                        player.playSound(
                                player.getLocation(),
                                Sound.ENTITY_PLAYER_LEVELUP,
                                SoundCategory.PLAYERS,
                                1,
                                1
                        );
                    }
                    break;
                case 11:
                    if (utils.ifValid(player, 3, guiMenu.valueToChange, bottleValue)) {
                        utils.HandleOperation(player, 3, guiMenu.valueToChange, bottleValue);
                        sendSuccess(player);
                        player.closeInventory();
                        player.playSound(
                                player.getLocation(),
                                Sound.ENTITY_PLAYER_LEVELUP,
                                SoundCategory.PLAYERS,
                                1,
                                1
                        );
                    } else {
                        sendFailure(player);
                        player.closeInventory();
                        player.playSound(
                                player.getLocation(),
                                Sound.ENTITY_PLAYER_LEVELUP,
                                SoundCategory.PLAYERS,
                                1,
                                1
                        );
                    }
                    break;
                case 12:
                    if (utils.ifValid(player, 4, guiMenu.valueToChange, bottleValue)) {
                        utils.HandleOperation(player, 4, guiMenu.valueToChange, bottleValue);
                        sendSuccess(player);
                        player.closeInventory();
                        player.playSound(
                                player.getLocation(),
                                Sound.ENTITY_PLAYER_LEVELUP,
                                SoundCategory.PLAYERS,
                                1,
                                1
                        );
                    } else {
                        sendFailure(player);
                        player.closeInventory();
                        player.playSound(
                                player.getLocation(),
                                Sound.ENTITY_PLAYER_LEVELUP,
                                SoundCategory.PLAYERS,
                                1,
                                1
                        );
                    }
                    break;
                case 14:
                    if (utils.ifValid(player, 5, guiMenu.valueToChange, bottleValue)) {
                        utils.HandleOperation(player, 5, guiMenu.valueToChange, bottleValue);
                        sendSuccess(player);
                        player.closeInventory();
                        player.playSound(
                                player.getLocation(),
                                Sound.ENTITY_PLAYER_LEVELUP,
                                SoundCategory.PLAYERS,
                                1,
                                1
                        );
                    } else {
                        sendFailure(player);
                        player.closeInventory();
                        player.playSound(
                                player.getLocation(),
                                Sound.ENTITY_PLAYER_LEVELUP,
                                SoundCategory.PLAYERS,
                                1,
                                1
                        );
                    }
                    break;
                case 15:
                    if (utils.ifValid(player, 6, guiMenu.valueToChange, bottleValue)) {
                        utils.HandleOperation(player, 6, guiMenu.valueToChange, bottleValue);
                        sendSuccess(player);
                        player.closeInventory();
                        player.playSound(
                                player.getLocation(),
                                Sound.ENTITY_PLAYER_LEVELUP,
                                SoundCategory.PLAYERS,
                                1,
                                1
                        );
                    } else {
                        sendFailure(player);
                        player.closeInventory();
                        player.playSound(
                                player.getLocation(),
                                Sound.ENTITY_PLAYER_LEVELUP,
                                SoundCategory.PLAYERS,
                                1,
                                1
                        );
                    }
                    break;
                case 16:
                    if (utils.ifValid(player, 7, guiMenu.valueToChange, bottleValue)) {
                        utils.HandleOperation(player, 7, guiMenu.valueToChange, bottleValue);
                        sendSuccess(player);
                        player.closeInventory();
                        player.playSound(
                                player.getLocation(),
                                Sound.ENTITY_PLAYER_LEVELUP,
                                SoundCategory.PLAYERS,
                                1,
                                1
                        );
                    } else {
                        sendFailure(player);
                        player.closeInventory();
                        player.playSound(
                                player.getLocation(),
                                Sound.ENTITY_PLAYER_LEVELUP,
                                SoundCategory.PLAYERS,
                                1,
                                1
                        );
                    }
                    break;
                case 17:
                    if (utils.ifValid(player, 8, guiMenu.valueToChange, bottleValue)) {
                        utils.HandleOperation(player, 8, guiMenu.valueToChange, bottleValue);
                        sendSuccess(player);
                        player.closeInventory();
                        player.playSound(
                                player.getLocation(),
                                Sound.ENTITY_PLAYER_LEVELUP,
                                SoundCategory.PLAYERS,
                                1,
                                1
                        );
                    } else {
                        sendFailure(player);
                        player.closeInventory();
                        player.playSound(
                                player.getLocation(),
                                Sound.ENTITY_PLAYER_LEVELUP,
                                SoundCategory.PLAYERS,
                                1,
                                1
                        );
                    }
                    break;
                case 31:
                    player.closeInventory();
                    break;
                case 32:
                    player.closeInventory();
                    guiMenu.createChange(player, guiMenu.valueToChange);
                    break;
                default:
                    break;
            }
        } else if (view.getTitle().equals(ChatColor.GREEN + "经验之瓶 (修改等级)")) {
            int slot = e.getRawSlot();
            int val;
            switch (slot) {
                case 9:
                    guiMenu.setValue(guiMenu.getValue() - 1000);
                    break;
                case 10:
                    guiMenu.setValue(guiMenu.getValue() - 100);
                    break;
                case 11:
                    guiMenu.setValue(guiMenu.getValue() - 10);
                    break;
                case 12:
                    guiMenu.setValue(guiMenu.getValue() - 1);
                    break;
                case 14:
                    guiMenu.setValue(guiMenu.getValue() + 1);
                    break;
                case 15:
                    guiMenu.setValue(guiMenu.getValue() + 10);
                    break;
                case 16:
                    guiMenu.setValue(guiMenu.getValue() + 100);
                    break;
                case 17:
                    guiMenu.setValue(guiMenu.getValue() + 1000);
                    break;
                case 31:
                    val = guiMenu.prevValue;
                    player.closeInventory();
                    guiMenu.createMenu(player, val);
                    break;
                case 35:
                    val = guiMenu.valueToChange;
                    player.closeInventory();
                    guiMenu.createMenu(player, val);
                    break;
                default:
                    break;
            }
        }
    }
}
