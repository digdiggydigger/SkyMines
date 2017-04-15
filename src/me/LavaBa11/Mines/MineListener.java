package me.LavaBa11.Mines;

import org.bukkit.Material;
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
		if (!(e.getBlock().getType().equals(Material.COAL_ORE) || (e.getBlock().getType().equals(Material.IRON_ORE) || (e.getBlock().getType().equals(Material.LAPIS_ORE) || (e.getBlock().getType().equals(Material.GOLD_ORE) || (e.getBlock().getType().equals(Material.DIAMOND_ORE) || (e.getBlock().getType().equals(Material.EMERALD_ORE) || (e.getBlock().getType().equals(Material.GLOWING_REDSTONE_ORE)|| (e.getBlock().getType().equals(Material.REDSTONE_ORE)))))))))) {
		e.setCancelled(true);
		}
	}
}