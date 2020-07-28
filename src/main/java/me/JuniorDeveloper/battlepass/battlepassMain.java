package me.JuniorDeveloper.battlepass;

import me.JuniorDeveloper.battlepass.commands.AllCommands;
import me.JuniorDeveloper.battlepass.level.HashMapLevelQuitJoin;
import me.JuniorDeveloper.battlepass.level.LevelLevelUpSystem;
import me.JuniorDeveloper.battlepass.level.PlayerLevelManager;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class battlepassMain extends JavaPlugin {


    public static HashMap<UUID, PlayerLevelManager> levelManagerHashMap;
    public static Economy economy;
    public static battlepassMain instance;
    private AllCommands commands = new AllCommands();


    public static battlepassMain getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        if (!setupEconomy()) {
            Bukkit.shutdown();
        }


        this.levelManagerHashMap = new HashMap<>();
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        this.reloadConfig();
        getCommand(commands.cmd1).setExecutor(commands);

        //Level System
        getServer().getPluginManager().registerEvents(new AllCommands(), this);
        getServer().getPluginManager().registerEvents(new LevelLevelUpSystem(), this);
        getServer().getPluginManager().registerEvents(new HashMapLevelQuitJoin(), this);
        //Level System

        //Vault system

        //Vault System
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Battlepass is fully enabled!");
    }

    @Override
    public void onDisable() {

    }

    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }

}
