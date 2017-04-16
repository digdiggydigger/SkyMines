package me.LavaBa11.Mines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;

import com.sk89q.worldedit.BlockVector;
import com.sk89q.worldedit.BlockVector2D;
import com.sk89q.worldguard.protection.regions.GlobalProtectedRegion;
import com.sk89q.worldguard.protection.regions.ProtectedCuboidRegion;
import com.sk89q.worldguard.protection.regions.ProtectedPolygonalRegion;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

import me.LavaBa11.SkyMines;

public class MineRegenerator extends BukkitRunnable{
	
	private static final double percentOfCoal = .30;
	private static final double percentOfIron = .30;
	private static final double percentOfGold = .20;
	private static final double percentOfDiamond = .10;
	private static final double percentOfEmerald = .10;
	
	
	private static final double percentOfLapis = .10;
	
	private static boolean hasBeenTwentyMinutes = false;
	
	private static HashMap<ProtectedRegion,ArrayList<Location>> oreLocations = new HashMap<ProtectedRegion, ArrayList<Location>>();
	
	public MineRegenerator() {
		SkyMines.logger.info("Loading Ore Locations");
		int mineIndex = 0;
		for (ProtectedRegion region : MineLoader.mines) {
			List<Block> blocks = getBlocks(region);
			
			ArrayList<Location> oreBlockLocations = new ArrayList<Location>();
			
			for (Block b : blocks) {
				if (b.getType().equals(Material.COAL_ORE) || 
					b.getType().equals(Material.IRON_ORE) || 
					b.getType().equals(Material.GOLD_ORE) || 
					b.getType().equals(Material.DIAMOND_ORE) || 
					b.getType().equals(Material.EMERALD_ORE)) {
					oreBlockLocations.add(b.getLocation());
					
					SkyMines.logger.info("Adding block at location: x:" + b.getLocation().getBlockX() + " y:" + b.getLocation().getBlockY() + " z: " + b.getLocation().getBlockZ() + " to a region.");
				}else{
					SkyMines.logger.info("Found a block that isn't an ore.");
				}
			}
			
			oreLocations.put(region, oreBlockLocations);
			SkyMines.logger.info("Adding Region and Locations to oreLocations");
		}
	}
	
	@Override
	public void run() {
		
		int mineIndex = 0;
		for (ProtectedRegion region : MineLoader.mines) {
			if (!hasBeenTwentyMinutes) {
				if (mineIndex == 4 || mineIndex == 5) continue;
			}
			ArrayList<Location> blockLocations = oreLocations.get(region);
			
			int amount = blockLocations.size();
			SkyMines.logger.info("Amount of ore blocks in region:");
			
			
			//Get list of Materials
			ArrayList<Material> ores = new ArrayList<Material>();
			
			int coalBlocks = (int) ((double) amount * percentOfCoal);
			int ironBlocks = (int) ((double) amount * percentOfIron);
			int goldBlocks = (int) ((double) amount * percentOfGold);
			int diamondBlocks = (int) ((double) amount * percentOfDiamond);
			int emeraldBlocks = (int) ((double) amount * percentOfEmerald);
			
			int totalBlocks = coalBlocks + ironBlocks + goldBlocks + diamondBlocks + emeraldBlocks;
			
			int leftOver = 0;
			if (totalBlocks < amount) {
				leftOver = amount-totalBlocks;
				SkyMines.logger.info("TotalBlocks is less than amount. Add " + leftOver + " coalOres");
			}else if (totalBlocks > amount) {
				int difference = totalBlocks - amount;
				SkyMines.logger.info("Odd Configuration For MineRegenerator. Contact Developer. Difference between totalBlocks and amount: " + difference);
				
				coalBlocks -= difference;
			}else{
				SkyMines.logger.info("TotalBlocks is the same size as amount");
			}
			
			for (int i = 0; i < coalBlocks; i++) {
				ores.add(Material.COAL_ORE);
			}
			
			for (int i = 0; i < ironBlocks; i++) {
				ores.add(Material.IRON_ORE);
			}
			
			for (int i = 0; i < goldBlocks; i++) {
				ores.add(Material.GOLD_ORE);
			}
			
			for (int i = 0; i < diamondBlocks; i++) {
				ores.add(Material.DIAMOND_ORE);
			}
			
			for (int i = 0; i < emeraldBlocks; i++) {
				ores.add(Material.EMERALD_ORE);
			}
			
			Collections.shuffle(ores);
			
			SkyMines.logger.info("Shuffled Ore List:");
			String toPrint = "[";
			
			for (int i = 0; i < ores.size(); i++) {
				toPrint += ores.get(i).name() + ", ";
			}
			
			toPrint = toPrint.trim();
			toPrint += "]";
			
			SkyMines.logger.info(toPrint);
			
			if(ores.size() != blockLocations.size()) {
				SkyMines.logger.info("Sizes are not equal! Must fix!");
				continue;
			}
			
			for (int i = 0; i < blockLocations.size(); i++) {
				blockLocations.get(i).getWorld().getBlockAt(blockLocations.get(i)).setType(ores.get(i));
			}
			
			SkyMines.logger.info("Succesfully regenerated a mine");
			
			mineIndex++;
		}
		
		if (hasBeenTwentyMinutes) {
			hasBeenTwentyMinutes = false;
		}else{
			hasBeenTwentyMinutes = true;
		}
	}
	
	private static List<Block> getBlocks(ProtectedRegion region) {
		ArrayList<Block> blocks = new ArrayList<Block>();
		if (region instanceof ProtectedPolygonalRegion) {
		    ProtectedPolygonalRegion polygon = (ProtectedPolygonalRegion) region;
		    List<BlockVector2D> points = polygon.getPoints();
		    
		    for (BlockVector2D point : points) {
		    	for (int y = polygon.getMinimumPoint().getBlockY(); y < polygon.getMaximumPoint().getBlockY(); y++) {
		    		World world = Bukkit.getServer().getWorld("world");
		    		blocks.add(world.getBlockAt(new Location(world, point.getBlockX(), y, point.getBlockZ()))); //TODO: Replace with name of world used on server.
		    	}
		    }
		    
		}else if (region instanceof ProtectedCuboidRegion) {
			ProtectedCuboidRegion cuboidRegion = (ProtectedCuboidRegion) region;
			BlockVector max = cuboidRegion.getMaximumPoint();
			
			int maxX = max.getBlockX();
			int maxY = max.getBlockY();
			int maxZ = max.getBlockZ();
			
			BlockVector min = cuboidRegion.getMinimumPoint();
			
			int minX = min.getBlockX();
			int minY = min.getBlockY();
			int minZ = min.getBlockZ();
			
			for (int x = minX; x < maxX; x++) {
				for (int y = minY; y < maxY; y++) {
					for (int z = minZ; z < maxZ; z++) {
						World world = Bukkit.getServer().getWorld("world");
						blocks.add(world.getBlockAt(new Location(world, x, y, z))); //TODO: Replace with name of world used on server.
					}
				}
			}
			
			
			
		}else if (region instanceof GlobalProtectedRegion) {
			SkyMines.logger.severe("A global region has been assigned for a mine. This is an error! Cancelling Thread");
			return null;
		}
		
		return blocks;
	}
}
