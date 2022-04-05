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
        if (!isPlayerVersusPlayer(event)) return;
        Player damager = (Player) event.getDamager();
 
        if (isDaytime()) {
            event.setCancelled(true);
            damager.sendMessage(ChatColor.RED + "PVP is only available during night time");
        }
    }
    
    private boolean isPlayerVersusPlayer(EntityDamageByEntityEvent event)  {
    	return event.getEntity() instanceof Player && event.getDamager() instanceof Player;
    }
 
    private boolean isDaytime() {
        Server server = NightPVP.server;
        long time = server.getWorld("world").getTime();
 
        return time < 12300 || time > 23850;
    }
}