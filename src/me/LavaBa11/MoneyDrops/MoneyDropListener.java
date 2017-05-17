package me.LavaBa11.MoneyDrops;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;

import me.LavaBa11.SkyMines;

public class MoneyDropListener implements Listener {
	
	public MoneyDropListener(SkyMines plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
	}
	
	World world = Bukkit.getServer().getWorld("world");
	Location loc1 = new Location(world ,884, 63, -1166);
	Location loc2 = new Location(world, 888, 67,-1170);
	
	public List<Block> getRegionBlocks(World world, Location loc1, Location loc2) {
        List<Block> blocks = new ArrayList<Block>();
        for(double x = loc1.getX(); x <= loc2.getX(); x++) {
            for(double y = loc1.getY(); y <= loc2.getY(); y++) {
                for(double z = loc1.getZ(); z <= loc2.getZ(); z++) {
                    Location loc = new Location(world, x, y, z);
                    blocks.add(loc.getBlock());
                }
            }
        }
        return blocks;
    }

}
