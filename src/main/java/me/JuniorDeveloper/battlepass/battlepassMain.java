package me.JuniorDeveloper.battlepass;

import me.JuniorDeveloper.battlepass.commands.AllCommands;
import me.JuniorDeveloper.battlepass.level.HashMapLevelQuitJoin;
import me.JuniorDeveloper.battlepass.level.LevelLevelUpSystem;
import me.JuniorDeveloper.battlepass.level.PlayerLevelManager;
import me.JuniorDeveloper.battlepass.vault.Implementer;
import me.JuniorDeveloper.battlepass.vault.VaultHook;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class battlepassMain extends JavaPlugin {


    public static HashMap<UUID, PlayerLevelManager> levelManagerHashMap;
    public static Economy economy;
    public static battlepassMain instance;
    public Implementer economyImplementer;
    private VaultHook vaultHook;

    public final HashMap<UUID,Double> playerBank = new HashMap<>();
    private AllCommands commands = new AllCommands();


    public static battlepassMain getInstance() {
        return instance;

    }


    @Override
    public void onEnable() {
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
        runOnEnable();
    }



    private void instanceClasses(){
        economyImplementer = new Implementer();
        vaultHook = new VaultHook();
    }

        public void runOnEnable(){
        instanceClasses();
        vaultHook.hook();

        }


    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }

    @Override
    public void onDisable() {
    vaultHook.unhook();
    }
}
