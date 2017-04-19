package me.LavaBa11.BlockManip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.LavaBa11.SkyMines;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagList;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

public class LuckyOrbEvents implements Listener {
	
	ArrayList<String> itemCooldown = new ArrayList<String>(); //This is where we store players who have been put on cooldown.
	
	public SkyMines pluginVariable;
	
	int px;
	int py;
	int pz;	
	
	public LuckyOrbEvents(SkyMines plugin) {
		pluginVariable = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
	}
	Random r = new Random();
	
	public static ItemStack addGlow(ItemStack item) { 
		  net.minecraft.server.v1_8_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		  NBTTagCompound tag = null;
		  if (!nmsStack.hasTag()) {
		      tag = new NBTTagCompound();
		      nmsStack.setTag(tag);
		  }
		  if (tag == null) tag = nmsStack.getTag();
		  NBTTagList ench = new NBTTagList();
		  tag.set("ench", ench);
		  nmsStack.setTag(tag);
		  return CraftItemStack.asCraftMirror(nmsStack);
		}
	
	public static ArrayList<ItemStack> randomItems() { 
		
		ArrayList<ItemStack> items = new ArrayList<ItemStack>();
		items.add(new ItemStack (Material.LEATHER_HELMET, 2));
		items.add(new ItemStack (Material.LEATHER_CHESTPLATE, 2));
		items.add(new ItemStack (Material.LEATHER_LEGGINGS, 2));
		items.add(new ItemStack (Material.LEATHER_BOOTS, 2));
		return items;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onLuckyOrbPlace(BlockPlaceEvent e) {
		int px = e.getBlock().getX();
		int py = e.getBlock().getY();
		int pz = e.getBlock().getZ();
		int delay = 5;
		int list = LuckyOrbEvents.randomItems().size();
		Bukkit.broadcastMessage("" + list);
		// LuckyOrbEvents.randomItems().get(LuckyOrbEvents.randomItems().current().nextInt(0, LuckyOrbEvents.randomItems().size() - 1));
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
		                Bukkit.getScheduler().scheduleSyncDelayedTask(pluginVariable, new Runnable() { //The reason this is deprecated is because the naming can be confused. "A syncronous" vs "Asyncronous". It still works though
			                   
		                	@Override
		                	public void run() {
		                		block.setType(Material.AIR);
		                		
		                		int size = LuckyOrbEvents.randomItems().size();
		                		int random = new Random().nextInt(size);
		                		
		                		ItemStack picked = LuckyOrbEvents.randomItems().get(random);
		                		
		                		World world = block.getWorld();
		                		Location blockL = block.getLocation();
		                		world.dropItemNaturally(blockL, addGlow(picked));
		                		player.playSound(player.getLocation(), Sound.CREEPER_HISS, 10, 10);
		                				
		                		PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(
		    							EnumParticle.PORTAL,
		    							true, 								//True
		    							px,									//x coordinate
		    							py,									//y coordinate
		    							pz,									//z coordinate
		    							2,									//x offset
		    							2,									//y offset
		    							2,									//z offset
		    							1,									//particle speed
		    							1000,								//amount of particles
		    							null
		    					);
		    					
		    					((CraftPlayer) e.getPlayer()).getHandle().playerConnection.sendPacket(packet);
		                		
		                	}
		                }, (20L) * delay);
					} else {
						e.setCancelled(true);
					}
				} else {
					e.setCancelled(true);
				}
			} else {
				e.setCancelled(true);
			}
		}	
	}
	
	 @EventHandler
	    public void onEntityTarget(EntityTargetEvent e) {
		 	Entity ent = e.getEntity();
	        if (ent instanceof Zombie) {
	        	e.setCancelled(true);
	            Bukkit.broadcastMessage("NO");
	        } 
	        if (!(ent.getType().equals(EntityType.ZOMBIE))) {
	        	Bukkit.broadcastMessage("TYPE");
	      }
	 }
	 
//	 @EventHandler
//	 public void onZombieSpawn(EntitySpawnEvent e) {
//		 Entity ent = e.getEntity();
//		 Location entL = ent.getLocation();
//		 if (ent.getType().equals(EntityType.ZOMBIE)) {
//			 Bukkit.getWorld("world").spawnEntity(entL, EntityType.ZOMBIE);
//		 }
//	 }
	 
	 @EventHandler
	 public void entityBurn(EntityCombustEvent e) {
		 	Entity ent = e.getEntity();
	        if (ent instanceof Zombie) {
	        	e.setCancelled(true);
	        }
	 }
}
