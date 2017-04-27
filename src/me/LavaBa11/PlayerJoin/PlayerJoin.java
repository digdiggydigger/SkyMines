package me.LavaBa11.PlayerJoin;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.LavaBa11.SkyMines;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;

public class PlayerJoin implements Listener {

	public PlayerJoin(SkyMines plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		//Main title
		PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\"§9§n§lWelcome To SkyMines\"}"), 10, 1000, 10);
		((CraftPlayer) e.getPlayer()).getHandle().playerConnection.sendPacket(title);
		//Subtitle
		PacketPlayOutTitle subtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\":\"§7§lNew Updates!\"}"), 10, 1000, 10);
		((CraftPlayer) e.getPlayer()).getHandle().playerConnection.sendPacket(subtitle);
		
		if (player.hasPlayedBefore()) {
			player.sendMessage("                                ");
			player.sendMessage("§6§l       FORUMS: §7skymines.org/");
			player.sendMessage("§d§l       STORE: §7store.skymines.org/");
			player.sendMessage("              ");
			player.sendMessage("§7Welcome back §6" + player.getName() + "§7!");
	//		player.sendMessage("§7");
	//		player.sendMessage("§7");
	//		player.sendMessage("§7");
		if (!(player.hasPlayedBefore())) {
			player.sendMessage("                                ");
			player.sendMessage("§6§l       FORUMS: §7skymines.org/");
			player.sendMessage("§d§l       STORE: §7store.skymines.org/");
			player.sendMessage("              ");
			player.sendMessage("§7Welcome To SkyMines §6" + player.getName() + "§7!");
			
			}
		}
	}
}
