package com.zolhodedeus;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class giveO implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.hasPermission(Main.getPlugin(Main.class).getConfig().getString("permissao"))){
            if(commandSender instanceof Player){
                Player p = ((Player) commandSender).getPlayer();
                p.getInventory().addItem(Main.getPlugin(Main.class).olho);
                p.sendMessage(Main.getPlugin(Main.class).getConfig().getString("give"));
            }
        }else{
            commandSender.sendMessage(Main.getPlugin(Main.class).getConfig().getString("noperm"));
        }
        return false;
    }
}
