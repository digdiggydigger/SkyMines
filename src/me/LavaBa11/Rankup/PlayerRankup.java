package me.LavaBa11.Rankup;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.LavaBa11.SkyMines;

public class PlayerRankup implements Listener {
	
	public PlayerRankup(SkyMines plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
	}
	
	public static void rankupCommand(CommandSender sender) {
		Player player = (Player) sender;
		
		
	}

}
