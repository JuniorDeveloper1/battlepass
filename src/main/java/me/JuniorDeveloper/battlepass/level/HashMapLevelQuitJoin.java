package me.JuniorDeveloper.battlepass.level;

import me.JuniorDeveloper.battlepass.battlepassMain;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class HashMapLevelQuitJoin implements Listener {


    //TODO: Player Join error : Line Unknown
    @EventHandler
    public void join(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!player.hasPlayedBefore()) {
            player.sendMessage("§bWelcome, your level is §a0");

            battlepassMain.getInstance().levelManagerHashMap.put(player.getUniqueId(), new PlayerLevelManager(0, 0));
            battlepassMain.getInstance().getConfig().set("PlayerLevels." + player.getUniqueId() + ".level", 0);
            battlepassMain.getInstance().getConfig().set("PlayerLevels." + player.getUniqueId() + ".xp", 0);
            battlepassMain.getInstance().saveConfig();


        } else {
            int level = battlepassMain.getInstance().getConfig().getInt("PlayerLevels." + player.getUniqueId() + ".level");
            int xp = battlepassMain.getInstance().getConfig().getInt("PlayerLevels." + player.getUniqueId() + ".xp");
            battlepassMain.getInstance().levelManagerHashMap.put(player.getUniqueId(), new PlayerLevelManager(level, xp));
            battlepassMain.getInstance().saveConfig();

        }
    }

    //TODO: Player quit error : Line Unknown
    @EventHandler
    public void quit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        PlayerLevelManager playerLevelManager = battlepassMain.getInstance().levelManagerHashMap.get(player.getUniqueId());

        if (battlepassMain.getInstance().levelManagerHashMap.containsKey(player.getUniqueId())) {
            battlepassMain.getInstance().getConfig().set("PlayerLevels." + player.getUniqueId() + ".level", playerLevelManager.getLevel());
            battlepassMain.getInstance().getConfig().set("PlayerLevels." + player.getUniqueId() + ".xp", playerLevelManager.getXp());
            battlepassMain.getInstance().saveConfig();
            battlepassMain.getInstance().levelManagerHashMap.remove(player.getUniqueId());
        }
    }
}
