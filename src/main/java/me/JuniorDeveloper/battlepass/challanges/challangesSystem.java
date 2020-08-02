package me.JuniorDeveloper.battlepass.challanges;

import me.JuniorDeveloper.battlepass.BattlepassMain;
import me.JuniorDeveloper.battlepass.level.PlayerLevelManager;
import org.bukkit.entity.Player;

import java.util.UUID;

public class challangesSystem {



    public static void system(Player player){
        UUID puuid = player.getUniqueId();
    }


    public static void xpcheck(Player player, PlayerLevelManager playerLevelManager) {
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

}
