package com.github.jasgo.endersmp.game;

import com.github.jasgo.endersmp.EnderSMP;
import com.github.jasgo.endersmp.team.Team;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Slime;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class TeamEgg {
    private Team team;
    private double health;
    private final Entity entity;
    private final BossBar bar;
    private Location loc;

    public TeamEgg(Team team, Entity entity) {
        this.team = team;
        this.entity = entity;
        this.health = 50;
        this.bar = Bukkit.createBossBar(team.getName(), team.getColor(), BarStyle.SOLID);
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }
    public void attack(double damage) {
        setHealth(getHealth() - damage);
    }

    public Entity getEntity() {
        return entity;
    }
    public void updateBar() {
        (new BukkitRunnable() {
            @Override
            public void run() {
                bar.setColor(getTeam().getColor());
                bar.setProgress(getHealth()/50);
            }
        }).runTaskTimer(EnderSMP.getPlugin(EnderSMP.class), 0, 1);
    }

    public BossBar getBar() {
        return bar;
    }

    public void spawn() {
        Location loc = getTeam().getSpawn();
        loc.add(0, 1, 0).getBlock().setType(Material.DRAGON_EGG);
        Slime slime = (Slime) this.entity;
        slime.setSize(1);
        slime.setSilent(true);
        slime.setAI(false);
        slime.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100000, 1, true, false));
        slime.setCustomName("[■■■■■■■■■■■■■■■□□□□□](15/20)");
        slime.setCustomNameVisible(true);
        slime.setGravity(false);

    }

    public void moveTo(Team team) {
        getLocation().getBlock().setType(Material.AIR);
        Location loc = getTeam().getSpawn();
        loc.add(0, 1, 0).getBlock().setType(Material.AIR);
        setTeam(team);
        this.entity.teleport(team.getSpawn());
        setLocation(loc);
    }

    public Location getLocation() {
        return loc;
    }

    public void setLocation(Location loc) {
        this.loc = loc;
    }
}
