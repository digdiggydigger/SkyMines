package me.LavaBa11.Mines;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.World;

import com.sk89q.worldguard.bukkit.RegionContainer;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

import me.LavaBa11.SkyMines;

public class MineLoader {

	public static ArrayList<ProtectedRegion> mines = new ArrayList<ProtectedRegion>();
	
	public MineLoader() {
		loadMines();
	}
	
	private void loadMines() {
		RegionContainer container = SkyMines.wg.getRegionContainer();
		String worldName = "world"; //TODO: Replace with name of world used on server.
		World world = Bukkit.getServer().getWorld(worldName);
		
		if (world != null) {
			RegionManager regions = container.get(world);
			if (regions != null) {
				
				if (regions.hasRegion("north") && 
				regions.hasRegion("south") &&
				regions.hasRegion("east") &&
				regions.hasRegion("west") &&
				regions.hasRegion("safezone1") &&
				regions.hasRegion("safezone2")
				) {
				
					
					//THIS ORDER IS IMPORTANT. IT IS REFERENCED IN MINEREGENERATOR
				    mines.add(regions.getRegion("north"));
				    mines.add(regions.getRegion("south"));
				    mines.add(regions.getRegion("east"));
				    mines.add(regions.getRegion("west"));
				    mines.add(regions.getRegion("safezone1"));
				    mines.add(regions.getRegion("safesone2"));  
				}else{
					SkyMines.logger.severe("Couldn't find a specified mine. Please make sure all mines are defined in WorldGuard!");
				}
			}
		}else{
			SkyMines.logger.severe("Couldn't find world: " + worldName);
		}
	}
}