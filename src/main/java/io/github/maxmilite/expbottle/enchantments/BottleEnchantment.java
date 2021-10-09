package io.github.maxmilite.expbottle.enchantments;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class BottleEnchantment {

    public final Enchantment enchantment = new org.bukkit.enchantments.Enchantment(
            new NamespacedKey(Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("ExpBottle")), "expbottle")) {
        @Override
        public String getName() {
            return ChatColor.LIGHT_PURPLE + "来自远古的智慧";
        }

        @Override
        public int getMaxLevel() {
            return 1;
        }

        @Override
        public int getStartLevel() {
            return 1;
        }

        @Override
        public EnchantmentTarget getItemTarget() {
            return null;
        }

        @Override
        public boolean isTreasure() {
            return false;
        }

        @Override
        public boolean isCursed() {
            return false;
        }

        @Override
        public boolean conflictsWith(org.bukkit.enchantments.Enchantment other) {
            return false;
        }

        @Override
        public boolean canEnchantItem(ItemStack item) {
            return false;
        }
    };

    public Enchantment getEnchantment() {
        return enchantment;
    }
}
