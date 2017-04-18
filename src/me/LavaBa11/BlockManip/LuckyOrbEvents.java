package me.LavaBa11.BlockManip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.LavaBa11.SkyMines;

public class LuckyOrbEvents implements Listener {
	
	public LuckyOrbEvents(SkyMines plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
	}
	Random r = new Random();
	
	public static ArrayList<Material> randomItems() { 
		
		ArrayList<Material> items = new ArrayList<Material>();
		items.add(Material.LEATHER_HELMET);
		items.add(Material.LEATHER_CHESTPLATE);
		items.add(Material.LEATHER_LEGGINGS);
		items.add(Material.LEATHER_BOOTS);
		return items;

	}
	
	
	@EventHandler
	public void onLuckyOrbPlace(BlockPlaceEvent e) {
		Player player = e.getPlayer();
		ItemStack lOrb = new ItemStack(Material.SOUL_SAND);
		ItemMeta lOrbM = lOrb.getItemMeta();
		lOrbM.setDisplayName("§c§lLucky Orb");
		lOrbM.setLore(Arrays.asList("§7Place this on a §6§nGold Block§7 to uncover,", "§7One of its many, many rare rewards!"));
		lOrb.setItemMeta(lOrbM);
		
		Block block = e.getBlock();
		Block below = block.getRelative(BlockFace.DOWN);
		if (below.getType().equals(Material.GOLD_BLOCK)) {
			if (e.getBlock().getType().equals(Material.SOUL_SAND)) {
				ItemStack is = player.getItemInHand();
				if (is.hasItemMeta()) {
					ItemMeta im = is.getItemMeta();
					if (im.getDisplayName().equalsIgnoreCase("§c§lLucky Orb")) {
						player.sendMessage("§a§lYES");	
					}
				}
			} else {
				e.setCancelled(true);
			}
		}	
	}
}
