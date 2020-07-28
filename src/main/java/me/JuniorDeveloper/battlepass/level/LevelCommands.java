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
                    player.sendMessage(tryThis + ChatColor.GOLD + "/bp level" + ChatColor.GRAY + " Shows your level!");
                    player.sendMessage(tryThis + ChatColor.GOLD + "/bp challanges" + ChatColor.GRAY + " Shows challanges!");
                    player.sendMessage(tryThis + ChatColor.GOLD + "/bp check <player>"+ ChatColor.GRAY + " Checks an player level!");
                    player.sendMessage(tryThis + ChatColor.GOLD + "/bp xp list" +ChatColor.GRAY + " Checks the xp list for an level up!");
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
                    if (args.length == 1) {
                        player.sendMessage(commandUsage);
                        return true;
                    }


                    if (args[1].equalsIgnoreCase("level")) {
                        if (args.length == 2) {
                            player.sendMessage(commandUsage);
                            return true;
                        }

                        Player otherPlayerLevelCheck = Bukkit.getServer().getPlayer(args[2]);
                        if (otherPlayerLevelCheck == null) {
                            player.sendMessage(ChatColor.RED + "Not player found!");
                            return true;

                        } else if (otherPlayerLevelCheck != null) {
                            PlayerLevelManager playerCheckerLevel = battlepassMain.getInstance().levelManagerHashMap.get(otherPlayerLevelCheck.getUniqueId());
                            player.sendMessage(ChatColor.GREEN + otherPlayerLevelCheck.getName() + ChatColor.GRAY + " Level is : " + ChatColor.GREEN + playerCheckerLevel.getLevel());
                        }

                    }



                }
                if(args[0].equalsIgnoreCase("xp")){
                    if(args.length <= 1){
                        player.sendMessage(tryThis + ChatColor.RED + "/bp xp list");
                        return true;
                    }
                    if (args[1].equalsIgnoreCase("list")){


                        //Page 1
                        int level1 =  battlepassMain.getInstance().getConfig().getInt("Levels.1.xp")   ;
                        int level2 = battlepassMain.getInstance().getConfig().getInt("Levels.2.xp");
                        int level3 = battlepassMain.getInstance().getConfig().getInt("Levels.3.xp");
                        int level4 = battlepassMain.getInstance().getConfig().getInt("Levels.4.xp");
                        int level5 = battlepassMain.getInstance().getConfig().getInt("Levels.5.xp");
                        int level6 = battlepassMain.getInstance().getConfig().getInt("Levels.6.xp");
                        int level7 = battlepassMain.getInstance().getConfig().getInt("Levels.7.xp");
                        int level8 = battlepassMain.getInstance().getConfig().getInt("Levels.8.xp");
                        int level9 = battlepassMain.getInstance().getConfig().getInt("Levels.9.xp");
                        int level10 = battlepassMain.getInstance().getConfig().getInt("Levels.10.xp");
                        int level11 = battlepassMain.getInstance().getConfig().getInt("Levels.11.xp");
                        int level12 = battlepassMain.getInstance().getConfig().getInt("Levels.12.xp");
                        int level13 = battlepassMain.getInstance().getConfig().getInt("Levels.13.xp");
                        int level14 = battlepassMain.getInstance().getConfig().getInt("Levels.14.xp");
                        int level15 = battlepassMain.getInstance().getConfig().getInt("Levels.15.xp");
                        int level16 = battlepassMain.getInstance().getConfig().getInt("Levels.16.xp");
                        int level17 = battlepassMain.getInstance().getConfig().getInt("Levels.17.xp");
                        int level18 = battlepassMain.getInstance().getConfig().getInt("Levels.18.xp");
                        int level19 = battlepassMain.getInstance().getConfig().getInt("Levels.19.xp");
                        int level20 = battlepassMain.getInstance().getConfig().getInt("Levels.20.xp");
                        //Page 2
                        int level21 =  battlepassMain.getInstance().getConfig().getInt("Levels.21.xp")   ;
                        int level22 = battlepassMain.getInstance().getConfig().getInt("Levels.22.xp");
                        int level23 = battlepassMain.getInstance().getConfig().getInt("Levels.23.xp");
                        int level24 = battlepassMain.getInstance().getConfig().getInt("Levels.24.xp");
                        int level25 = battlepassMain.getInstance().getConfig().getInt("Levels.25.xp");
                        int level26 = battlepassMain.getInstance().getConfig().getInt("Levels.26.xp");
                        int level27 = battlepassMain.getInstance().getConfig().getInt("Levels.27.xp");
                        int level28 = battlepassMain.getInstance().getConfig().getInt("Levels.28.xp");
                        int level29 = battlepassMain.getInstance().getConfig().getInt("Levels.29.xp");
                        int level30 = battlepassMain.getInstance().getConfig().getInt("Levels.30.xp");
                        int level31 = battlepassMain.getInstance().getConfig().getInt("Levels.31.xp");
                        int level32 = battlepassMain.getInstance().getConfig().getInt("Levels.32.xp");
                        int level33 = battlepassMain.getInstance().getConfig().getInt("Levels.33.xp");
                        int level34 = battlepassMain.getInstance().getConfig().getInt("Levels.34.xp");
                        int level35 = battlepassMain.getInstance().getConfig().getInt("Levels.35.xp");
                        int level36 = battlepassMain.getInstance().getConfig().getInt("Levels.36.xp");
                        int level37 = battlepassMain.getInstance().getConfig().getInt("Levels.37.xp");
                        int level38 = battlepassMain.getInstance().getConfig().getInt("Levels.38.xp");
                        int level39 = battlepassMain.getInstance().getConfig().getInt("Levels.39.xp");
                        int level40 = battlepassMain.getInstance().getConfig().getInt("Levels.30.xp");
                        //Page 3
                        int level41 =  battlepassMain.getInstance().getConfig().getInt("Levels.41.xp")   ;
                        int level42 = battlepassMain.getInstance().getConfig().getInt("Levels.42.xp");
                        int level43 = battlepassMain.getInstance().getConfig().getInt("Levels.43.xp");
                        int level44 = battlepassMain.getInstance().getConfig().getInt("Levels.44.xp");
                        int level45 = battlepassMain.getInstance().getConfig().getInt("Levels.45.xp");
                        int level46 = battlepassMain.getInstance().getConfig().getInt("Levels.46.xp");
                        int level47 = battlepassMain.getInstance().getConfig().getInt("Levels.47.xp");
                        int level48 = battlepassMain.getInstance().getConfig().getInt("Levels.48.xp");
                        int level49 = battlepassMain.getInstance().getConfig().getInt("Levels.49.xp");
                        int level50 = battlepassMain.getInstance().getConfig().getInt("Levels.50.xp");
                        int level51 = battlepassMain.getInstance().getConfig().getInt("Levels.51.xp");
                        int level52 = battlepassMain.getInstance().getConfig().getInt("Levels.52.xp");
                        int level53 = battlepassMain.getInstance().getConfig().getInt("Levels.53.xp");
                        int level54 = battlepassMain.getInstance().getConfig().getInt("Levels.54.xp");
                        int level55 = battlepassMain.getInstance().getConfig().getInt("Levels.55.xp");
                        int level56 = battlepassMain.getInstance().getConfig().getInt("Levels.56.xp");
                        int level57 = battlepassMain.getInstance().getConfig().getInt("Levels.57.xp");
                        int level58 = battlepassMain.getInstance().getConfig().getInt("Levels.58.xp");
                        int level59 = battlepassMain.getInstance().getConfig().getInt("Levels.59.xp");
                        int level60 = battlepassMain.getInstance().getConfig().getInt("Levels.60.xp");
                        //page 4
                        int level61 =  battlepassMain.getInstance().getConfig().getInt("Levels.61.xp")   ;
                        int level62 = battlepassMain.getInstance().getConfig().getInt("Levels.62.xp");
                        int level63 = battlepassMain.getInstance().getConfig().getInt("Levels.63.xp");
                        int level64 = battlepassMain.getInstance().getConfig().getInt("Levels.64.xp");
                        int level65 = battlepassMain.getInstance().getConfig().getInt("Levels.65.xp");
                        int level66 = battlepassMain.getInstance().getConfig().getInt("Levels.66.xp");
                        int level67 = battlepassMain.getInstance().getConfig().getInt("Levels.67.xp");
                        int level68 = battlepassMain.getInstance().getConfig().getInt("Levels.68.xp");
                        int level69 = battlepassMain.getInstance().getConfig().getInt("Levels.69.xp");
                        int level70 = battlepassMain.getInstance().getConfig().getInt("Levels.70.xp");
                        int level71 =  battlepassMain.getInstance().getConfig().getInt("Levels.71.xp");
                        int level72 = battlepassMain.getInstance().getConfig().getInt("Levels.72.xp");
                        int level73 = battlepassMain.getInstance().getConfig().getInt("Levels.73.xp");
                        int level74 = battlepassMain.getInstance().getConfig().getInt("Levels.74.xp");
                        int level75 = battlepassMain.getInstance().getConfig().getInt("Levels.75.xp");
                        int level76 = battlepassMain.getInstance().getConfig().getInt("Levels.76.xp");
                        int level77 = battlepassMain.getInstance().getConfig().getInt("Levels.77.xp");
                        int level78 = battlepassMain.getInstance().getConfig().getInt("Levels.78.xp");
                        int level79 = battlepassMain.getInstance().getConfig().getInt("Levels.79.xp");

                        //page 5
                        int level80 = battlepassMain.getInstance().getConfig().getInt("Levels.80.xp");
                        int level81 = battlepassMain.getInstance().getConfig().getInt("Levels.81.xp");
                        int level82 = battlepassMain.getInstance().getConfig().getInt("Levels.82.xp");
                        int level83 = battlepassMain.getInstance().getConfig().getInt("Levels.83.xp");
                        int level84 = battlepassMain.getInstance().getConfig().getInt("Levels.84.xp");
                        int level85 = battlepassMain.getInstance().getConfig().getInt("Levels.85.xp");
                        int level86 = battlepassMain.getInstance().getConfig().getInt("Levels.86.xp");
                        int level87 = battlepassMain.getInstance().getConfig().getInt("Levels.87.xp");
                        int level88 = battlepassMain.getInstance().getConfig().getInt("Levels.88.xp");
                        int level89 = battlepassMain.getInstance().getConfig().getInt("Levels.89.xp");
                        int level90 = battlepassMain.getInstance().getConfig().getInt("Levels.90.xp");
                        int level91 = battlepassMain.getInstance().getConfig().getInt("Levels.91.xp");
                        int level92 = battlepassMain.getInstance().getConfig().getInt("Levels.92.xp");
                        int level93 = battlepassMain.getInstance().getConfig().getInt("Levels.93.xp");
                        int level94 = battlepassMain.getInstance().getConfig().getInt("Levels.94.xp");
                        int level95 = battlepassMain.getInstance().getConfig().getInt("Levels.95.xp");
                        int level96 = battlepassMain.getInstance().getConfig().getInt("Levels.96.xp");
                        int level97 = battlepassMain.getInstance().getConfig().getInt("Levels.97.xp");
                        int level98 = battlepassMain.getInstance().getConfig().getInt("Levels.98.xp");
                        int level99 = battlepassMain.getInstance().getConfig().getInt("Levels.99.xp");
                        int level100 = battlepassMain.getInstance().getConfig().getInt("Levels.100.xp");

                      if(args.length == 2){
                          player.sendMessage(ChatColor.GRAY + "Level 1: " + ChatColor.GREEN + level1 + ChatColor.GRAY + " needed!");
                          player.sendMessage(ChatColor.GRAY + "Level 2: " + ChatColor.GREEN + level2 + ChatColor.GRAY + " needed!");
                          player.sendMessage(ChatColor.GRAY + "Level 3: " + ChatColor.GREEN + level3 + ChatColor.GRAY + " needed!");
                          player.sendMessage(ChatColor.GRAY + "Level 4: " + ChatColor.GREEN + level4 + ChatColor.GRAY + " needed!");
                          player.sendMessage(ChatColor.GRAY + "Level 5: " + ChatColor.GREEN + level5 + ChatColor.GRAY + " needed!");
                          player.sendMessage(ChatColor.GRAY + "Level 6: " + ChatColor.GREEN + level6 + ChatColor.GRAY + " needed!");
                          player.sendMessage(ChatColor.GRAY + "Level 7: " + ChatColor.GREEN + level7 + ChatColor.GRAY + " needed!");
                          player.sendMessage(ChatColor.GRAY + "Level 8: " + ChatColor.GREEN + level8 + ChatColor.GRAY + " needed!");
                          player.sendMessage(ChatColor.GRAY + "Level 9: " + ChatColor.GREEN + level9 + ChatColor.GRAY + " needed!");
                          player.sendMessage(ChatColor.GRAY + "Level 10: " + ChatColor.GREEN + level10 + ChatColor.GRAY + " needed!");
                          player.sendMessage(ChatColor.GRAY + "Level 11: " + ChatColor.GREEN + level11 + ChatColor.GRAY + " needed!");
                          player.sendMessage(ChatColor.GRAY + "Level 12: " + ChatColor.GREEN + level12 + ChatColor.GRAY + " needed!");
                          player.sendMessage(ChatColor.GRAY + "Level 13: " + ChatColor.GREEN + level13 + ChatColor.GRAY + " needed!");
                          player.sendMessage(ChatColor.GRAY + "Level 14: " + ChatColor.GREEN + level14 + ChatColor.GRAY + " needed!");
                          player.sendMessage(ChatColor.GRAY + "Level 15: " + ChatColor.GREEN + level15 + ChatColor.GRAY + " needed!");
                          player.sendMessage(ChatColor.GRAY + "Level 16: " + ChatColor.GREEN + level16 + ChatColor.GRAY + " needed!");
                          player.sendMessage(ChatColor.GRAY + "Level 17: " + ChatColor.GREEN + level17 + ChatColor.GRAY + " needed!");
                          player.sendMessage(ChatColor.GRAY + "Level 18: " + ChatColor.GREEN + level18 + ChatColor.GRAY + " needed!");
                          player.sendMessage(ChatColor.GRAY + "Level 19: " + ChatColor.GREEN + level19 + ChatColor.GRAY + " needed!");
                          player.sendMessage(ChatColor.GRAY + "Level 20: " + ChatColor.GREEN + level20 + ChatColor.GRAY + " needed!");
                        player.sendMessage(tryThis + ChatColor.GRAY + "/bp xp list 2" + ChatColor.GOLD + " for page 2!");
                        return true;
                      }
                        if(args[2].equalsIgnoreCase("2")){
                            if(args.length == 3){
                                player.sendMessage(ChatColor.GOLD + "--------------"+ChatColor.GRAY+ "Page 2"+ChatColor.GOLD +"------------");
                                player.sendMessage(ChatColor.GRAY + "Level 21: " + ChatColor.GREEN + level21 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 22: " + ChatColor.GREEN + level22 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 23: " + ChatColor.GREEN + level23 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 24: " + ChatColor.GREEN + level24 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 25: " + ChatColor.GREEN + level25 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 26: " + ChatColor.GREEN + level26 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 27: " + ChatColor.GREEN + level27 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 28: " + ChatColor.GREEN + level28 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 29: " + ChatColor.GREEN + level29 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 20: " + ChatColor.GREEN + level30 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 31: " + ChatColor.GREEN + level31 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 32: " + ChatColor.GREEN + level32 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 33: " + ChatColor.GREEN + level33 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 34: " + ChatColor.GREEN + level34 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 35: " + ChatColor.GREEN + level35 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 36: " + ChatColor.GREEN + level36 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 37: " + ChatColor.GREEN + level37 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 38: " + ChatColor.GREEN + level38 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 39: " + ChatColor.GREEN + level39 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 40: " + ChatColor.GREEN + level40 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GOLD + "--------------"+ChatColor.GRAY+"Page 2"+ChatColor.GOLD +"------------");
                                return true;
                            }

                        }

                        if (args[2].equalsIgnoreCase("3")){
                            if(args.length == 3){
                                player.sendMessage(ChatColor.GOLD + "--------------"+ChatColor.GRAY+ "Page 3"+ChatColor.GOLD +"------------");
                                player.sendMessage(ChatColor.GRAY + "Level 41: " + ChatColor.GREEN + level41 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 42: " + ChatColor.GREEN + level42 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 43: " + ChatColor.GREEN + level43 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 44: " + ChatColor.GREEN + level44 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 45: " + ChatColor.GREEN + level45 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 46: " + ChatColor.GREEN + level46 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 47: " + ChatColor.GREEN + level47 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 48: " + ChatColor.GREEN + level48 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 49: " + ChatColor.GREEN + level49 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 50: " + ChatColor.GREEN + level50 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 51: " + ChatColor.GREEN + level51 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 52: " + ChatColor.GREEN + level52 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 53: " + ChatColor.GREEN + level53 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 54: " + ChatColor.GREEN + level54 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 55: " + ChatColor.GREEN + level55 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 56: " + ChatColor.GREEN + level56 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 57: " + ChatColor.GREEN + level57 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 58: " + ChatColor.GREEN + level58 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 59: " + ChatColor.GREEN + level59 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GRAY + "Level 60: " + ChatColor.GREEN + level60 + ChatColor.GRAY + " needed!");
                                player.sendMessage(ChatColor.GOLD + "--------------"+ChatColor.GRAY+"Page 3"+ChatColor.GOLD +"------------");
                                return true;
                            }
                        }

                            if(args[2].equalsIgnoreCase("4")){
                               if(args.length == 3){
                                   player.sendMessage(ChatColor.GOLD + "--------------"+ChatColor.GRAY+ "Page 4"+ChatColor.GOLD +"------------");
                                   player.sendMessage(ChatColor.GRAY + "Level 61: " + ChatColor.GREEN + level61 + ChatColor.GRAY + " needed!");
                                   player.sendMessage(ChatColor.GRAY + "Level 62: " + ChatColor.GREEN + level62 + ChatColor.GRAY + " needed!");
                                   player.sendMessage(ChatColor.GRAY + "Level 63: " + ChatColor.GREEN + level63 + ChatColor.GRAY + " needed!");
                                   player.sendMessage(ChatColor.GRAY + "Level 64: " + ChatColor.GREEN + level64 + ChatColor.GRAY + " needed!");
                                   player.sendMessage(ChatColor.GRAY + "Level 65: " + ChatColor.GREEN + level65 + ChatColor.GRAY + " needed!");
                                   player.sendMessage(ChatColor.GRAY + "Level 66: " + ChatColor.GREEN + level66 + ChatColor.GRAY + " needed!");
                                   player.sendMessage(ChatColor.GRAY + "Level 67: " + ChatColor.GREEN + level67 + ChatColor.GRAY + " needed!");
                                   player.sendMessage(ChatColor.GRAY + "Level 68: " + ChatColor.GREEN + level68 + ChatColor.GRAY + " needed!");
                                   player.sendMessage(ChatColor.GRAY + "Level 69: " + ChatColor.GREEN + level69 + ChatColor.GRAY + " needed!");
                                   player.sendMessage(ChatColor.GRAY + "Level 70: " + ChatColor.GREEN + level70 + ChatColor.GRAY + " needed!");
                                   player.sendMessage(ChatColor.GRAY + "Level 71: " + ChatColor.GREEN + level71 + ChatColor.GRAY + " needed!");
                                   player.sendMessage(ChatColor.GRAY + "Level 72: " + ChatColor.GREEN + level72 + ChatColor.GRAY + " needed!");
                                   player.sendMessage(ChatColor.GRAY + "Level 73: " + ChatColor.GREEN + level73 + ChatColor.GRAY + " needed!");
                                   player.sendMessage(ChatColor.GRAY + "Level 74: " + ChatColor.GREEN + level74 + ChatColor.GRAY + " needed!");
                                   player.sendMessage(ChatColor.GRAY + "Level 75: " + ChatColor.GREEN + level75 + ChatColor.GRAY + " needed!");
                                   player.sendMessage(ChatColor.GRAY + "Level 76: " + ChatColor.GREEN + level76 + ChatColor.GRAY + " needed!");
                                   player.sendMessage(ChatColor.GRAY + "Level 77: " + ChatColor.GREEN + level77 + ChatColor.GRAY + " needed!");
                                   player.sendMessage(ChatColor.GRAY + "Level 78: " + ChatColor.GREEN + level78 + ChatColor.GRAY + " needed!");
                                   player.sendMessage(ChatColor.GRAY + "Level 79: " + ChatColor.GREEN + level79 + ChatColor.GRAY + " needed!");
                                   player.sendMessage(ChatColor.GRAY + "Level 80: " + ChatColor.GREEN + level80 + ChatColor.GRAY + " needed!");
                                   player.sendMessage(ChatColor.GOLD + "--------------"+ChatColor.GRAY+"Page 4"+ChatColor.GOLD +"------------");
                                   return true;
                               }
                            }

                            if (args[2].equalsIgnoreCase("5")){
                                if (args.length == 3){
                                    player.sendMessage(ChatColor.GOLD + "--------------"+ChatColor.GRAY+ "Page 5"+ChatColor.GOLD +"------------");
                                    player.sendMessage(ChatColor.GRAY + "Level 81: " + ChatColor.GREEN + level81 + ChatColor.GRAY + " needed!");
                                    player.sendMessage(ChatColor.GRAY + "Level 82: " + ChatColor.GREEN + level82 + ChatColor.GRAY + " needed!");
                                    player.sendMessage(ChatColor.GRAY + "Level 83: " + ChatColor.GREEN + level83 + ChatColor.GRAY + " needed!");
                                    player.sendMessage(ChatColor.GRAY + "Level 84: " + ChatColor.GREEN + level84 + ChatColor.GRAY + " needed!");
                                    player.sendMessage(ChatColor.GRAY + "Level 85: " + ChatColor.GREEN + level85 + ChatColor.GRAY + " needed!");
                                    player.sendMessage(ChatColor.GRAY + "Level 86: " + ChatColor.GREEN + level86 + ChatColor.GRAY + " needed!");
                                    player.sendMessage(ChatColor.GRAY + "Level 87: " + ChatColor.GREEN + level87 + ChatColor.GRAY + " needed!");
                                    player.sendMessage(ChatColor.GRAY + "Level 88: " + ChatColor.GREEN + level88 + ChatColor.GRAY + " needed!");
                                    player.sendMessage(ChatColor.GRAY + "Level 89: " + ChatColor.GREEN + level89 + ChatColor.GRAY + " needed!");
                                    player.sendMessage(ChatColor.GRAY + "Level 90: " + ChatColor.GREEN + level90 + ChatColor.GRAY + " needed!");
                                    player.sendMessage(ChatColor.GRAY + "Level 91: " + ChatColor.GREEN + level91 + ChatColor.GRAY + " needed!");
                                    player.sendMessage(ChatColor.GRAY + "Level 92: " + ChatColor.GREEN + level92 + ChatColor.GRAY + " needed!");
                                    player.sendMessage(ChatColor.GRAY + "Level 93: " + ChatColor.GREEN + level93 + ChatColor.GRAY + " needed!");
                                    player.sendMessage(ChatColor.GRAY + "Level 94: " + ChatColor.GREEN + level94 + ChatColor.GRAY + " needed!");
                                    player.sendMessage(ChatColor.GRAY + "Level 95: " + ChatColor.GREEN + level95 + ChatColor.GRAY + " needed!");
                                    player.sendMessage(ChatColor.GRAY + "Level 96: " + ChatColor.GREEN + level96 + ChatColor.GRAY + " needed!");
                                    player.sendMessage(ChatColor.GRAY + "Level 97: " + ChatColor.GREEN + level97 + ChatColor.GRAY + " needed!");
                                    player.sendMessage(ChatColor.GRAY + "Level 98: " + ChatColor.GREEN + level98 + ChatColor.GRAY + " needed!");
                                    player.sendMessage(ChatColor.GRAY + "Level 99: " + ChatColor.GREEN + level99 + ChatColor.GRAY + " needed!");
                                    player.sendMessage(ChatColor.GRAY + "Level 100: " + ChatColor.GREEN + level100 + ChatColor.GRAY + " needed!");
                                    player.sendMessage(ChatColor.GOLD + "--------------"+ChatColor.GRAY+"Page 5"+ChatColor.GOLD +"------------");
                                    return true;
                                }
                            }



                        battlepassMain.getInstance().saveConfig();

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