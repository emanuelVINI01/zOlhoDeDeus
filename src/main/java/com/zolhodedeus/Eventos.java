package com.zolhodedeus;

import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;



public class Eventos implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) throws InterruptedException {
        e.getPlayer().setGameMode(GameMode.SURVIVAL);
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) throws InterruptedException {
        try {
            if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR){
                if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains(Main.getPlugin(Main.class).getConfig().getString("nome"))) {
                    new OlhoTH(e.getPlayer()).olho();
                }
            }
        }catch(NullPointerException se){

        }
    }
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        boolean usando = Main.getPlugin(Main.class).usando.contains(e.getPlayer().getUniqueId());
        if(usando){
            e.getPlayer().sendMessage("§cVocê não pode falar no chat usando olho de deus!");
            e.setCancelled(true);
        }
    }
}
