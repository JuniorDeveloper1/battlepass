package me.JuniorDeveloper.battlepass.challanges;

import me.JuniorDeveloper.battlepass.BattlepassMain;
import me.JuniorDeveloper.battlepass.level.PlayerLevelManager;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

import static me.JuniorDeveloper.battlepass.challanges.challangesSystem.xpcheck;

public class challangeListeners extends JavaPlugin {

    public void onBreak(BlockBreakEvent e){
        Player player = e.getPlayer();
        UUID puuid = player.getUniqueId();
        Block block = e.getBlock();

        PlayerLevelManager playerLevelManager = BattlepassMain.getInstance().levelManagerHashMap.get(player.getUniqueId());

        int coalOreAmount = BattlepassMain.getInstance().getConfig().getInt("BlockAmount.coal-ore.amount");
        /*
        int diamondOreAmount = BattlepassMain.getInstance().getConfig().getInt();
        int redstoneOreAmount = BattlepassMain.getInstance().getConfig().getInt();
        int emeraldOreAmount = BattlepassMain.getInstance().getConfig().getInt();
        int goldOreAmount = BattlepassMain.getInstance().getConfig().getInt();
        int ironOreAmount = BattlepassMain.getInstance().getConfig().getInt();
        int lapisOreAmount = BattlepassMain.getInstance().getConfig().getInt();
        
         */

        BattlepassMain.getInstance().saveConfig();
        //All Ores
        if(block.getType().equals(Material.COAL_ORE)){
            playerLevelManager.setXp(playerLevelManager.getXp() + coalOreAmount);
            player.sendMessage("You minded coal Ore! You have gained" + coalOreAmount + "Xp!");
        }
        if(block.getType().equals(Material.DIAMOND_ORE)){}
        if(block.getType().equals(Material.REDSTONE_ORE)){}
        if(block.getType().equals(Material.EMERALD_ORE)){}
        if(block.getType().equals(Material.GOLD_ORE)){}
        if(block.getType().equals(Material.IRON_ORE)){}
        if(block.getType().equals(Material.LAPIS_ORE)){}
        xpcheck(player, playerLevelManager);
        //All Ores
    }
}
