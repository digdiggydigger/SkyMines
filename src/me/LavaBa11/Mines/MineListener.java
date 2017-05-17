package me.LavaBa11.Mines;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
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
		String worldName = "world"; //TODO: Replace with name of world used on server.
		World world = Bukkit.getServer().getWorld(worldName);
		if (player.getWorld().getName().equals(worldName)) {
			if (!(e.getBlock().getType().equals(Material.COAL_ORE) || (e.getBlock().getType().equals(Material.IRON_ORE) || (e.getBlock().getType().equals(Material.GOLD_ORE) || (e.getBlock().getType().equals(Material.DIAMOND_ORE) || (e.getBlock().getType().equals(Material.EMERALD_ORE) || (e.getBlock().getType().equals(Material.GLOWING_REDSTONE_ORE)|| (e.getBlock().getType().equals(Material.REDSTONE_ORE))))))))) {
				e.setCancelled(true);
				}
		}
	}
}