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
                                player.sendMessage(""); //Levels start!
                                player.sendMessage(ChatColor.GOLD + "--------------"+ChatColor.GRAY+"Page 2"+ChatColor.GOLD +"------------");
                                return true;
                            }

                        }

                        if (args[2].equalsIgnoreCase("3")){
                            if(args.length == 3){
                                player.sendMessage(ChatColor.GOLD + "--------------"+ChatColor.GRAY+ "Page 3"+ChatColor.GOLD +"------------");
                                player.sendMessage(""); //Levels start!
                                player.sendMessage(ChatColor.GOLD + "--------------"+ChatColor.GRAY+"Page 3"+ChatColor.GOLD +"------------");
                                return true;
                            }
                        }

                            if(args[2].equalsIgnoreCase("4")){
                               if(args.length == 3){
                                   player.sendMessage(ChatColor.GOLD + "--------------"+ChatColor.GRAY+ "Page 4"+ChatColor.GOLD +"------------");
                                   player.sendMessage(""); //Levels start!
                                   player.sendMessage(ChatColor.GOLD + "--------------"+ChatColor.GRAY+"Page 4"+ChatColor.GOLD +"------------");
                                   return true;
                               }
                            }

                            if (args[2].equalsIgnoreCase("5")){
                                if (args.length == 3){
                                    player.sendMessage(ChatColor.GOLD + "--------------"+ChatColor.GRAY+ "Page 5"+ChatColor.GOLD +"------------");
                                    player.sendMessage(""); //Levels start!
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