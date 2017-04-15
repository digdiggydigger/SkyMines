package me.LavaBa11.Rankup;

import org.bukkit.event.Listener;

import me.LavaBa11.SkyMines;

public class PlayerRankup implements Listener {
	
	public PlayerRankup(SkyMines plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
	}

}
