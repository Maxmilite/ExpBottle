package io.github.maxmilite.expbottle.inventory;

import io.github.maxmilite.expbottle.enchantments.BottleEnchantment;
import io.github.maxmilite.expbottle.item.ExperienceBottle;
import io.github.maxmilite.expbottle.message.Message;
import io.github.maxmilite.expbottle.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class GuiMenu {

    public Message message = new Message();
    public ExperienceBottle experienceBottle = new ExperienceBottle();
    public BottleEnchantment bottleEnchantment = new BottleEnchantment();
    public Enchantment enchantment = bottleEnchantment.getEnchantment();
    public int valueToChange;
    public int prevValue;
    public Inventory menuInv;
    public Utils utils = new Utils();

    public ItemStack midBottle;
    public ItemStack depositLevel = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
    public ItemStack depositToLevel = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
    public ItemStack depositExp = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
    public ItemStack depositAll = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
    public ItemStack withDrawLevel = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
    public ItemStack withDrawToLevel = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
    public ItemStack withDrawExp = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
    public ItemStack withDrawAll = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
    public ItemStack closeMenu = new ItemStack(Material.BARRIER, 1);
    public ItemStack currentValue = new ItemStack(Material.ENDER_EYE, 1);
    public ItemStack helpItem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
    public ItemStack selectValue = new ItemStack(Material.NETHER_STAR, 1);

    public ItemStack plus1 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
    public ItemStack plus10 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
    public ItemStack plus100 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
    public ItemStack plus1000 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
    public ItemStack div1 = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
    public ItemStack div10 = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
    public ItemStack div100 = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
    public ItemStack div1000 = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);

    public ItemStack confirm = new ItemStack(Material.NETHER_STAR, 1);

    public ItemMeta changeName(ItemStack item, String string) {
        ItemMeta itemMeta = item.getItemMeta();
        Objects.requireNonNull(itemMeta).setDisplayName(string);
        itemMeta.addEnchant(enchantment, 1, true);
        return itemMeta;
    }

    public ItemMeta changeValue(ItemStack item, int x) {
        ItemMeta itemMeta = item.getItemMeta();
        Objects.requireNonNull(itemMeta).setLore(Collections.singletonList(ChatColor.AQUA + Integer.toString(x)));
        return itemMeta;
    }

    public int getValue() {
        return valueToChange;
    }

    public void setValue(int x) {
        if (x < 0)
            x = 0;
        if (x > utils.maxExp)
            x = utils.maxExp;
        valueToChange = x;
        currentValue.setItemMeta(changeValue(currentValue, x));
        menuInv.setItem(13, currentValue);
    }

    public void setHelp() {
        ItemMeta itemMeta = helpItem.getItemMeta();
        Objects.requireNonNull(itemMeta).setDisplayName(ChatColor.LIGHT_PURPLE + "??????");
        itemMeta.setLore(Arrays.asList(
                ChatColor.YELLOW + "???????????????????????????????????? ?????????????????? ",
                ChatColor.YELLOW + "????????????????????? ?????????????????? ????????????",
                ChatColor.YELLOW + "?????????????????????????????????????????????",
                ChatColor.YELLOW + "???????????????????????? ???????????? ",
                ChatColor.YELLOW + "????????????????????? ???????????? ?????????",
                ChatColor.YELLOW + "???????????? ?????????????????? ?????????????????????",
                ChatColor.YELLOW + "???????????????????????????????????????????????????",
                ChatColor.YELLOW + "?????????????????????????????????",
                ChatColor.RED + "???????????????????????????????????? 1000???",
                ChatColor.RED + "???????????????????????????????????????"
        ));
        helpItem.setItemMeta(itemMeta);
    }

    public GuiMenu() {
        depositLevel.setItemMeta(changeName(depositLevel, ChatColor.YELLOW + "???????????????????????????"));
        depositToLevel.setItemMeta(changeName(depositToLevel, ChatColor.YELLOW + "???????????????????????????????????????"));
        depositExp.setItemMeta(changeName(depositExp, ChatColor.YELLOW + "???????????????????????????"));
        depositAll.setItemMeta(changeName(depositAll, ChatColor.YELLOW + "??????????????????"));
        withDrawLevel.setItemMeta(changeName(withDrawLevel, ChatColor.YELLOW + "???????????????????????????"));
        withDrawToLevel.setItemMeta(changeName(withDrawToLevel, ChatColor.YELLOW + "???????????????????????????????????????"));
        withDrawExp.setItemMeta(changeName(withDrawExp, ChatColor.YELLOW + "???????????????????????????"));
        withDrawAll.setItemMeta(changeName(withDrawAll, ChatColor.YELLOW + "??????????????????"));
        closeMenu.setItemMeta(changeName(closeMenu, ChatColor.YELLOW + "????????????"));
        currentValue.setItemMeta(changeName(currentValue, ChatColor.YELLOW + "????????????: "));
        selectValue.setItemMeta(changeName(currentValue, ChatColor.YELLOW + "????????????"));
        currentValue.setItemMeta(changeValue(currentValue, 0));
        confirm.setItemMeta(changeName(confirm, ChatColor.YELLOW + "??????"));

        plus1.setItemMeta(changeName(plus1, ChatColor.GREEN + "+1"));
        plus10.setItemMeta(changeName(plus10, ChatColor.GREEN + "+10"));
        plus100.setItemMeta(changeName(plus100, ChatColor.GREEN + "+100"));
        plus1000.setItemMeta(changeName(plus1000, ChatColor.GREEN + "+1000"));
        div1.setItemMeta(changeName(div1, ChatColor.RED + "-1"));
        div10.setItemMeta(changeName(div10, ChatColor.RED + "-10"));
        div100.setItemMeta(changeName(div100, ChatColor.RED + "-100"));
        div1000.setItemMeta(changeName(div1000, ChatColor.RED + "-1000"));
        setHelp();
        valueToChange = 0;
    }

    public void createMenu(Player player, int value) {
        menuInv = Bukkit.createInventory(player, 36, message.title);
        PlayerInventory playerInventory = player.getInventory();
        midBottle = playerInventory.getItemInMainHand();
        for (int i = 0; i < 36; ++i)
            menuInv.setItem(i, helpItem);
        menuInv.setItem(13, midBottle);
        menuInv.setItem(9, depositLevel);
        menuInv.setItem(10, depositToLevel);
        menuInv.setItem(11, depositExp);
        menuInv.setItem(12, depositAll);
        menuInv.setItem(14, withDrawLevel);
        menuInv.setItem(15, withDrawToLevel);
        menuInv.setItem(16, withDrawExp);
        menuInv.setItem(17, withDrawAll);
        menuInv.setItem(31, closeMenu);
        currentValue.setItemMeta(changeValue(currentValue, value));
        menuInv.setItem(30, currentValue);
        menuInv.setItem(32, selectValue);
        valueToChange = value;
        player.openInventory(menuInv);
    }

    public void createChange(Player player, int prev) {
        prevValue = prev;
        valueToChange = 0;
        menuInv = Bukkit.createInventory(player, 36, ChatColor.GREEN + "???????????? (????????????)");
        PlayerInventory playerInventory = player.getInventory();
        midBottle = playerInventory.getItemInMainHand();
        for (int i = 0; i < 36; ++i)
            menuInv.setItem(i, helpItem);
        currentValue.setItemMeta(changeValue(currentValue, 0));
        menuInv.setItem(13, currentValue);
        menuInv.setItem(14, plus1);
        menuInv.setItem(15, plus10);
        menuInv.setItem(16, plus100);
        menuInv.setItem(17, plus1000);
        menuInv.setItem(12, div1);
        menuInv.setItem(11, div10);
        menuInv.setItem(10, div100);
        menuInv.setItem(9, div1000);
        closeMenu.setItemMeta(changeName(closeMenu, ChatColor.YELLOW + "??????"));
        menuInv.setItem(31, closeMenu);
        menuInv.setItem(35, confirm);
        player.openInventory(menuInv);
    }
}
