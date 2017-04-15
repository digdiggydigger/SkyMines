package me.LavaBa11;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.RegionContainer;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

import me.LavaBa11.Mines.MineListener;
import me.LavaBa11.PlayerJoin.PlayerJoin;

public class SkyMines extends JavaPlugin {

	public static Logger logger;
	
	public static WorldGuardPlugin wg;
	public static RegionContainer rc;
	
	@Override
	public void onEnable() {
		logger = getLogger();
		
		wg = getWorldGuard();
		
		if (wg == null) { //Shouldn't be null because we depend on WorldGuard in plugin.yml. But if it's removed, easier to have this here to catch errors.
			logger.severe("Couldn't find WorldGuard dependency. Disabling Plugin");
			Bukkit.getPluginManager().disablePlugin(this);
			return;
		}
		
		rc = getWorldGuard().getRegionContainer();
		
		logger.info("SkyMines has been enabled and ready to go!");
		new MineListener(this);
		new PlayerJoin(this);
	}
			
	@Override
	public void onDisable() {
		logger.info("SkyMines has been disabled safely and securely");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("COMMAND1") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			return true;
			
		}
		
		return false;
		
	}
	
	private WorldGuardPlugin getWorldGuard() {
	    Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");

	    // WorldGuard may not be loaded
	    if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
	        return null; // Maybe you want throw an exception instead
	    }

	    return (WorldGuardPlugin) plugin;
	}
	
}