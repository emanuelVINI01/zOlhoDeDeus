package com.zolhodedeus;

import org.bukkit.entity.Player;

public class zTitleAPI {
    public static void sendTitle(Player p, String title, String subtitle){
        p.sendTitle(title,subtitle);
    }
}
