package com.github.jasgo.endersmp.event;

import com.github.jasgo.endersmp.team.TeamManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (TeamManager.TEAM_FLAG.contains(event.getPlayer().getName())) {

        }
    }
}
