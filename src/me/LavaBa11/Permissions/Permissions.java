package me.LavaBa11.Permissions;

import org.bukkit.event.Listener;
import org.bukkit.permissions.Permission;

import me.LavaBa11.SkyMines;

public class Permissions implements Listener {
	
	public Permissions(SkyMines plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
	}
	
	
	// ADMIN
	public static Permission admin = new Permission("skymines.admin");
	
	// LUCKY ORB
	public static Permission lOrb = new Permission("skymines.lorb");
	
	// RANK INGOT MULTIPLIERS
	public static Permission RankE = new Permission("skymines.E");
	
	public static Permission RankJ = new Permission("skymines.J");
	
	public static Permission RankO = new Permission("skymines.O");
	
	public static Permission RankT = new Permission("skymines.T");
	
	public static Permission RankY = new Permission("skymines.Y");

	public static Permission RankZ = new Permission("skymines.Z");

}
