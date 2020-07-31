package me.JuniorDeveloper.battlepass.commands;

import me.JuniorDeveloper.battlepass.BattlepassMain;
import me.JuniorDeveloper.battlepass.helper.Text;
import me.JuniorDeveloper.battlepass.level.PlayerLevelManager;
import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.util.ChatPaginator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class AllCommands implements Listener, CommandExecutor {
    Economy eco = BattlepassMain.getEconomy();

    public String cmd1 = "bp";
    private BattlepassMain plugin = BattlepassMain.getInstance();


@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        String logo = ChatColor.translateAlternateColorCodes('&', "//");
        String noPermissions = ChatColor.translateAlternateColorCodes('&', "&c You don't have enough permissions.");
        String noArguments = ChatColor.translateAlternateColorCodes('&', "&c&lNO &3 arugments have been found!");
        String commandUsage = ChatColor.translateAlternateColorCodes('&', "&c&lUssage : &c/bp check level <player>!");
        String staff = ChatColor.translateAlternateColorCodes('&', "&7[&6Staff&7]");
        String tryThis = ChatColor.translateAlternateColorCodes('&', "&a&lTry! :");


        if (sender instanceof Player) {
            Player player = (Player) sender;
            PlayerLevelManager playerLevelManager = BattlepassMain.getInstance().levelManagerHashMap.get(player.getUniqueId());

            if (cmd.getName().equalsIgnoreCase(cmd1)) {
                if (args.length == 0) {
                    //Help infromation
                    player.sendMessage(noArguments);
                    player.sendMessage(tryThis + ChatColor.GOLD + "/bp help");
                    player.sendMessage(ChatColor.GOLD + "----------------------------");
                    player.sendMessage(ChatColor.GOLD + "Author :" + ChatColor.GREEN + " JuniorDeveloper");
                    player.sendMessage(ChatColor.GOLD + "Version :" + ChatColor.GREEN + " 1.0.4");
                    player.sendMessage(ChatColor.GOLD + "----------------------------");
                    return true;
                }


                if (args[0].equalsIgnoreCase("help")) {
                    player.sendMessage(noArguments);
                    player.sendMessage(tryThis + ChatColor.GOLD + "/bp level" + ChatColor.GRAY + " Shows your level!");
                    player.sendMessage(tryThis + ChatColor.GOLD + "/bp challanges" + ChatColor.GRAY + " Shows challanges!");
                    player.sendMessage(tryThis + ChatColor.GOLD + "/bp check level <player>" + ChatColor.GRAY + " Checks someone's player level!");
                    player.sendMessage(tryThis + ChatColor.GOLD + "/bp xp list <pageNumber>" + ChatColor.GRAY + " Checks the xp list for an level up!");
                    player.sendMessage(tryThis + ChatColor.GOLD + "/bp balance <player>" + ChatColor.GRAY + " Checks someone's balance!.");
                    player.sendMessage(tryThis + ChatColor.GOLD + "/bp balance " + ChatColor.GRAY + " Checks your balance!.");

                    if (player.hasPermission("battlepass.Staff")) {
                        player.sendMessage(tryThis + ChatColor.GRAY + "/bp withdraw|desposit <player>");

                    }
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
                            PlayerLevelManager playerCheckerLevel = BattlepassMain.getInstance().levelManagerHashMap.get(otherPlayerLevelCheck.getUniqueId());
                            player.sendMessage(ChatColor.GREEN + otherPlayerLevelCheck.getName() + ChatColor.GRAY + " Level is : " + ChatColor.GREEN + playerCheckerLevel.getLevel());
                        }

                    }


                }
                if (args[0].equalsIgnoreCase("xp")) {
                    if (args.length <= 1) {
                        player.sendMessage(tryThis + ChatColor.RED + "/bp xp list");
                        return true;
                    }
                    if (args[1].equalsIgnoreCase("list")) {
                        if (args.length == 2) {
                            player.sendMessage(ChatColor.RED + "You need a page number!");
                            return true;
                        }
                        List<Integer> levels = new ArrayList<>();

                        for (int i = 1; i <= 100; i++) {
                            levels.add(BattlepassMain.getInstance().getConfig().getInt("Levels." + i + ".xp"));
                        }

                        ChatPaginator.ChatPage pages = ChatPaginator.paginate(IntStream.range(0, levels.size()).mapToObj(i -> {
                            return Text.colorize("&7Level " + (i + 1) + ": &a" + levels.get(i) + "&7 needed!");
                        }).collect(Collectors.joining("\n")), Integer.parseInt(args[2]));

                        player.sendMessage(Text.colorize("&6-------------- &7Page &e" + pages.getPageNumber() + "&7/&e" + pages.getTotalPages() + "" + "&6------------"));
                        player.sendMessage(pages.getLines());
                        player.sendMessage(Text.colorize("&6-------------- &7Page &e" + pages.getPageNumber() + "&7/&e" + pages.getTotalPages() + "" + "&6------------"));
                    } //End bp xp list <page>
                } //End bp xp <list>


                if (args[0].equalsIgnoreCase("balance")) {
                    Economy economy = BattlepassMain.getEconomy();

                    if (args.length == 0) {
                        player.sendMessage(tryThis + ChatColor.GOLD + "/bp balance " + ChatColor.GRAY + " Checks your balance!.");
                        return true;
                    }


                    if (args.length == 1) {
                        player.sendMessage(Text.colorize("&6") + "Your current balance is " + Text.colorize("&7 $") + economy.format(economy.getBalance(player)));
                        return true;
                    }

                    if (args.length == 2) {
                        Player checkOtherBalance = Bukkit.getPlayer(args[1]);
                        try {
                            player.sendMessage(Text.colorize("&6") + checkOtherBalance.getName() +
                                    Text.colorize(" §7has $") + economy.format(economy.getBalance(checkOtherBalance)) + Text.colorize(" &7 in their account"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return true;
                    }

                }

                if(player.hasPermission("battlepass.Staff"))    {
                    if(args[0].equalsIgnoreCase("withdraw"))    {




                        if(args.length == 0){
                            player.sendMessage(commandUsage);
                            return true;
                        }
                        if(args.length == 1)    {
                            player.sendMessage(tryThis + Text.colorize("&a/bp withdraw &c<player> "));
                            return true;
                        }

                        if(args.length == 2){
                            return true;
                        }
                        if(args.length == 3){


                            try{
                                Player target = Bukkit.getPlayer(args[1]);
                                double remove_amount = Double.valueOf(args[2]);
                                EconomyResponse response = eco.withdrawPlayer(target, remove_amount);

                                player.sendMessage(Text.colorize("&6 You have succesfully removed") + Text.colorize("&7") + eco.format(response.amount)
                                        + Text.colorize("&6 from") + target.getName() + "balance!");
                                player.sendMessage(Text.colorize("&6" + target.getName() + Text.colorize("&7 new balance is :") + eco.format(eco.getBalance(target))));
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            return true;
                        }


                    }
                }else {
                    player.sendMessage(noPermissions);
                    return true;
                }

            } /* End "/bp <args> <args> <args>" */ else {
                return true;
            }
            return true;
        }
    return false;
    }



}





