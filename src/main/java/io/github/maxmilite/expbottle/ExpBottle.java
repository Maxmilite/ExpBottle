package io.github.maxmilite.expbottle;

import io.github.maxmilite.expbottle.command.CommandHandler;
import io.github.maxmilite.expbottle.command.TabHandler;
import io.github.maxmilite.expbottle.enchantments.BottleEnchantment;
import io.github.maxmilite.expbottle.event.Event;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ExpBottle extends JavaPlugin {

    public BottleEnchantment bottleEnchantment;

    public void registerCommand() {
        Objects.requireNonNull(this.getCommand("expbottle")).setExecutor(new CommandHandler());
        Objects.requireNonNull(Bukkit.getPluginCommand("expbottle")).setTabCompleter(new TabHandler());
    }

    public void registerListener() {
        this.getServer().getPluginManager().registerEvents(new Event(), this);
    }

    @Override
    public void onEnable() {
        bottleEnchantment = new BottleEnchantment();
        registerCommand();
        registerListener();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
