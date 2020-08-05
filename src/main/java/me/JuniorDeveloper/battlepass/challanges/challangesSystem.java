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
        int level0 = BattlepassMain.getInstance().getConfig().getInt("Levels.0.xp");
        int level1 = BattlepassMain.getInstance().getConfig().getInt("Levels.1.xp");
        int level2 = BattlepassMain.getInstance().getConfig().getInt("Levels.2.xp");
        int level3 = BattlepassMain.getInstance().getConfig().getInt("Levels.3.xp");
        int level4 = BattlepassMain.getInstance().getConfig().getInt("Levels.4.xp");
        int level5 = BattlepassMain.getInstance().getConfig().getInt("Levels.5.xp");
        int level6 = BattlepassMain.getInstance().getConfig().getInt("Levels.6.xp");
        int level7 = BattlepassMain.getInstance().getConfig().getInt("Levels.7.xp");
        int level8 = BattlepassMain.getInstance().getConfig().getInt("Levels.8.xp");
        int level9 = BattlepassMain.getInstance().getConfig().getInt("Levels.9.xp");
        int level10 = BattlepassMain.getInstance().getConfig().getInt("Levels.10.xp");
        int level11 = BattlepassMain.getInstance().getConfig().getInt("Levels.11.xp");
        int level12 = BattlepassMain.getInstance().getConfig().getInt("Levels.12.xp");
        int level13 = BattlepassMain.getInstance().getConfig().getInt("Levels.13.xp");
        int level14 = BattlepassMain.getInstance().getConfig().getInt("Levels.14.xp");
        int level15 = BattlepassMain.getInstance().getConfig().getInt("Levels.15.xp");
        int level16 = BattlepassMain.getInstance().getConfig().getInt("Levels.16.xp");
        int level17 = BattlepassMain.getInstance().getConfig().getInt("Levels.17.xp");
        int level18 = BattlepassMain.getInstance().getConfig().getInt("Levels.18.xp");
        int level19 = BattlepassMain.getInstance().getConfig().getInt("Levels.19.xp");
        int level20 = BattlepassMain.getInstance().getConfig().getInt("Levels.20.xp");
        int level21 = BattlepassMain.getInstance().getConfig().getInt("Levels.21.xp");
        int level22 = BattlepassMain.getInstance().getConfig().getInt("Levels.22.xp");
        int level23 = BattlepassMain.getInstance().getConfig().getInt("Levels.23.xp");
        int level24 = BattlepassMain.getInstance().getConfig().getInt("Levels.24.xp");
        int level25 = BattlepassMain.getInstance().getConfig().getInt("Levels.25.xp");
        int level26 = BattlepassMain.getInstance().getConfig().getInt("Levels.26.xp");
        int level27 = BattlepassMain.getInstance().getConfig().getInt("Levels.27.xp");
        int level28 = BattlepassMain.getInstance().getConfig().getInt("Levels.28.xp");
        int level29 = BattlepassMain.getInstance().getConfig().getInt("Levels.29.xp");
        int level30 = BattlepassMain.getInstance().getConfig().getInt("Levels.30.xp");
        int level31 = BattlepassMain.getInstance().getConfig().getInt("Levels.31.xp");
        int level32 = BattlepassMain.getInstance().getConfig().getInt("Levels.32.xp");
        int level33 = BattlepassMain.getInstance().getConfig().getInt("Levels.33.xp");
        int level34 = BattlepassMain.getInstance().getConfig().getInt("Levels.34.xp");
        int level35 = BattlepassMain.getInstance().getConfig().getInt("Levels.35.xp");
        int level36 = BattlepassMain.getInstance().getConfig().getInt("Levels.36.xp");
        int level37 = BattlepassMain.getInstance().getConfig().getInt("Levels.37.xp");
        int level38 = BattlepassMain.getInstance().getConfig().getInt("Levels.38.xp");
        int level39 = BattlepassMain.getInstance().getConfig().getInt("Levels.39.xp");
        int level40 = BattlepassMain.getInstance().getConfig().getInt("Levels.40.xp");
        int level41 = BattlepassMain.getInstance().getConfig().getInt("Levels.41.xp");
        int level42 = BattlepassMain.getInstance().getConfig().getInt("Levels.42.xp");
        int level43 = BattlepassMain.getInstance().getConfig().getInt("Levels.43.xp");
        int level44 = BattlepassMain.getInstance().getConfig().getInt("Levels.44.xp");
        int level45 = BattlepassMain.getInstance().getConfig().getInt("Levels.45.xp");
        int level46 = BattlepassMain.getInstance().getConfig().getInt("Levels.46.xp");
        int level47 = BattlepassMain.getInstance().getConfig().getInt("Levels.48.xp");
        int level48 = BattlepassMain.getInstance().getConfig().getInt("Levels.49.xp");




        int xp = playerLevelManager.getXp();

//Todo: This has to be fixed! No errors, but will get some soon. Player can change this with an config. So the challanges
        //todo: or blockbreak event might not have the same calculations. The level will not be changed and the player
        //todo: will not get notified.

        if (xp  >= level1 ) {
            player.sendMessage("§6Leveled UP!");
            playerLevelManager.setLevel(1);
        }else if(xp >= level0){
            playerLevelManager.setLevel(1);
        }

        if(xp >= level2){
            playerLevelManager.setLevel(2);
        }else if(xp >= level1){
            playerLevelManager.setLevel(2);
        }
    }

}
