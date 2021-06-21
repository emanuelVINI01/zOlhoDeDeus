package com.zolhodedeus;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;


import java.util.List;

public class OlhoTH  {
    Player p;
    public OlhoTH(Player p){
        this.p = p;
    }
    public void olho() {
        List<String> s = Main.getPlugin(Main.class).getConfig().getStringList("mundosdesativados");
        for (String as : s) {
            if (p.getWorld().getName().equalsIgnoreCase(as)) {
                p.sendMessage(Main.getPlugin(Main.class).getConfig().getString("msgdesabilitado"));
                return;
            }
        }
        Main.getPlugin(Main.class).usando.add(p.getUniqueId());
        p.getInventory().remove(p.getItemInHand());
        p.sendTitle(Main.getPlugin(Main.class).getConfig().getString("ativou"), "");
        p.setGameMode(GameMode.SPECTATOR);
        new BukkitRunnable() {
            @Override
            public void run() {
                p.setGameMode(GameMode.SURVIVAL);
                p.performCommand(Main.getPlugin(Main.class).getConfig().getString("comandospawn"));
                Main.getPlugin(Main.class).usando.remove(p.getUniqueId());
            }
        }.runTaskLater(Main.getPlugin(Main.class),Main.getPlugin(Main.class).getConfig().getInt("tempo")*20);

    }
}
