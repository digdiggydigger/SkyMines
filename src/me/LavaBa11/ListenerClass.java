package me.LavaBa11;

import org.bukkit.event.Listener;

public class ListenerClass implements Listener {
	
	public ListenerClass(MainClass plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
	}
	
//	@EventHandler
//	public void onEvent(BlockPlaceEvent e) {
//		
//		Player player = e.getPlayer();
//
//		e.setCancelled(true);
//		
//	}
	
}