package me.LavaBa11;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

import me.LavaBa11.BlockManip.LuckyOrbEvents;
import me.LavaBa11.BlockManip.LuckyOrbs;
import me.LavaBa11.BlockManip.OreDrops;
import me.LavaBa11.Items.CustomItems;
import me.LavaBa11.Items.VirtualAnvil;
import me.LavaBa11.Messages.Help;
import me.LavaBa11.Mines.MineListener;
import me.LavaBa11.Mines.MineLoader;
import me.LavaBa11.Mines.MineRegenerator;
import me.LavaBa11.MoneyDrops.MoneyDrop;
import me.LavaBa11.MoneyDrops.MoneyDropEvents;
import me.LavaBa11.MoneyDrops.MoneyDropListener;
import me.LavaBa11.Permissions.Permissions;
import me.LavaBa11.PlayerJoin.PlayerJoin;
import me.LavaBa11.Rankup.PlayerRankup;
import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

public class SkyMines extends JavaPlugin {
	
	public static FileConfiguration config;
	File cFile;
	
	public static Economy eco = null;
	
	ArrayList<String> itemCooldown = new ArrayList<String>(); //This is where we store players who have been put on cooldown.
	
	public SkyMines pluginVariable;

	public static Logger logger;
	
	public static WorldGuardPlugin wg;
	
	public static int all;
	
	public static String prefix = "§8(§9SkyMines§8)§7";
	
	public static ItemStack lapis = new ItemStack(Material.INK_SACK, 1, (short) 4);
	
	@Override
	public void onEnable() {
		if (!setupEconomy()) {
			Bukkit.broadcastMessage("Vault not found!");
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		config = getConfig();
		cFile = new File(getDataFolder(), "config.yml");
		
		logger = getLogger();
		
		wg = getWorldGuard();
		
		if (wg == null) { //Shouldn't be null because we depend on WorldGuard in plugin.yml. But if it's removed, easier to have this here to catch errors.
			logger.severe("Couldn't find WorldGuard dependency. Disabling Plugin");
			Bukkit.getPluginManager().disablePlugin(this);
			return;
		}
		
		logger.info("SkyMines has been enabled and ready to go!");
		new MineLoader(); //Loads the mines/regions.
		
		long tenMinutes = 
				(20) * //The measurement is in Minecraft game ticks, and ticks run 20 times a second. So, we times how many seconds we want to wait by 20.
				((60) * (10)); //This determines how many seconds for 10 minutes.
		
		long threeMinutes = 
				(20) *
				((60) * (3));
		MineRegenerator mr = new MineRegenerator();
		mr.runTaskTimer(this, 0L, threeMinutes); //Regenerates the ores (Using Three Minutes For Testing Purposes)
		
//		new MineListener(this);
		new PlayerJoin(this);
		new Help(this);
		new PlayerRankup(this);
		new OreDrops(this);
		new Permissions(this);
		new LuckyOrbs(this);
// 		new LuckyOrbEvents(this);
		new VirtualAnvil(this);
		new MoneyDropEvents(this);
		new MoneyDrop(this);
		new MoneyDropListener(this);
		
		PluginManager pm = getServer().getPluginManager();
		pm.addPermission(Permissions.admin);
		pm.addPermission(Permissions.lOrb);
		pm.addPermission(Permissions.RankE);
		pm.addPermission(Permissions.RankJ);
		pm.addPermission(Permissions.RankO);
		pm.addPermission(Permissions.RankT);
		pm.addPermission(Permissions.RankY);
		pm.addPermission(Permissions.RankZ);
		pm.addPermission(Permissions.anvil);
		
	}
	}
			
	@Override
	public void onDisable() {
		logger.info("SkyMines has been disabled safely and securely");
		//Changed Odd
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("skymines") || (cmd.getName().equalsIgnoreCase("skymine")) && sender instanceof Player) {
			Player player = (Player) sender;			
			Help.helpCommand(player);
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("note500") && sender instanceof Player) {
			Player player = (Player) sender;
			ItemStack i = new ItemStack(Material.PAPER);
			ItemMeta im = i.getItemMeta();
			im.setDisplayName("§b§lBank Note");
			i.setItemMeta(im);
			player.getInventory().addItem(i);
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("website") || (cmd.getName().equalsIgnoreCase("web"))) {
			Player player = (Player) sender;
			sender.sendMessage("§7Website: §cskymines.games/");
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("forums") || (cmd.getName().equalsIgnoreCase("forum"))) {
			Player player = (Player) sender;
			sender.sendMessage("§7Forums: §cforums.skymines.games/");
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("virtualanvil") && sender instanceof Player) {
			Player player = (Player) sender;			
			if (player.hasPermission(Permissions.anvil)) {
				VirtualAnvil.anvil(player);	
			}
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("luckyorb") && sender instanceof Player) {
			Player player = (Player) sender;			
			if (player.hasPermission(Permissions.lOrb)) {
				LuckyOrbs.onLuckyOrbCommand(sender);
			}
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("creditegg") && sender instanceof Player) {
			Player player = (Player) sender;			
			if (player.hasPermission(Permissions.admin)) {
				CustomItems.eggItemCom(sender);
			}
			return true;
		}
		// TESTING INGOT SELL COMMANDS
		
