package me.JuniorDeveloper.battlepass.challanges;

import org.bukkit.entity.Player;

public class challanges {

   public static boolean isCompleted(Player player){
       player.sendMessage("False Message");
       return false;



   }

   public static boolean notCompleted(Player player){
       player.sendMessage("True Message");
       return true;
   }
}
