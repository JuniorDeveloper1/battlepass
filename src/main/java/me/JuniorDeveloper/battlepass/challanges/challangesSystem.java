package me.JuniorDeveloper.battlepass.challanges;

import me.JuniorDeveloper.battlepass.BattlepassMain;
import me.JuniorDeveloper.battlepass.level.PlayerLevelManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.UUID;

public class challangesSystem {


    public static void system(Player player) {
        UUID puuid = player.getUniqueId();
    }


    public static void xpcheck(Player player, PlayerLevelManager playerLevelManager) {
        int xp = playerLevelManager.getXp();
        int playerLevel = playerLevelManager.getLevel();
        int xpLevel = BattlepassMain.checker.get(playerLevel);
        if (xpLevel >= xp) {
            playerLevelManager.setLevel(playerLevel + 1);
            player.sendMessage(color("&7You level up!"));
        }

    }

    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
