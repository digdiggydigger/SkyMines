package me.LavaBa11.Messages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.LavaBa11.SkyMines;
import net.md_5.bungee.api.ChatColor;

public class Help implements Listener {
	
	public Help(SkyMines plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
	}

	
	public static void helpCommand(CommandSender sender) {
		Player player = (Player) sender;
		sender.sendMessage("§7§m--------------=(§r §9§nSkyMines§7 §m)§7=--------------");
		sender.sendMessage("                                                 ");
		sender.sendMessage("§7Welcome To SkyMines " + ChatColor.GOLD +  player.getName() + "§7!");
		sender.sendMessage("§7SkyMines is a custom made, original idea made in house by us!");
		sender.sendMessage("§7SkyMines is a mix of the two popular gamemodes:");
		sender.sendMessage("           §9§nPrison§7 and+ §9§nSkyBlock§7!");
		sender.sendMessage("§7To find out more information about it,");
		sender.sendMessage("§7Visit the §9Information §7GUI with the command:");
		sender.sendMessage("§9/info§7 or for even more information visit our website!");
		sender.sendMessage("§9Website: §7www.skymines.net/");
		
	}
}