		if (cmd.getName().equalsIgnoreCase("coalsell") && sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length == 0) {
				player.sendMessage("§cIncorrect Usage!");
			return true;
			}
			
			String amount = args[0];
			
			int convertedAmount = 0;
			convertedAmount = Integer.parseInt(amount);
			int stackAmount = 0;
			
			player.sendMessage("Debug 1");
			for (ItemStack is : player.getInventory().all(Material.COAL).values()) {
				player.sendMessage("Debug 2");
				stackAmount = stackAmount + is.getAmount();
				player.sendMessage("Debug 3");
			}
			if (!(stackAmount <= convertedAmount)) {
				player.sendMessage("Debug 4");
				player.sendMessage("§c§lYou Do Not Have Enough Of That Ingot To Sell!");
				player.sendMessage("Debug 5");
			} else { 
				if (player.getInventory().contains(Material.COAL)) {
					player.sendMessage("Debug 7");
					player.getInventory().remove(new ItemStack(Material.COAL, stackAmount));
					player.sendMessage("Debug 8");
					int cashAmount = stackAmount * 1;
					player.sendMessage("Debug 9");
					EconomyResponse r = SkyMines.eco.depositPlayer(player, cashAmount);
					player.sendMessage("Debug 10");
	                if(r.transactionSuccess()) {
	                    player.sendMessage(String.format("§7Sold " + ChatColor.RED + stackAmount + " §7ingots for §c%s§7! Your Balance: §c%s", SkyMines.eco.format(r.amount), SkyMines.eco.format(r.balance)));
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
						
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
	                } else {
	                    player.sendMessage(String.format("§cAn error occured: §c§n%s", r.errorMessage));
	                }
				} else {
					player.sendMessage("§c§nYou do not have enough ingots!");
				}
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("ironsell") && sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length == 0) {
				player.sendMessage("§cIncorrect Usage!");
			return true;
			}
			
			String amount = args[0];
			
			int convertedAmount = 0;
			convertedAmount = Integer.parseInt(amount);
			int stackAmount = 0;
			
			player.sendMessage("Debug 1");
			for (ItemStack is : player.getInventory().all(Material.IRON_INGOT).values()) {
				player.sendMessage("Debug 2");
				stackAmount = stackAmount + is.getAmount();
				player.sendMessage("Debug 3");
			}
			if (!(stackAmount <= convertedAmount)) {
				player.sendMessage("Debug 4");
				player.sendMessage("§c§lYou Do Not Have Enough Of That Ingot To Sell!");
				player.sendMessage("Debug 5");
			} else { 
				if (player.getInventory().contains(Material.IRON_INGOT)) {
					player.sendMessage("Debug 7");
					player.getInventory().remove(new ItemStack(Material.IRON_INGOT, stackAmount));
					player.sendMessage("Debug 8");
					int cashAmount = stackAmount * 1;
					player.sendMessage("Debug 9");
					EconomyResponse r = SkyMines.eco.depositPlayer(player, cashAmount);
					player.sendMessage("Debug 10");
	                if(r.transactionSuccess()) {
	                    player.sendMessage(String.format("§7Sold " + ChatColor.RED + stackAmount + " §7ingots for §c%s§7! Your Balance: §c%s", SkyMines.eco.format(r.amount), SkyMines.eco.format(r.balance)));
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
						
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
	                } else {
	                    player.sendMessage(String.format("§cAn error occured: §c§n%s", r.errorMessage));
	                }
				} else {
					player.sendMessage("§c§nYou do not have enough ingots!");
				}
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("goldsell") && sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length == 0) {
				player.sendMessage("§cIncorrect Usage!");
			return true;
			}
			
			String amount = args[0];
			
			int convertedAmount = 0;
			convertedAmount = Integer.parseInt(amount);
			int stackAmount = 0;
			
