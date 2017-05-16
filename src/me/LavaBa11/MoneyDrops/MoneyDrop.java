package me.LavaBa11.MoneyDrops;

import org.bukkit.event.Listener;

import me.LavaBa11.SkyMines;

public class MoneyDrop implements Listener {
	
	public MoneyDrop(SkyMines plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
	}

}
