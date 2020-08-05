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
    static String noPermissions = ChatColor.translateAlternateColorCodes('&', "&c You don't have enough permissions.");
    static String noArguments = ChatColor.translateAlternateColorCodes('&', "&c&lNO &3 arugments have been found!");
    static String commandUsage = ChatColor.translateAlternateColorCodes('&', "&c&lUssage : &c/bp check level <player>!");
    static String staff = ChatColor.translateAlternateColorCodes('&', "&7[&6Staff&7]");
    static String tryThis = ChatColor.translateAlternateColorCodes('&', "&a&lTry! :");
    public String cmd1 = "bp";
    Economy eco = BattlepassMain.getEconomy();
    private BattlepassMain plugin = BattlepassMain.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        if (sender instanceof Player) {
            String logo = BattlepassMain.getInstance().getConfig().getString("Messages.logo");
            Player player = (Player) sender;
            PlayerLevelManager playerLevelManager = BattlepassMain.getInstance().levelManagerHashMap.get(player.getUniqueId());

            if (cmd.getName().equalsIgnoreCase(cmd1)) {
                if (args.length == 0) {
                    //Help infromation
                    player.sendMessage(noArguments);
                    player.sendMessage(logo + tryThis + ChatColor.GOLD + "/bp help");
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
                        player.sendMessage(logo + tryThis + ChatColor.GRAY + "/bp withdraw|desposit <player> <amount>");

                    }
                    return true;

                }


                if (args[0].equalsIgnoreCase("level")) {
                    player.sendMessage(logo + ChatColor.GRAY + "Your level is : " + ChatColor.GREEN + playerLevelManager.getLevel());

                }
                if (args[0].equalsIgnoreCase("xp")) {
                    player.sendMessage(logo + ChatColor.GRAY + "Your xp is : " + ChatColor.GREEN + playerLevelManager.getXp());
                }
                if (args[0].equalsIgnoreCase("challanges")) {
                    player.sendMessage(logo + ChatColor.GRAY + " Your challanges ! :");
                    player.sendMessage(logo + ChatColor.GOLD + "     Challange 1");

                }


                if (args[0].equalsIgnoreCase("check")) {
                    if (args.length == 1) {
                        player.sendMessage(logo + commandUsage);
                        return true;
                    }


                    if (args[1].equalsIgnoreCase("level")) {
                        if (args.length == 2) {
                            player.sendMessage(commandUsage);
                            return true;
                        }

                        Player otherPlayerLevelCheck = Bukkit.getServer().getPlayer(args[2]);
                        if (otherPlayerLevelCheck == null) {
                            player.sendMessage(logo + ChatColor.RED + "Not player found!");
                            return true;

                        } else if (otherPlayerLevelCheck != null) {
                            PlayerLevelManager playerCheckerLevel = BattlepassMain.getInstance().levelManagerHashMap.get(otherPlayerLevelCheck.getUniqueId());
                            player.sendMessage(logo + ChatColor.GREEN + otherPlayerLevelCheck.getName() + ChatColor.GRAY + " Level is : " + ChatColor.GREEN + playerCheckerLevel.getLevel());
                        }

                    }


                }
                if (args[0].equalsIgnoreCase("xp")) {
                    if (args.length <= 1) {
                        player.sendMessage(logo + tryThis + ChatColor.RED + "/bp xp list");
                        return true;
                    }
                    if (args[1].equalsIgnoreCase("list")) {
                        if (args.length == 2) {
                            player.sendMessage(logo + ChatColor.RED + "You need a page number!");
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
                        player.sendMessage(logo + tryThis + ChatColor.GOLD + "/bp balance " + ChatColor.GRAY + " Checks your balance!.");
                        return true;
                    }


                    if (args.length == 1) {
                        player.sendMessage(logo + Text.colorize("&6") + "Your current balance is " + Text.colorize("&7 $") + economy.format(economy.getBalance(player)));
                        return true;
                    }

                    if (args.length == 2) {
                        Player checkOtherBalance = Bukkit.getPlayer(args[1]);
                        try {
                            player.sendMessage(logo + Text.colorize("&6") + checkOtherBalance.getName() +
                                    Text.colorize(" §7has $") + economy.format(economy.getBalance(checkOtherBalance)) + Text.colorize(" &7 in their account"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return true;
                    }

                }

                if (player.hasPermission("battlepass.Staff")) {
                    if (args[0].equalsIgnoreCase("withdraw")) {
                        if (args.length == 0) {
                            player.sendMessage(logo + commandUsage);
                            return true;
                        }
                        if (args.length == 1) {
                            player.sendMessage(logo + tryThis + Text.colorize("&a/bp withdraw &c<player> <amount> "));
                            return true;
                        }

                        if (args.length == 2) {
                            player.sendMessage(logo + tryThis + Text.colorize("&a/bp withdraw <player> &c<amount> "));
                            return true;
                        }
                        if (args.length == 3) {

                            try {
                                Player target = Bukkit.getPlayer(args[1]);
                                double remove_amount = Double.valueOf(args[2]);
                                withdraw(target, remove_amount);
                                player.sendMessage(logo + Text.colorize("&7 You have succesfully removed ") + Text.colorize("&6$") + remove_amount + Text.colorize(" &6 Dollar ") + Text.colorize(" &7 from ") + Text.colorize(" &6") + target.getName() + Text.colorize(" &7balance!"));

                                target.sendMessage(logo + Text.colorize("&7") + player.getName() + Text.colorize(" &7 has removed ") + Text.colorize("&6$") + remove_amount + Text.colorize(" &6 Dollar ") + Text.colorize("&7 from ")
                                        + Text.colorize("&6") + Text.colorize(" &7your balance!"));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return true;
                        }


                    }
                    if (args[0].equalsIgnoreCase("deposit")) {
                        if (args.length == 0) {
                            player.sendMessage(logo + commandUsage);
                            return true;
                        }
                        if (args.length == 1) {
                            player.sendMessage(logo + tryThis + Text.colorize("&a/bp desposit &c<player> <amount> "));
                            return true;
                        }

                        if (args.length == 2) {
                            player.sendMessage(logo + tryThis + Text.colorize("&a/bp desposit <player> &c<amount> "));
                            return true;
                        }
                        if (args.length == 3) {


                            try {
                                Player target = Bukkit.getPlayer(args[1]);
                                double add_amount = Double.valueOf(args[2]);
                                deposit(target, add_amount);
                                player.sendMessage(logo + Text.colorize("&7 You have added ") + Text.colorize("&6$") + add_amount + Text.colorize(" &6 Dollar ") + Text.colorize("&7 to ")
                                        + Text.colorize("&6") + target.getName() + Text.colorize(" &7 balance!"));

                                target.sendMessage(logo + Text.colorize("&7") + player.getName() + Text.colorize(" &7has added ") + Text.colorize("&6$") + add_amount + Text.colorize(" &6 Dollar ") + Text.colorize("&7 to ")
                                        + Text.colorize("&6") + Text.colorize(" &7 your balance!"));


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return true;
                        }

                    }
                } else {
                    player.sendMessage(logo + noPermissions);
                    return true;
                }

            } /* End "/bp <args> <args> <args>" */ else {
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean withdraw(Player player, double remove_amount) {
        EconomyResponse economyResponse = BattlepassMain.getEconomy().withdrawPlayer(player, remove_amount);
        if (economyResponse.transactionSuccess()) {
            return true;
        } else {
            player.sendMessage(Text.colorize(String.format("&cAn error occurred: %s", economyResponse.errorMessage)));
            return false;
        }
    }


    private boolean deposit(Player player, double add_amout) {
        EconomyResponse economyResponse = BattlepassMain.getEconomy().depositPlayer(player, add_amout);
        if (economyResponse.transactionSuccess()) {
            return true;
        } else {
            player.sendMessage(Text.colorize(String.format("&cAn error occurred: %s", economyResponse.errorMessage)));
            return false;
        }

    }


}






