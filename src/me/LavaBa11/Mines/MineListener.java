package me.LavaBa11.Mines;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.LavaBa11.SkyMines;

public class MineListener implements Listener {
	
	public MineListener(SkyMines plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
	}
	
	@EventHandler
	public void onMineEvent(BlockBreakEvent e) {
		
		Player player = e.getPlayer();
		player.sendMessage("");
		Block b = e.getBlock();
		b.setType(Material.AIR);
		e.setCancelled(true);
	}
	
}