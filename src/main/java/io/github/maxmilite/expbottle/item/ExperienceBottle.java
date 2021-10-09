package io.github.maxmilite.expbottle.item;

import io.github.maxmilite.expbottle.enchantments.BottleEnchantment;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Objects;

public class ExperienceBottle {

    public ItemStack bottle;
    public BottleEnchantment bottleEnchantment = new BottleEnchantment();

    public ExperienceBottle() {
        bottle = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);
//        bottle.addUnsafeEnchantment(bottleEnchantment.getEnchantment(), 1);
        ItemMeta itemMeta = bottle.getItemMeta();
        Objects.requireNonNull(itemMeta).setDisplayName(ChatColor.GOLD + "经验之瓶");
        itemMeta.setLore(Arrays.asList(
                ChatColor.LIGHT_PURPLE + "来自远古的智慧",
                "",
                ChatColor.GREEN + "当前持有经验: ",
                ChatColor.YELLOW + "0",
                ChatColor.GRAY + "--------------------",
                ChatColor.DARK_PURPLE + "来自远古未知领域的经验之瓶",
                ChatColor.DARK_PURPLE + "据说拥有储存经验的奇幻能力"));
        itemMeta.addEnchant(bottleEnchantment.getEnchantment(), 1, true);
        bottle.setItemMeta(itemMeta);
    }
}
