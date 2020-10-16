package me.JuniorDeveloper.battlepass.challanges;

import me.JuniorDeveloper.battlepass.BattlepassMain;
import me.JuniorDeveloper.battlepass.level.PlayerLevelManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.UUID;

import static me.JuniorDeveloper.battlepass.challanges.challangesSystem.xpcheck;

public class challangeListeners implements Listener {


    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        UUID puuid = player.getUniqueId();
        Block block = e.getBlock();

        PlayerLevelManager playerLevelManager = BattlepassMain.getInstance().levelManagerHashMap.get(player.getUniqueId());
        String logo = BattlepassMain.getInstance().getConfig().getString("Messages.logo");
        int coalOreAmount = BattlepassMain.getInstance().getConfig().getInt("BlockAmount.coal-ore.amount");
        int diamondOreAmount = BattlepassMain.getInstance().getConfig().getInt("BlockAmount.diamond-ore.amount");
        int redstoneOreAmount = BattlepassMain.getInstance().getConfig().getInt("BlockAmount.redstone-ore.amount");
        int emeraldOreAmount = BattlepassMain.getInstance().getConfig().getInt("BlockAmount.emerald-ore.amount");
        int goldOreAmount = BattlepassMain.getInstance().getConfig().getInt("BlockAmount.gold-ore.amount");
        int ironOreAmount = BattlepassMain.getInstance().getConfig().getInt("BlockAmount.iron-ore.amount");
        int lapisOreAmount = BattlepassMain.getInstance().getConfig().getInt("BlockAmount.lapis-ore.amount");
        Boolean onOffOres = BattlepassMain.getInstance().getConfig().getBoolean("Settings.ore-xp-On_Off");
        BattlepassMain.getInstance().saveConfig();
        //All Ores
        if (onOffOres == true) {
            if (block.getType() == Material.COAL_ORE) {
                playerLevelManager.setXp(playerLevelManager.getXp() + coalOreAmount);
                player.sendMessage(logo + color("&7You mined coal_ore! You have gained") + color(" &6 ") + coalOreAmount + "Xp!");
            }
            if (block.getType().equals(Material.DIAMOND_ORE)) {
                player.sendMessage(logo + color("&7You mined diamond_ore! You have gained") + color(" &6 ") + diamondOreAmount + "Xp!");
                playerLevelManager.setXp(playerLevelManager.getXp() + diamondOreAmount);
            }

            if (block.getType().equals(Material.REDSTONE_ORE)) {
                player.sendMessage(logo + color("&7You mined redstone_ore! You have gained") + color(" &6 ") + redstoneOreAmount + "Xp!");
                playerLevelManager.setXp(playerLevelManager.getXp() + redstoneOreAmount);
            }

            if (block.getType().equals(Material.EMERALD_ORE)) {
                player.sendMessage(logo + color("&7You mined emerald_ore! You have gained") + color(" &6 ") + emeraldOreAmount + "Xp!");
                playerLevelManager.setXp(playerLevelManager.getXp() + emeraldOreAmount);
            }

            if (block.getType().equals(Material.GOLD_ORE)) {
                player.sendMessage(logo + color("&7You mined gold_ore! You have gained") + color(" &6 ") + goldOreAmount + "Xp!");
                playerLevelManager.setXp(playerLevelManager.getXp() + goldOreAmount);
            }

            if (block.getType().equals(Material.IRON_ORE)) {
                player.sendMessage(logo + color("&7You mined iron_ore! You have gained") + color(" &6 ") + ironOreAmount + "Xp!");
                playerLevelManager.setXp(playerLevelManager.getXp() + ironOreAmount);
            }

            if (block.getType().equals(Material.LAPIS_ORE)) {
                player.sendMessage(logo + color("&7You mined lapis_ore! You have gained") + color(" &6 ") + lapisOreAmount + "Xp!");
                playerLevelManager.setXp(playerLevelManager.getXp() + lapisOreAmount);
            }
            xpcheck(player, playerLevelManager);
            //All Ores
        } else {
        }
    }
    private String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

}
