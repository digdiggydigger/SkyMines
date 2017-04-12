package me.LavaBa11;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin {

	@Override
	public void onEnable() {
			getLogger().info("_____ has been enabled and ready to go!");
			new ListenerClass(this); {
	
			}
	}
			
	@Override
	public void onDisable() {
			getLogger().info("_____ has been disabled safley and secruley");

}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("COMMAND1") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			return true;
			
		}
		
		return false;	
		
	}
	
}