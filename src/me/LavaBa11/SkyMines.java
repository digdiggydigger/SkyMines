package me.LavaBa11;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.LavaBa11.Mines.MineListener;
import me.LavaBa11.PlayerJoin.PlayerJoin;

public class SkyMines extends JavaPlugin {

	@Override
	public void onEnable() {
<<<<<<< Updated upstream
		getLogger().info("_____ has been enabled and ready to go!");
		new MineListener(this); 
=======
<<<<<<< HEAD
			getLogger().info("SkyMines has been enabled and ready to go!");
			new MineListener(this); {
			new PlayerJoin(this);
	
			}
=======
		getLogger().info("_____ has been enabled and ready to go!");
		new MineListener(this); 
>>>>>>> origin/master
>>>>>>> Stashed changes
	}
			
	@Override
	public void onDisable() {
<<<<<<< Updated upstream
		getLogger().info("_____ has been disabled safley and securely");
	}
=======
<<<<<<< HEAD
			getLogger().info("SkyMines has been disabled safley and securley");

}
=======
		getLogger().info("_____ has been disabled safley and securely");
	}
>>>>>>> origin/master
>>>>>>> Stashed changes
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("COMMAND1") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			return true;
			
		}
		
		return false;	
		
	}
	
}