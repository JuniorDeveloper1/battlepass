package me.JuniorDeveloper.battlepass;

import me.JuniorDeveloper.battlepass.commands.AllCommands;
import me.JuniorDeveloper.battlepass.level.HashMapLevelQuitJoin;
import me.JuniorDeveloper.battlepass.level.LevelLevelUpSystem;
import me.JuniorDeveloper.battlepass.level.PlayerLevelManager;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Logger;

public class BattlepassMain extends JavaPlugin {


    private static final Logger log = Logger.getLogger("Minecraft");
    public static HashMap<UUID, PlayerLevelManager> levelManagerHashMap;
    public static BattlepassMain instance;
    public final HashMap<UUID, Double> playerBank = new HashMap<>();
    public Economy economy;
    private AllCommands commands = new AllCommands();


    public static BattlepassMain getInstance() {
        return instance;

    }


    @Override
    public void onEnable() {
        if (!setupEconomy()) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        instance = this;
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


    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }

    public Economy getEconomy() {
        return economy;
    }

    @Override
    public void onDisable() {
    }
}
