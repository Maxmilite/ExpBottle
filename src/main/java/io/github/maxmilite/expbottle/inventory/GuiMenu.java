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
        Objects.requireNonNull(itemMeta).setDisplayName(ChatColor.LIGHT_PURPLE + "帮助");
        itemMeta.setLore(Arrays.asList(
                ChatColor.YELLOW + "打开界面后，首先选择屏障 “取消按钮” ",
                ChatColor.YELLOW + "右边的下界之星 “更改数值” 更改信息",
                ChatColor.YELLOW + "之后通过加减选择，完成以后点击",
                ChatColor.YELLOW + "最右边的下界之星 “确认” ",
                ChatColor.YELLOW + "返回后您可以在 取消按钮 左边的",
                ChatColor.YELLOW + "末影之眼 “当前数值” 中看到选择情况",
                ChatColor.YELLOW + "返回后点击经验瓶旁的玻璃板选择类型",
                ChatColor.YELLOW + "如果不出意外，操作完成",
                ChatColor.RED + "注意：经验瓶的最大容量为 1000，",
                ChatColor.RED + "多余的经验不会进行任何操作"
        ));
        helpItem.setItemMeta(itemMeta);
    }

    public GuiMenu() {
        depositLevel.setItemMeta(changeName(depositLevel, ChatColor.YELLOW + "存入一定等级的经验"));
        depositToLevel.setItemMeta(changeName(depositToLevel, ChatColor.YELLOW + "存入经验至玩家达到一定等级"));
        depositExp.setItemMeta(changeName(depositExp, ChatColor.YELLOW + "存入一定数量的经验"));
        depositAll.setItemMeta(changeName(depositAll, ChatColor.YELLOW + "存入全部经验"));
        withDrawLevel.setItemMeta(changeName(withDrawLevel, ChatColor.YELLOW + "取出一定等级的经验"));
        withDrawToLevel.setItemMeta(changeName(withDrawToLevel, ChatColor.YELLOW + "取出经验至玩家达到一定等级"));
        withDrawExp.setItemMeta(changeName(withDrawExp, ChatColor.YELLOW + "取出一定数量的经验"));
        withDrawAll.setItemMeta(changeName(withDrawAll, ChatColor.YELLOW + "取出全部经验"));
        closeMenu.setItemMeta(changeName(closeMenu, ChatColor.YELLOW + "关闭窗口"));
        currentValue.setItemMeta(changeName(currentValue, ChatColor.YELLOW + "当前数值: "));
        selectValue.setItemMeta(changeName(currentValue, ChatColor.YELLOW + "更改数值"));
        currentValue.setItemMeta(changeValue(currentValue, 0));
        confirm.setItemMeta(changeName(confirm, ChatColor.YELLOW + "确认"));

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
        menuInv = Bukkit.createInventory(player, 36, ChatColor.GREEN + "经验之瓶 (修改等级)");
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
        closeMenu.setItemMeta(changeName(closeMenu, ChatColor.YELLOW + "取消"));
        menuInv.setItem(31, closeMenu);
        menuInv.setItem(35, confirm);
        player.openInventory(menuInv);
    }
}
