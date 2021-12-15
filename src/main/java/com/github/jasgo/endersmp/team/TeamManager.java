package com.github.jasgo.endersmp.team;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class TeamManager {

    public static List<Team> teamList = new ArrayList<>();
    public static List<String> TEAM_FLAG = Arrays.asList("FlagTrue", "min_1234", "1210");
    public static List<String> TEAM_JONGSEO = Arrays.asList("Sevil_owo", "Me1ony", "IN1BUN", "Uwuchei");
    public static List<String> TEAM_1305 = Arrays.asList("130_5", "MEW_ROKONG", "maker7777", "gkakgud");
    public static List<String> TEAM_ZITEN = Arrays.asList("3bneo", "DANPOONGNAMU", "ddubang2", "uwuaden");

    public static boolean isTeamEgg(Player player, Entity entity) {
        return getPlayerTeam(player).getEgg().equals(entity);
    }

    public static boolean isTeamPlayer(Player player1, Player player2) {
        return getPlayerTeam(player1).getPlayerList().contains(player2);
    }

    public static Team getPlayerTeam(Player player) {
        AtomicReference<Team> atomicTeam = new AtomicReference<>();
        teamList.forEach(team -> {
            if (team.getPlayerList().contains(player)) {
                atomicTeam.set(team);
            }
        });
        return atomicTeam.get();
    }
    public static Team getEggTeam(Entity egg) {
        AtomicReference<Team> atomicTeam = new AtomicReference<>();
        teamList.forEach(team -> {
            if (team.getEgg().getEntity().equals(egg)) {
                atomicTeam.set(team);
            }
        });
        return atomicTeam.get();
    }
}
