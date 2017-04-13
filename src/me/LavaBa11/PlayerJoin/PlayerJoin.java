package me.LavaBa11.PlayerJoin;

<<<<<<< Updated upstream
public class PlayerJoin {
=======
<<<<<<< HEAD
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
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
		//Main title
		PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\"§c§lPsychic§7§lNetwork\"}"), 10, 1000, 10);
		((CraftPlayer) e.getPlayer()).getHandle().playerConnection.sendPacket(title);
		//Subtitle
		PacketPlayOutTitle subtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\":\"§7§lWelcome!\"}"), 10, 1000, 10);
		((CraftPlayer) e.getPlayer()).getHandle().playerConnection.sendPacket(subtitle);
	}
=======
public class PlayerJoin {
>>>>>>> origin/master
>>>>>>> Stashed changes
	
}
