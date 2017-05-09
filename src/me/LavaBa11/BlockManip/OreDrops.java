package me.LavaBa11.BlockManip;

import java.util.Random;

import org.bukkit.Material;
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
		ItemStack coal = new ItemStack(Material.COAL);
		ItemStack iron = new ItemStack(Material.IRON_INGOT);
		ItemStack gold = new ItemStack(Material.GOLD_INGOT);
		ItemStack diamond = new ItemStack(Material.DIAMOND);
		ItemStack emerald = new ItemStack(Material.EMERALD);
		ItemStack redstone = new ItemStack(Material.REDSTONE);
		ItemStack lapiss = new ItemStack(lapis);

//		if (block == Material.COAL_ORE) {
//			if (!(player.hasPermission(Permissions.RankE))) {
//				e.getBlock().setType(Material.AIR);
//				ItemStack coal = new ItemStack(Material.COAL);
//				player.getInventory().addItem(coal);
//			} else {
//				int number = rand.nextInt(100) + 1;
//					if (blockBroken.getType().equals(Material.COAL_ORE)) {
//						if (number >= 50) {
//							ItemStack coal = new ItemStack(Material.COAL);
//							multiplier = 2;
//							int amount = 1 * multiplier;
//							coal.setAmount(amount);
//							player.getInventory().addItem(coal);
//			}
//		}
					
		if (block == Material.COAL_ORE) {
			int number = rand.nextInt(100) + 1;
			if (player.hasPermission(Permissions.RankE)) {
				if (number >= 50) {
					multiplier = 2;
					amount = 1 * multiplier;
					coal.setAmount(amount);
					player.getInventory().addItem(coal);
					}
				}
			if (player.hasPermission(Permissions.RankJ)) {
				if (number >= 50) {
					multiplier = 3;
					amount = 1 * multiplier;
					coal.setAmount(amount);
					player.getInventory().addItem(coal);
				}
			} 
			if (player.hasPermission(Permissions.RankO)) {
					multiplier = 3;
					amount = 1 * multiplier;
					coal.setAmount(amount);
					player.getInventory().addItem(coal);
			} 
			if (player.hasPermission(Permissions.RankT)) {
				if (number >= 75) {
					multiplier = 4;
					amount = 1 * multiplier;
					coal.setAmount(amount);
					player.getInventory().addItem(coal);
				}
			}
			if (player.hasPermission(Permissions.RankY)) {
				if (number >= 50) {
					multiplier = 4;
					amount = 1 * multiplier;
					coal.setAmount(amount);
					player.getInventory().addItem(coal);
				}
			} 
			if (player.hasPermission(Permissions.RankZ)) {
				if (number >= 75) {
					multiplier = 4;
					amount = 1 * multiplier;
					coal.setAmount(amount);
					player.getInventory().addItem(coal);
					}
				}
			}
		
					
					
		if (block == Material.IRON_ORE) {
			int number = rand.nextInt(100) + 1;
			if (player.hasPermission(Permissions.RankE)) {
				if (number >= 50) {
					multiplier = 2;
					amount = 1 * multiplier;
					iron.setAmount(amount);
					player.getInventory().addItem(iron);
					}
				}
			if (player.hasPermission(Permissions.RankJ)) {
				if (number >= 50) {
					multiplier = 3;
					amount = 1 * multiplier;
					iron.setAmount(amount);
					player.getInventory().addItem(iron);
				}
			} 
			if (player.hasPermission(Permissions.RankO)) {
					multiplier = 3;
					amount = 1 * multiplier;
					iron.setAmount(amount);
					player.getInventory().addItem(iron);
			} 
			if (player.hasPermission(Permissions.RankT)) {
				if (number >= 75) {
					multiplier = 4;
					amount = 1 * multiplier;
					iron.setAmount(amount);
					player.getInventory().addItem(iron);
				}
			}
			if (player.hasPermission(Permissions.RankY)) {
				if (number >= 25) {
					multiplier = 4;
					amount = 1 * multiplier;
					iron.setAmount(amount);
					player.getInventory().addItem(iron);
				}
			} 
			if (player.hasPermission(Permissions.RankZ)) {
					multiplier = 4;
					amount = 1 * multiplier;
					iron.setAmount(amount);
					player.getInventory().addItem(iron);
				}
			}
		
		if (block == Material.LAPIS_ORE) {
			int number = rand.nextInt(100) + 1;
			if (player.hasPermission(Permissions.RankE)) {
				if (number >= 50) {
					multiplier = 2;
					amount = 1 * multiplier;
					lapiss.setAmount(amount);
					player.getInventory().addItem(lapiss);
					}
				}
			if (player.hasPermission(Permissions.RankJ)) {
				if (number >= 50) {
					multiplier = 3;
					amount = 1 * multiplier;
					lapiss.setAmount(amount);
					player.getInventory().addItem(lapiss);
				}
			} 
			if (player.hasPermission(Permissions.RankO)) {
					multiplier = 3;
					amount = 1 * multiplier;
					lapiss.setAmount(amount);
					player.getInventory().addItem(lapiss);
			} 
			if (player.hasPermission(Permissions.RankT)) {
				if (number >= 75) {
					multiplier = 4;
					amount = 1 * multiplier;
					lapiss.setAmount(amount);
					player.getInventory().addItem(lapiss);
				}
			}
			if (player.hasPermission(Permissions.RankY)) {
				if (number >= 25) {
					multiplier = 4;
					amount = 1 * multiplier;
					lapiss.setAmount(amount);
					player.getInventory().addItem(lapiss);
				}
			} 
			if (player.hasPermission(Permissions.RankZ)) {
					multiplier = 4;
					amount = 1 * multiplier;
					lapiss.setAmount(amount);
					player.getInventory().addItem(lapiss);
				}
			}
		
		if (block == Material.GOLD_ORE) {
			int number = rand.nextInt(100) + 1;
			if (player.hasPermission(Permissions.RankE)) {
				if (number >= 50) {
					multiplier = 2;
					amount = 1 * multiplier;
					gold.setAmount(amount);
					player.getInventory().addItem(gold);
					}
				}
			if (player.hasPermission(Permissions.RankJ)) {
				if (number >= 50) {
					multiplier = 3;
					amount = 1 * multiplier;
					gold.setAmount(amount);
					player.getInventory().addItem(gold);
				}
			} 
			if (player.hasPermission(Permissions.RankO)) {
					multiplier = 3;
					amount = 1 * multiplier;
					gold.setAmount(amount);
					player.getInventory().addItem(gold);
			} 
			if (player.hasPermission(Permissions.RankT)) {
				if (number >= 75) {
					multiplier = 4;
					amount = 1 * multiplier;
					gold.setAmount(amount);
					player.getInventory().addItem(gold);
				}
			}
			if (player.hasPermission(Permissions.RankY)) {
				if (number >= 25) {
					multiplier = 4;
					amount = 1 * multiplier;
					gold.setAmount(amount);
					player.getInventory().addItem(gold);
				}
			} 
			if (player.hasPermission(Permissions.RankZ)) {
					multiplier = 4;
					amount = 1 * multiplier;
					gold.setAmount(amount);
					player.getInventory().addItem(gold);
				}
			}
		
		if (block == Material.REDSTONE_ORE) {
			int number = rand.nextInt(100) + 1;
			if (player.hasPermission(Permissions.RankE)) {
				if (number >= 50) {
					multiplier = 2;
					amount = 1 * multiplier;
					redstone.setAmount(amount);
					player.getInventory().addItem(redstone);
					}
				}
			if (player.hasPermission(Permissions.RankJ)) {
				if (number >= 50) {
					multiplier = 3;
					amount = 1 * multiplier;
					redstone.setAmount(amount);
					player.getInventory().addItem(redstone);
				}
			} 
			if (player.hasPermission(Permissions.RankO)) {
					multiplier = 3;
					amount = 1 * multiplier;
					redstone.setAmount(amount);
					player.getInventory().addItem(redstone);
			} 
			if (player.hasPermission(Permissions.RankT)) {
				if (number >= 75) {
					multiplier = 4;
					amount = 1 * multiplier;
					redstone.setAmount(amount);
					player.getInventory().addItem(redstone);
				}
			}
			if (player.hasPermission(Permissions.RankY)) {
				if (number >= 25) {
					multiplier = 4;
					amount = 1 * multiplier;
					redstone.setAmount(amount);
					player.getInventory().addItem(redstone);
				}
			} 
			if (player.hasPermission(Permissions.RankZ)) {
					multiplier = 4;
					amount = 1 * multiplier;
					redstone.setAmount(amount);
					player.getInventory().addItem(redstone);
				}
			}
		
		if (block == Material.GLOWING_REDSTONE_ORE) {
			int number = rand.nextInt(100) + 1;
			if (player.hasPermission(Permissions.RankE)) {
				if (number >= 50) {
					multiplier = 2;
					amount = 1 * multiplier;
					redstone.setAmount(amount);
					player.getInventory().addItem(redstone);
					}
				}
			if (player.hasPermission(Permissions.RankJ)) {
				if (number >= 50) {
					multiplier = 3;
					amount = 1 * multiplier;
					redstone.setAmount(amount);
					player.getInventory().addItem(redstone);
				}
			} 
			if (player.hasPermission(Permissions.RankO)) {
					multiplier = 3;
					amount = 1 * multiplier;
					redstone.setAmount(amount);
					player.getInventory().addItem(redstone);
			} 
			if (player.hasPermission(Permissions.RankT)) {
				if (number >= 75) {
					multiplier = 4;
					amount = 1 * multiplier;
					redstone.setAmount(amount);
					player.getInventory().addItem(redstone);
				}
			}
			if (player.hasPermission(Permissions.RankY)) {
				if (number >= 25) {
					multiplier = 4;
					amount = 1 * multiplier;
					redstone.setAmount(amount);
					player.getInventory().addItem(redstone);
				}
			} 
			if (player.hasPermission(Permissions.RankZ)) {
					multiplier = 4;
					amount = 1 * multiplier;
					redstone.setAmount(amount);
					player.getInventory().addItem(redstone);
				}
			}
		
		if (block == Material.DIAMOND_ORE) {
			int number = rand.nextInt(100) + 1;
			if (player.hasPermission(Permissions.RankE)) {
				if (number >= 50) {
					multiplier = 2;
					amount = 1 * multiplier;
					diamond.setAmount(amount);
					player.getInventory().addItem(diamond);
					}
				}
			if (player.hasPermission(Permissions.RankJ)) {
				if (number >= 50) {
					multiplier = 3;
					amount = 1 * multiplier;
					diamond.setAmount(amount);
					player.getInventory().addItem(diamond);
				}
			} 
			if (player.hasPermission(Permissions.RankO)) {
					multiplier = 3;
					amount = 1 * multiplier;
					diamond.setAmount(amount);
					player.getInventory().addItem(diamond);
			} 
			if (player.hasPermission(Permissions.RankT)) {
				if (number >= 75) {
					multiplier = 4;
					amount = 1 * multiplier;
					diamond.setAmount(amount);
					player.getInventory().addItem(diamond);
				}
			}
			if (player.hasPermission(Permissions.RankY)) {
				if (number >= 25) {
					multiplier = 4;
					amount = 1 * multiplier;
					diamond.setAmount(amount);
					player.getInventory().addItem(diamond);
				}
			} 
			if (player.hasPermission(Permissions.RankZ)) {
					multiplier = 4;
					amount = 1 * multiplier;
					diamond.setAmount(amount);
					player.getInventory().addItem(diamond);
				}
			}
		
		if (block == Material.EMERALD_ORE) {
			int number = rand.nextInt(100) + 1;
			if (player.hasPermission(Permissions.RankE)) {
				if (number >= 50) {
					multiplier = 2;
					amount = 1 * multiplier;
					emerald.setAmount(amount);
					player.getInventory().addItem(emerald);
					}
				}
			if (player.hasPermission(Permissions.RankJ)) {
				if (number >= 50) {
					multiplier = 3;
					amount = 1 * multiplier;
					emerald.setAmount(amount);
					player.getInventory().addItem(emerald);
				}
			} 
			if (player.hasPermission(Permissions.RankO)) {
					multiplier = 3;
					amount = 1 * multiplier;
					emerald.setAmount(amount);
					player.getInventory().addItem(emerald);
			} 
			if (player.hasPermission(Permissions.RankT)) {
				if (number >= 50) {
					multiplier = 4;
					amount = 1 * multiplier;
					emerald.setAmount(amount);
					player.getInventory().addItem(emerald);
				}
			}
			if (player.hasPermission(Permissions.RankY)) {
				if (number >= 25) {
					multiplier = 4;
					amount = 1 * multiplier;
					emerald.setAmount(amount);
					player.getInventory().addItem(emerald);
				}
			} 
			if (player.hasPermission(Permissions.RankZ)) {
					multiplier = 4;
					amount = 1 * multiplier;
					emerald.setAmount(amount);
					player.getInventory().addItem(emerald);
			}
		}
	}		
}
