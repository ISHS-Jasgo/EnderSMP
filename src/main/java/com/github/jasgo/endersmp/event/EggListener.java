package com.github.jasgo.endersmp.event;

import com.github.jasgo.endersmp.team.TeamManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class EggListener implements Listener {

    @EventHandler
    public void onEggTeleport(PlayerInteractEvent event) {
        Action action = event.getAction();
        if (action.equals(Action.PHYSICAL)) return;
        if (action.equals(Action.LEFT_CLICK_BLOCK) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getClickedBlock().getType().equals(Material.DRAGON_EGG)) {
                event.setCancelled(true);

            }
        }
    }

}
