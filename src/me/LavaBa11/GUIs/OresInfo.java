package me.LavaBa11.GUIs;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.LavaBa11.SkyMines;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagList;

public class OresInfo implements Listener{
	
	public static String strength = "§c§nStrength Ore";
	public static String repair = "§8§nRepairing Ore";
	public static String pain = "§6§nPain Ore";
	public static String credits = "§3§nCredits Ore";
	public static String clearing = "§b§nNegative Potion Clearing Ore";
	public static String health = "§d§nHealth Orb";
	public static String oreInfo = "§a§n§lOres Information";
	public static String whiteglass = "§8[§7Psychic§cOres§8]";
	public static String blackglass = "§8[§cPsychic§7Ores§8]"; 
	
	public static String oresInv = "§c§nPsychic Ores Info";
	
	public static ItemStack bglass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
	
	public OresInfo(SkyMines plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
	}
	
	public static void createMenu(Player player) {
		Inventory inv = Bukkit.getServer().createInventory(null, 27, oresInv);
		
		ItemStack r = new ItemStack(Material.REDSTONE_ORE);
		ItemMeta rm = r.getItemMeta();
		rm.setDisplayName(strength);
		rm.setLore(Arrays.asList("§7(§6Redstone Ore§7)"));
		r.setItemMeta(rm);
		
		ItemStack i = new ItemStack(Material.IRON_ORE);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(repair);
		im.setLore(Arrays.asList("§7(§6Iron Ore§7)"));
		i.setItemMeta(im);
		
		ItemStack c = new ItemStack(Material.COAL_ORE);
		ItemMeta cm = c.getItemMeta();
		cm.setDisplayName(pain);
		cm.setLore(Arrays.asList("§7(§6Coal Ore§7)"));
		c.setItemMeta(cm);
		
		ItemStack d = new ItemStack(Material.DIAMOND_ORE);
		ItemMeta dm = d.getItemMeta();
		dm.setDisplayName(credits);
		dm.setLore(Arrays.asList("§7(§6Diamond Ore§7)"));
		d.setItemMeta(dm);
		
		ItemStack l = new ItemStack(Material.LAPIS_ORE);
		ItemMeta lm = l.getItemMeta();
		lm.setDisplayName(clearing);
		lm.setLore(Arrays.asList("§7(§6Lapis Ore§7)"));
		l.setItemMeta(lm);
		
		ItemStack e = new ItemStack(Material.EMERALD_ORE);
		ItemMeta em = e.getItemMeta();
		em.setDisplayName(health);
		em.setLore(Arrays.asList("§7(§6Emerald Ore§7)"));
		e.setItemMeta(em);
		
		ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta glassm = glass.getItemMeta();
		glassm.setDisplayName("§8[§cPsychic§7Ores§8]");
		glass.setItemMeta(glassm);
		
		ItemStack eb = new ItemStack(Material.EMERALD_BLOCK);
		ItemMeta ebm = eb.getItemMeta();
		ebm.setDisplayName(oreInfo);
		ebm.setLore(Arrays.asList("§7Each ore has a chance to give you effects!", "§7Those different blocks are all shown here!"));
		eb.setItemMeta(ebm);
		
		ItemStack blglass = new ItemStack(bglass);
		ItemMeta blglassm = blglass.getItemMeta();
		blglassm.setDisplayName("§8[§7Psychic§cOres§8]");
		blglass.setItemMeta(blglassm);

		inv.setItem(2, addGlow(r));
		inv.setItem(4, addGlow(i));
		inv.setItem(6, addGlow(c));
		inv.setItem(12, addGlow(d));
		inv.setItem(14, addGlow(l));
		inv.setItem(22, addGlow(e));
		
		inv.setItem(0, addGlow(blglass));
		inv.setItem(1, (glass));
		inv.setItem(3, (blglass));
		inv.setItem(5, (blglass));
		inv.setItem(7, (glass));
		inv.setItem(8, addGlow(blglass));
		inv.setItem(9, (glass));
		inv.setItem(10, (glass));
		inv.setItem(11, (glass));
		inv.setItem(13, (blglass));
		inv.setItem(15, (glass));
		inv.setItem(16, (glass));
		inv.setItem(17, (glass));
		inv.setItem(18, addGlow(blglass));
		inv.setItem(19, (glass));
		inv.setItem(20, (eb));
		inv.setItem(21, (blglass));
		inv.setItem(23, (blglass));
		inv.setItem(24, (eb));
		inv.setItem(25, (glass));
		inv.setItem(26, addGlow(blglass));
		
		
		
		player.openInventory(inv);
	}

	@EventHandler
	public void onPlayerClick(InventoryClickEvent e) {
//		Player player = (Player) e.getWhoClicked();
		if (e.getInventory().getName() != oresInv) {
			return;
		}
		if (e.getCurrentItem().getItemMeta() != null) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains(strength)) {
			e.setCancelled(true);
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains(repair)) {
			e.setCancelled(true);
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains(pain)) {
			e.setCancelled(true);
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains(credits)) {
				e.setCancelled(true);
				}
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains(clearing)) {
				e.setCancelled(true);
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains(health)) {
				e.setCancelled(true);
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains(oreInfo)) {
				e.setCancelled(true);
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains(whiteglass)) {
				e.setCancelled(true);
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains(blackglass)) {
				e.setCancelled(true);
			}
		}
	}
	
	public static ItemStack addGlow(ItemStack item){ 
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
	
}
