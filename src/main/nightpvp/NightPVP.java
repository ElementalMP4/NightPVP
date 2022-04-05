package main.nightpvp;
 
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;
 
 
public final class NightPVP extends JavaPlugin {
    
	public static Server server;
	
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new AttackListener(), this);
        server = getServer();
        getLogger().info("NightPVP Enabled");
    }
}