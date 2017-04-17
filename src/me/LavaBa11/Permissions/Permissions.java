package me.LavaBa11.Permissions;

import org.bukkit.event.Listener;
import org.bukkit.permissions.Permission;

import me.LavaBa11.SkyMines;

public class Permissions implements Listener {
	
	public Permissions(SkyMines plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
	}
	
	public static Permission admin = new Permission("skymines.admin");
	public static Permission player = new Permission("skymines.admin");
	public static Permission lOrb = new Permission("skymines.admin");
	

}
