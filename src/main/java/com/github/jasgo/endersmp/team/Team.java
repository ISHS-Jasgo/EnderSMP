package com.github.jasgo.endersmp.team;

import com.github.jasgo.endersmp.game.TeamEgg;
import org.bukkit.Location;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Team {

    private final List<Player> playerList = new ArrayList<>();
    private final String name;
    private final TeamEgg egg;
    private final BarColor color;
    private final Location spawn;

    public Team(String name, TeamEgg egg, BarColor color, Location spawn, Player... playerList) {
        this.name = name;
        this.egg = egg;
        this.color = color;
        this.spawn = spawn;
        this.playerList.addAll(Arrays.asList(playerList));
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public TeamEgg getEgg() {
        return egg;
    }

    public BarColor getColor() {
        return color;
    }

    public Location getSpawn() {
        return spawn;
    }
}
