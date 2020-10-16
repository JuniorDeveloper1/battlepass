package me.JuniorDeveloper.battlepass;

import me.JuniorDeveloper.battlepass.challanges.challangeListeners;
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

public class BattlepassMain extends JavaPlugin {
    public static HashMap<UUID, PlayerLevelManager> levelManagerHashMap;
    public static HashMap<UUID, Integer> coal_ore;
    public static HashMap<UUID, Integer> diamond_ore;
    public static HashMap<UUID, Integer> emerald_ore;
    public static HashMap<UUID, Integer> lapis_ore;
    public static HashMap<UUID, Integer> redstone_ore;
    public static HashMap<UUID, Integer> gold_ore;
    public static HashMap<UUID, Integer> iron_ore;
    public static HashMap<Integer, Integer> checker;

    public static BattlepassMain instance;
    private static Economy economy = null;
    private AllCommands commands = new AllCommands();


    public static BattlepassMain getInstance() { return instance; }

    public static Economy getEconomy() { return economy; }

    @Override
    public void onEnable() {
        instance = this;
        if (!setupEconomy()) {
            System.out.println("Disabled due to no Vault dependency found!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        hashmaps();

        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        this.reloadConfig();
        BattlepassMain.getInstance().getConfig().getConfigurationSection("Levels").getKeys(false).forEach(level -> {
            int xp = BattlepassMain.getInstance().getConfig().getInt("levels." + level + ".xp" );
            BattlepassMain.checker.put(Integer.parseInt(level), xp);
        });
        getCommand(commands.cmd1).setExecutor(commands);
        //Level System
        getServer().getPluginManager().registerEvents(new AllCommands(), this);
        getServer().getPluginManager().registerEvents(new LevelLevelUpSystem(), this);
        getServer().getPluginManager().registerEvents(new HashMapLevelQuitJoin(), this);
        //Level System
        getServer().getPluginManager().registerEvents(new challangeListeners(), this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Battlepass is fully enabled!");
        configMessages();


    }

    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }
        return (economy != null);
    }

    public void hashmaps() {
        this.levelManagerHashMap = new HashMap<>();
        this.coal_ore = new HashMap<>();
        this.diamond_ore = new HashMap<>();
        this.emerald_ore = new HashMap<>();
        this.lapis_ore = new HashMap<>();
        this.redstone_ore = new HashMap<>();
        this.gold_ore = new HashMap<>();
        this.iron_ore = new HashMap<>();
        checker = new HashMap<>();
    }

    public void configMessages(){
        BattlepassMain.getInstance().saveConfig();
    }

    @Override
    public void onDisable() { }
}
