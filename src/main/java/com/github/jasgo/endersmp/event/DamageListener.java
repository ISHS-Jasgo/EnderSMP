package com.github.jasgo.endersmp.event;

import com.github.jasgo.endersmp.game.TeamEgg;
import com.github.jasgo.endersmp.team.Team;
import com.github.jasgo.endersmp.team.TeamManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.SlimeSplitEvent;

public class DamageListener implements Listener {
    @EventHandler
    public void onDamageEgg(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            if (event.getEntity() instanceof Slime) {
                event.setCancelled(true);
                double damage = event.getFinalDamage();
                Player player = (Player) event.getDamager();
                Entity en = event.getEntity();
                if (!TeamManager.isTeamEgg(player, en)) {
                    TeamEgg egg = TeamManager.getEggTeam(en).getEgg();
                    egg.attack(damage);
                    if (egg.getHealth() <= 0) {
                        Team team = TeamManager.getPlayerTeam(player);
                        egg.moveTo(team);
                    }
                }
            } else if (event.getEntity() instanceof Player) {
                if (TeamManager.isTeamPlayer((Player) event.getDamager(), (Player) event.getEntity())) {
                    event.setCancelled(true);
                }
            }
        }
    }
    @EventHandler
    public void onSlimeSplit(SlimeSplitEvent event) {
        event.setCancelled(true);
    }

}