			player.sendMessage("Debug 1");
			for (ItemStack is : player.getInventory().all(Material.GOLD_INGOT).values()) {
				player.sendMessage("Debug 2");
				stackAmount = stackAmount + is.getAmount();
				player.sendMessage("Debug 3");
			}
			if (!(stackAmount <= convertedAmount)) {
				player.sendMessage("Debug 4");
				player.sendMessage("§c§lYou Do Not Have Enough Of That Ingot To Sell!");
				player.sendMessage("Debug 5");
			} else { 
				if (player.getInventory().contains(Material.GOLD_INGOT)) {
					player.sendMessage("Debug 7");
					player.getInventory().remove(new ItemStack(Material.GOLD_INGOT, stackAmount));
					player.sendMessage("Debug 8");
					int cashAmount = stackAmount * 1;
					player.sendMessage("Debug 9");
					EconomyResponse r = SkyMines.eco.depositPlayer(player, cashAmount);
					player.sendMessage("Debug 10");
	                if(r.transactionSuccess()) {
	                    player.sendMessage(String.format("§7Sold " + ChatColor.RED + stackAmount + " §7ingots for §c%s§7! Your Balance: §c%s", SkyMines.eco.format(r.amount), SkyMines.eco.format(r.balance)));
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
						
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
	                } else {
	                    player.sendMessage(String.format("§cAn error occured: §c§n%s", r.errorMessage));
	                }
				} else {
					player.sendMessage("§c§nYou do not have enough ingots!");
				}
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("diamondsell") && sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length == 0) {
				player.sendMessage("§cIncorrect Usage!");
			return true;
			}
			
			String amount = args[0];
			
			int convertedAmount = 0;
			convertedAmount = Integer.parseInt(amount);
			int stackAmount = 0;
			
			player.sendMessage("Debug 1");
			for (ItemStack is : player.getInventory().all(Material.DIAMOND).values()) {
				player.sendMessage("Debug 2");
				stackAmount = stackAmount + is.getAmount();
				player.sendMessage("Debug 3");
			}
			if (!(stackAmount <= convertedAmount)) {
				player.sendMessage("Debug 4");
				player.sendMessage("§c§lYou Do Not Have Enough Of That Ingot To Sell!");
				player.sendMessage("Debug 5");
			} else { 
				if (player.getInventory().contains(Material.DIAMOND)) {
					player.sendMessage("Debug 7");
					player.getInventory().remove(new ItemStack(Material.DIAMOND, stackAmount));
					player.sendMessage("Debug 8");
					int cashAmount = stackAmount * 1;
					player.sendMessage("Debug 9");
					EconomyResponse r = SkyMines.eco.depositPlayer(player, cashAmount);
					player.sendMessage("Debug 10");
	                if(r.transactionSuccess()) {
	                    player.sendMessage(String.format("§7Sold " + ChatColor.RED + stackAmount + " §7ingots for §c%s§7! Your Balance: §c%s", SkyMines.eco.format(r.amount), SkyMines.eco.format(r.balance)));
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
						
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
	                } else {
	                    player.sendMessage(String.format("§cAn error occured: §c§n%s", r.errorMessage));
	                }
				} else {
					player.sendMessage("§c§nYou do not have enough ingots!");
				}
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("emeraldsell") && sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length == 0) {
				player.sendMessage("§cIncorrect Usage!");
			return true;
			}
			
			String amount = args[0];
			
			int convertedAmount = 0;
			convertedAmount = Integer.parseInt(amount);
			int stackAmount = 0;
			
			player.sendMessage("Debug 1");
			for (ItemStack is : player.getInventory().all(Material.EMERALD).values()) {
				player.sendMessage("Debug 2");
				stackAmount = stackAmount + is.getAmount();
				player.sendMessage("Debug 3");
			}
			if (stackAmount <= convertedAmount) {
				player.sendMessage("Debug 4");
				player.sendMessage("§c§lYou Do Not Have Enough Of That Ingot To Sell!");
				player.sendMessage("Debug 5");
			} else { 
				if (player.getInventory().contains(Material.EMERALD)) {
					player.sendMessage("Debug 7");
					player.getInventory().remove(new ItemStack(Material.EMERALD, stackAmount));
					player.sendMessage("Debug 8");
					int cashAmount = stackAmount * 1;
					player.sendMessage("Debug 9");
					EconomyResponse r = SkyMines.eco.depositPlayer(player, cashAmount);
					player.sendMessage("Debug 10");
	                if(r.transactionSuccess()) {
	                    player.sendMessage(String.format("§7Sold " + ChatColor.RED + stackAmount + " §7ingots for §c%s§7! Your Balance: §c%s", SkyMines.eco.format(r.amount), SkyMines.eco.format(r.balance)));
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
						
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
	                } else {
	                    player.sendMessage(String.format("§cAn error occured: §c§n%s", r.errorMessage));
	                }
				} else {
					player.sendMessage("§c§nYou do not have enough ingots!");
				}
			}
		}
		// TESTING INGOT SELL COMMANDS
		return false;
		
	}
	
	private WorldGuardPlugin getWorldGuard() {
	    Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");

	    // WorldGuard may not be loaded
	    if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
	        return null; // Maybe you want throw an exception instead
	    }

	    return (WorldGuardPlugin) plugin;
	}
	
    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = Bukkit.getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            eco = economyProvider.getProvider();
        }

        return false;
    }
	
	public static FileConfiguration getConfigFile() {
	    return config;
	}
}