package com.github.jasgo.endersmp;

import com.github.jasgo.endersmp.event.DamageListener;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class EnderSMP extends JavaPlugin {

    @Override
    public void onEnable() {
        ShapelessRecipe recipe1 = new ShapelessRecipe(new NamespacedKey(this, "stone"), new ItemStack(Material.COBBLESTONE));
        recipe1.addIngredient(Material.END_STONE);
        ShapelessRecipe recipe2 = new ShapelessRecipe(new NamespacedKey(this, "stone"), new ItemStack(Material.CHORUS_FRUIT));
        recipe2.addIngredient(Material.BIRCH_LOG);
        this.getServer().getPluginManager().registerEvents(new DamageListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        return false;
    }
}
