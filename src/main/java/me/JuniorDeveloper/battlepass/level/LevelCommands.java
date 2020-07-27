package me.JuniorDeveloper.battlepass.level;

import me.JuniorDeveloper.battlepass.battlepassMain;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;


public class LevelCommands implements Listener, CommandExecutor {


    public String cmd1 = "bp";


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        String logo = ChatColor.translateAlternateColorCodes('&', "//");
        String noPermissions = ChatColor.translateAlternateColorCodes('&', "&c You don't have enough permissions.");
        String noArguments = ChatColor.translateAlternateColorCodes('&', "&c&lNO &3 arugments have been found!");
        String commandUsage = ChatColor.translateAlternateColorCodes('&', "&c&lUssage : &c/bp check level <player>!");
        String tryThis = ChatColor.translateAlternateColorCodes('&', "&a&lTry! :");


        if (sender instanceof Player) {
            Player player = (Player) sender;
            PlayerLevelManager playerLevelManager = battlepassMain.getInstance().levelManagerHashMap.get(player.getUniqueId());

            if (cmd.getName().equalsIgnoreCase(cmd1)) {
                if (args.length == 0) {
                    //Help infromation
                    player.sendMessage(noArguments);
                    player.sendMessage(tryThis + ChatColor.GOLD + "/bp level");
                    player.sendMessage(tryThis + ChatColor.GOLD + "/bp challanges");
                    player.sendMessage(tryThis + ChatColor.GOLD + "/bp check <player>");
                    return true;

                }
                if (args[0].equalsIgnoreCase("level")) {
                    player.sendMessage(ChatColor.GRAY + "Your level is : " + ChatColor.GREEN + playerLevelManager.getLevel());

                }
                if (args[0].equalsIgnoreCase("challanges")) {
                    player.sendMessage(ChatColor.GRAY + " Your challanges ! :");
                    player.sendMessage(ChatColor.GOLD + "     Challange 1");

                }


                if (args[0].equalsIgnoreCase("check")) {
                    if(args.length == 1){
                        player.sendMessage(commandUsage);
                        return true;
                    }


                    if (args[1].equalsIgnoreCase("level")){
                        if(args.length == 2){
                            player.sendMessage(commandUsage);
                            return true;
                        }

                    Player otherPlayerLevelCheck = Bukkit.getServer().getPlayer(args[2]);
                    if(otherPlayerLevelCheck == null){
                        player.sendMessage(ChatColor.RED + "Not player found!");
                        return true;

                    }else if(otherPlayerLevelCheck != null){
                        PlayerLevelManager playerCheckerLevel = battlepassMain.getInstance().levelManagerHashMap.get(otherPlayerLevelCheck.getUniqueId());
                        player.sendMessage(ChatColor.GREEN + otherPlayerLevelCheck.getName() + ChatColor.GRAY +" Level is : " + ChatColor.GREEN + playerCheckerLevel.getLevel());
                    }

                    }


                    }


            } else {
                player.sendMessage(logo + noPermissions);
                return true;
            }
            return true;
        } else {
            Bukkit.getServer().getConsoleSender().sendMessage("U heeft geen toegang tot dit.");
        }
        return false;


    }


}