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
import me.LavaBa11.Permissions.Permissions;

public class OreDrops implements Listener {
	
	public OreDrops(SkyMines plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
	}
	
	Random rand = new Random();
	
	public static ItemStack lapis = new ItemStack(Material.INK_SACK, 1, (short) 4);
	
	int multiplier = 0;
	int amount = 0;
	
	@EventHandler
	public void onOreDestroy(BlockBreakEvent e) {
		Player player = e.getPlayer();
		Material block = e.getBlock().getType();
		Block blockBroken = e.getBlock();

		if (block == Material.COAL_ORE) {
			if (!(player.hasPermission(Permissions.RankE))) {
				e.getBlock().setType(Material.AIR);
				ItemStack coal = new ItemStack(Material.COAL);
				player.getInventory().addItem(coal);
			} else {
				int number = rand.nextInt(100) + 1;
					if (blockBroken.getType().equals(Material.COAL_ORE)) {
						if (number >= 50) {
							ItemStack coal = new ItemStack(Material.COAL);
							multiplier = 2;
							int amount = 1 * multiplier;
							coal.setAmount(amount);
							player.getInventory().addItem(coal);
			}
		}
					
		if (block == Material.IRON_ORE) {
			e.getBlock().setType(Material.AIR);
			ItemStack iron = new ItemStack(Material.IRON_INGOT);
			player.getInventory().addItem(iron);
		}
		
		if (block == Material.LAPIS_ORE) {
			e.getBlock().setType(Material.AIR);
			ItemStack lapiss = new ItemStack(lapis);
			player.getInventory().addItem(lapiss);
		}
		
		if (block == Material.GOLD_ORE) {
			e.getBlock().setType(Material.AIR);
			ItemStack gold = new ItemStack(Material.GOLD_INGOT);
			player.getInventory().addItem(gold);
		}
		
		if (block == Material.REDSTONE_ORE) {
			e.getBlock().setType(Material.AIR);
			ItemStack redstone = new ItemStack(Material.REDSTONE);
			player.getInventory().addItem(redstone);
		}
		
		if (block == Material.GLOWING_REDSTONE_ORE) {
			e.getBlock().setType(Material.AIR);
			ItemStack redstone = new ItemStack(Material.REDSTONE);
			player.getInventory().addItem(redstone);
		}
		
		if (block == Material.DIAMOND_ORE) {
			e.getBlock().setType(Material.AIR);
			ItemStack diamond = new ItemStack(Material.DIAMOND);
			player.getInventory().addItem(diamond);
		}
		
		if (block == Material.EMERALD_ORE) {
			e.getBlock().setType(Material.AIR);
			ItemStack emerald = new ItemStack(Material.EMERALD);
			player.getInventory().addItem(emerald);
				}
			}
		}		
	}
}
