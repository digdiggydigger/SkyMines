package me.LavaBa11.BlockManip;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import me.LavaBa11.SkyMines;

// import me.LavaBa11.Permissions.Permissions;

public class IngotMultipliers implements Listener {
	
	public IngotMultipliers(SkyMines plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
	}
	
	Random rand = new Random();
	
	@EventHandler
	public void coalOre(BlockBreakEvent e) {
		Bukkit.broadcastMessage("Block Broken");
		Player player = e.getPlayer();
		Block blockBroken = e.getBlock();
		Bukkit.broadcastMessage("Block Broken 1:" + blockBroken);
		int number = rand.nextInt(100) + 1;
		Bukkit.broadcastMessage("Number 1: " + number);
//		if (!(player.hasPermission(Permissions.RankE))) {
			if (blockBroken.getType().equals(Material.DIRT)) {
				Bukkit.broadcastMessage("blockBroken 2: " + blockBroken);
				if (number >= 50) {
					Bukkit.broadcastMessage("Number 2: " + number);
					Location loc = e.getBlock().getLocation();
					World world = e.getPlayer().getWorld();
					Bukkit.broadcastMessage("ItemStack");
					ItemStack coal = new ItemStack(Material.COAL);
					coal.setAmount(10);
					Bukkit.broadcastMessage("Before Drop");
					world.dropItem(loc, coal);
					Bukkit.broadcastMessage("After Drop");
				} else {	
					
				}
			}	
//		}	
	}
}
