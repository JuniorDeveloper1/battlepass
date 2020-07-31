package me.JuniorDeveloper.battlepass.level;

import me.JuniorDeveloper.battlepass.BattlepassMain;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class HashMapLevelQuitJoin implements Listener {
    private BattlepassMain plugin = BattlepassMain.getInstance();

    @EventHandler
    public void join(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!player.hasPlayedBefore()) {
            player.sendMessage("§bWelcome, your level is §a0");

            BattlepassMain.getInstance().levelManagerHashMap.put(player.getUniqueId(), new PlayerLevelManager(0, 0));
            BattlepassMain.getInstance().getConfig().set("PlayerLevels." + player.getUniqueId() + ".level", 0);
            BattlepassMain.getInstance().getConfig().set("PlayerLevels." + player.getUniqueId() + ".xp", 0);
            BattlepassMain.getInstance().saveConfig();
        } else {
            int level = BattlepassMain.getInstance().getConfig().getInt("PlayerLevels." + player.getUniqueId() + ".level");
            int xp = BattlepassMain.getInstance().getConfig().getInt("PlayerLevels." + player.getUniqueId() + ".xp");
            BattlepassMain.getInstance().levelManagerHashMap.put(player.getUniqueId(), new PlayerLevelManager(level, xp));
            BattlepassMain.getInstance().saveConfig();
        }
    }


    @EventHandler
    public void quit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        PlayerLevelManager playerLevelManager = BattlepassMain.getInstance().levelManagerHashMap.get(player.getUniqueId());

        if (BattlepassMain.getInstance().levelManagerHashMap.containsKey(player.getUniqueId())) {
            BattlepassMain.getInstance().getConfig().set("PlayerLevels." + player.getUniqueId() + ".level", playerLevelManager.getLevel());
            BattlepassMain.getInstance().getConfig().set("PlayerLevels." + player.getUniqueId() + ".xp", playerLevelManager.getXp());
            BattlepassMain.getInstance().saveConfig();
            BattlepassMain.getInstance().levelManagerHashMap.remove(player.getUniqueId());
        }
    }
}
