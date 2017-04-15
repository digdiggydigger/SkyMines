package me.LavaBa11.Messages;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.LavaBa11.SkyMines;

public class Help implements Listener {
	
	public Help(SkyMines plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
	}

	
	public static void helpCommand(CommandSender sender) {
		Player player = (Player) sender;
		sender.sendMessage("§7§m---------=(§r §9§nSkyMines§7 )§7=§m---------");
		sender.sendMessage("                                                 ");
		sender.sendMessage("§7Welcome To SkyMines §6" + player.getDisplayName() + " §7!");
		sender.sendMessage("§7SkyMines is a custom made, original idea made in house!");
		sender.sendMessage("§7SkyMines is a mix of the two popular gamemodes:");
		sender.sendMessage("           §6§nPrison§7 and+ §6§nSkyBlock§7!");
		sender.sendMessage("§7To find out more information about it then,");
		sender.sendMessage("§7Visit the §6Information §7GUI with the command:");
		sender.sendMessage("§6§n/info§7 For more information visit our website!");
		
	}
	
}
