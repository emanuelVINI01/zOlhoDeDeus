package com.zolhodedeus;


import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main extends JavaPlugin {
    ItemStack olho = new ItemStack(Material.getMaterial(getConfig().getInt("id")));
    List<UUID> usando = new ArrayList<UUID>();
    @Override
    public void onEnable() {
        super.onEnable();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new Eventos(),this);
        getCommand("giveolhodedeus").setExecutor(new giveO());
        ItemMeta data = olho.getItemMeta();
        data.setDisplayName(Main.getPlugin(Main.class).getConfig().getString("nome"));
        data.setLore(Main.getPlugin(Main.class).getConfig().getStringList("lore"));
        olho.setItemMeta(data);
    }
}
