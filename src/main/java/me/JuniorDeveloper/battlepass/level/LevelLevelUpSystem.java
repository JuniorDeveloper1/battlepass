package me.JuniorDeveloper.battlepass.level;

import org.bukkit.event.Listener;

public class LevelLevelUpSystem implements Listener {

/**
 * Doesn't need to work anymore. All of this is going to the ChallangeListener.
 * This will be deleted before the plugin is fully done.
 */
/*
    @EventHandler
    public void blockbreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        PlayerLevelManager playerLevelManager = BattlepassMain.getInstance().levelManagerHashMap.get(player.getUniqueId());
        Block block = event.getBlock();

        if (block.getType() == Material.STONE) {
            playerLevelManager.setXp(playerLevelManager.getXp() + 100);
            player.sendMessage(""); //Message for mining Stone. Experience = 100
            xpcheck(player, playerLevelManager);


        }
    }



    public void xpcheck(Player player, PlayerLevelManager playerLevelManager) {
        int level1 = BattlepassMain.getInstance().getConfig().getInt("Levels.1.xp");
        int level2 = BattlepassMain.getInstance().getConfig().getInt("Levels.2.xp");

        int xp = playerLevelManager.getXp();

//Todo: This has to be fixed! No errors, but will get some soon. Player can change this with an config. So the challanges
        //todo: or blockbreak event might not have the same calculations. The level will not be changed and the player
        //todo: will not get notified.

        if (xp  == level1 ) {
            player.sendMessage("§6Leveled UP!");
            playerLevelManager.setLevel(1);
        }
        if(xp == level2){
            player.sendMessage("Leveled up!");
            playerLevelManager.setLevel(2);
        }
    }
*/

}
