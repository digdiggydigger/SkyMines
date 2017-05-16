package me.LavaBa11.MoneyDrops;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.LavaBa11.SkyMines;
import net.milkbowl.vault.economy.EconomyResponse;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

public class MoneyDropEvents implements Listener {
	
	// 
	public static int fivehundred = 500;
	public static int onethousand = 1000;
	public static int twothousand = 2000;
	public static int fivethousand = 5000;
	public static int tenthousand = 10000;
	
	public static int fifteenthousand = 10000;
	public static int twentythousand = 15000;
	public static int thirtythousand = 30000;
	public static int fourtythousand = 40000;
	public static int fiftythousand = 50000;
	public static int sixtythousand = 60000;
	public static int seventythousand = 70000;
	public static int eightythousand = 80000;
	public static int ninetythousand = 90000;
	
	public static int onehundredthousand = 100000;
	public static int twohundredthousand = 200000;
	public static int threehundredthousand = 300000;
	public static int fourhundredthousand = 400000;
	public static int fivehundredthousand = 500000;
	
	
	public MoneyDropEvents(SkyMines plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
	}
	
	@EventHandler
	public void onBankNoteClick(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		ItemStack inHand = player.getItemInHand();
		Action action = e.getAction();
		ItemStack note = new ItemStack(Material.PAPER);
		ItemMeta notem = note.getItemMeta();
		notem.setDisplayName("Paper");
		note.setItemMeta(notem);

		if (action.equals(Action.RIGHT_CLICK_AIR) || (action.equals(Action.RIGHT_CLICK_BLOCK))) {
			player.sendMessage("Debug 1");
			if (inHand != null) {
				player.sendMessage("Debug 2");
				if (inHand.getType().equals(Material.PAPER)) {
					player.sendMessage("Debug 3");
						ItemMeta im = note.getItemMeta();
						player.sendMessage("Debug 4");
						if (im.getDisplayName().equalsIgnoreCase("§b§lBank Note $500")) {
							player.sendMessage("Debug 5");
	    	            if (inHand.getAmount() > 1) {
	    	            	player.sendMessage("Debug 6");
	    	                inHand.setAmount(inHand.getAmount() - 1);
	    	                player.sendMessage("Debug 7");
	
	    	            } else {
	    	            	player.sendMessage("Debug else");
	    	                player.setItemInHand(null);
	    	            }
	    	            EconomyResponse r = SkyMines.eco.depositPlayer(player, fivehundred);
	    	            player.sendMessage("Debug 8");
	                    if(r.transactionSuccess()) {
	                    	player.sendMessage("Debug 9");
	                        player.sendMessage(String.format("§7You uncovered §c%s §7in a bank note! New Balance: §c%s", SkyMines.eco.format(r.amount), SkyMines.eco.format(r.balance)));
	                        player.sendMessage("Debug 10");
	                        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(
	    							EnumParticle.SNOWBALL,
	    							true, 								//True
	    							player.getLocation().getBlockX(),									//x coordinate
	    							player.getLocation().getBlockY(),									//y coordinate
	    							player.getLocation().getBlockZ(),									//z coordinate
	    							2,									//x offset
	    							2,									//y offset
	    							2,									//z offset
	    							1,									//particle speed
	    							1000,								//amount of particles
	    							null
	    					);
	    					
	    					((CraftPlayer) e.getPlayer()).getHandle().playerConnection.sendPacket(packet);
	                    } else {
	                        player.sendMessage(String.format("§cAn error occured: §c§n%s", r.errorMessage));
	                    }
	                    
						if (im.getDisplayName().equalsIgnoreCase("§b§lBank Note $500")) {
							player.sendMessage("Debug 5");
	    	            if (inHand.getAmount() > 1) {
	    	            	player.sendMessage("Debug 6");
	    	                inHand.setAmount(inHand.getAmount() - 1);
	    	                player.sendMessage("Debug 7");
	
	    	            } else {
	    	            	player.sendMessage("Debug else");
	    	                player.setItemInHand(null);
	    	            }
	    	            EconomyResponse a = SkyMines.eco.depositPlayer(player, fivehundred);
	    	            player.sendMessage("Debug 8");
	                    if(r.transactionSuccess()) {
	                    	player.sendMessage("Debug 9");
	                        player.sendMessage(String.format("§7You uncovered §c%s §7in a bank note! New Balance: §c%s", SkyMines.eco.format(a.amount), SkyMines.eco.format(a.balance)));
	                        player.sendMessage("Debug 10");
	                        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(
	    							EnumParticle.SNOWBALL,
	    							true, 								//True
	    							player.getLocation().getBlockX(),									//x coordinate
	    							player.getLocation().getBlockY(),									//y coordinate
	    							player.getLocation().getBlockZ(),									//z coordinate
	    							2,									//x offset
	    							2,									//y offset
	    							2,									//z offset
	    							1,									//particle speed
	    							1000,								//amount of particles
	    							null
	    					);
	    					
	    					((CraftPlayer) e.getPlayer()).getHandle().playerConnection.sendPacket(packet);
	                    } else {
	                        player.sendMessage(String.format("§cAn error occured: §c§n%s", r.errorMessage));
	                    	}
	                    }
					}	
				}
			}
		}
	}
}
