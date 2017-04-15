package me.LavaBa11;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

import me.LavaBa11.BlockManip.OreDrops;
import me.LavaBa11.Messages.Help;
import me.LavaBa11.Mines.MineListener;
import me.LavaBa11.Mines.MineLoader;
import me.LavaBa11.Mines.MineRegenerator;
import me.LavaBa11.PlayerJoin.PlayerJoin;
import me.LavaBa11.Rankup.PlayerRankup;

public class SkyMines extends JavaPlugin {

	public static Logger logger;
	
	public static WorldGuardPlugin wg;
	
	public static String prefix = "§8(§9SkyMines§8)§7";
	
	@Override
	public void onEnable() {
		logger = getLogger();
		
		wg = getWorldGuard();
		
		if (wg == null) { //Shouldn't be null because we depend on WorldGuard in plugin.yml. But if it's removed, easier to have this here to catch errors.
			logger.severe("Couldn't find WorldGuard dependency. Disabling Plugin");
			Bukkit.getPluginManager().disablePlugin(this);
			return;
		}
		
		logger.info("SkyMines has been enabled and ready to go!");
		new MineLoader(); //Loads the mines/regions.
		
		long tenMinutes = 
				(20) * //The measurement is in Minecraft game ticks, and ticks run 20 times a second. So, we times how many seconds we want to wait by 20.
				((60) * (10)); //This determines how many seconds for 10 minutes.
		new MineRegenerator().runTaskTimer(this, 0L, tenMinutes); //Regenerates the ores
		
		new MineListener(this);
		new PlayerJoin(this);
		new Help(this);
		new PlayerRankup(this);
		new OreDrops(this);
	}
			
	@Override
	public void onDisable() {
		logger.info("SkyMines has been disabled safely and securely");
		//Changed Odd
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("skymines") || (cmd.getName().equalsIgnoreCase("skymine")) && sender instanceof Player) {
			Player player = (Player) sender;			
			Help.helpCommand(player);
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("coalsell") && sender instanceof Player) {
				Player player = (Player) sender;
				
				ItemStack ii = new ItemStack(Material.IRON_INGOT);
				if (player.getInventory().contains(ii)) {
					if (ii.getAmount() <= 64) {
						player.getInventory().removeItem(new ItemStack(Material.IRON_INGOT));
						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "eco give " + player.getName() + " 2");
	//					player.updateInventory();
				}
			}
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