package main.nightpvp;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class AttackListener implements Listener {
	
    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
 
        if (!(event.getEntity() instanceof Player) && !(event.getDamager() instanceof Player)) return;
        Player damager = (Player) event.getDamager();
 
        if (isDaytime()) {
            event.setCancelled(true);
            damager.sendMessage(ChatColor.RED + "PVP is only available during night time");
        }
    }
 
    public boolean isDaytime() {
        Server server = NightPVP.server;
        long time = server.getWorld("world").getTime();
 
        return time < 12300 || time > 23850;
    }
}