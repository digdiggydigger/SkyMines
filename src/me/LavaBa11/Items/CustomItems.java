package me.LavaBa11.Items;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomItems implements Listener {
	
	public static ItemStack egg = new ItemStack(Material.MONSTER_EGG, 1, (short) 62);
	
	public static ItemStack one = new ItemStack(Material.INK_SACK, 1, (short) 4);
	
	public static ItemStack two = new ItemStack(Material.INK_SACK, 1, (short) 4);
	
	
	public static void eggItemCom(CommandSender sender) {
		Player player = (Player) sender;
		ItemStack item = new ItemStack(egg);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName("Credits Egg");
		itemm.setLore(Arrays.asList("§7Right-Click this egg to gain ingame store credits"));
		item.setItemMeta(itemm);
		player.getInventory().addItem(item);
		
	}
}
