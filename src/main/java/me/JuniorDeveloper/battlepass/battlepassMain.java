package me.JuniorDeveloper.battlepass;

import me.JuniorDeveloper.battlepass.level.HashMapLevelQuitJoin;
import me.JuniorDeveloper.battlepass.level.LevelCommands;
import me.JuniorDeveloper.battlepass.level.LevelLevelUpSystem;
import me.JuniorDeveloper.battlepass.level.PlayerLevelManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class battlepassMain extends JavaPlugin {
    public static HashMap<UUID, PlayerLevelManager> levelManagerHashMap;

    public static battlepassMain instance;
    private LevelCommands commands = new LevelCommands();

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

        //Level Setup
        getServer().getPluginManager().registerEvents(new LevelCommands(), this);
        getServer().getPluginManager().registerEvents(new LevelLevelUpSystem(), this);
        getServer().getPluginManager().registerEvents(new HashMapLevelQuitJoin(), this);
        //Level Setup
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Battlepass is fully enabled!");
    }

    @Override
    public void onDisable() {

    }


}
