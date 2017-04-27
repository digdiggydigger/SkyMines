package me.LavaBa11.BlockManip;

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

public class LuckyOrbs implements Listener {
	
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
	
	public static void onLuckyOrbCommand(CommandSender sender) {
		Player player = (Player) sender;
		
		ItemStack lOrb = new ItemStack(Material.EYE_OF_ENDER);
		ItemMeta lOrbM = lOrb.getItemMeta();
		lOrbM.setDisplayName("§c§lLucky Orb");
		lOrbM.setLore(Arrays.asList("§7Place this on a §6§nGold Block§7 to uncover,", "§7One of its many, many rare rewards!"));
		lOrb.setItemMeta(lOrbM);
		lOrb.setAmount(1);
		player.getInventory().addItem(addGlow(lOrb));
		
		
		
	}

}
