package me.LavaBa11.Items;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagList;

public class CustomItems implements Listener {
	
	public static ItemStack egg = new ItemStack(Material.MONSTER_EGG, 1, (short) 62);
	
	public static ItemStack one = new ItemStack(Material.INK_SACK, 1, (short) 4);
	
	public static ItemStack two = new ItemStack(Material.INK_SACK, 1, (short) 4);
	
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
	
	public static void eggItemCom(CommandSender sender) {
		Player player = (Player) sender;
		ItemStack item = new ItemStack(egg);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName("§e§lCredits Egg");
		itemm.setLore(Arrays.asList("§7Right-Click this egg to gain ingame store credits"));
		item.setItemMeta(itemm);
		player.getInventory().addItem(addGlow(item));
		
	}
}
