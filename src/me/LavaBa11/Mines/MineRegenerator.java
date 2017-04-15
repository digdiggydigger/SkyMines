package me.LavaBa11.Mines;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
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
	private static final double percentOfDiamond = .05;
	private static final double percentOfEmerald = .05;
	
	
	private static final double percentOfLapis = .10;
	
	@Override
	public void run() {
		for (ProtectedRegion region : MineLoader.mines) {
			List<Location> blocks = new ArrayList<Location>();
			
			if (region instanceof ProtectedPolygonalRegion) {
			    ProtectedPolygonalRegion polygon = (ProtectedPolygonalRegion) region;
			    List<BlockVector2D> points = polygon.getPoints();
			    
			    for (BlockVector2D point : points) {
			    	for (int y = polygon.getMinimumPoint().getBlockY(); y < polygon.getMaximumPoint().getBlockY(); y++) {
			    		blocks.add(new Location(Bukkit.getServer().getWorld("world"), point.getBlockX(), y, point.getBlockZ())); //TODO: Replace with name of world used on server.
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
							blocks.add(new Location(Bukkit.getServer().getWorld("world"), x, y, z)); //TODO: Replace with name of world used on server.
						}
					}
				}
				
				
				
			}else if (region instanceof GlobalProtectedRegion) {
				SkyMines.logger.severe("A global region has been assigned for a mine. This is an error! Cancelling Thread");
				cancel();
			}
		}
	}
}
