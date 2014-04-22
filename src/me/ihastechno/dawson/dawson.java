package me.ihastechno.dawson;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;


public class dawson extends JavaPlugin {
	public final Logger logger = Logger.getLogger("Minecraft");
	public static dawson plugin;
	
	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " has Been Disabled!");
	}
	
	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " has been enabled!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
		
		if(commandLabel.equalsIgnoreCase("heal")){
			if(args.length == 0){
				//heal = 0 args /heal iHasTechno = 1 args
				player.setHealth(20.0);
				player.setFireTicks(0);
				player.sendMessage(ChatColor.GREEN + "Healed!");
			}else if(args.length == 1){
				if(player.getServer().getPlayer(args[0]) != null){
				Player targetPlayer = player.getServer().getPlayer(args[0]);
				targetPlayer.setHealth(20.0);
				targetPlayer.setFireTicks(0);
				player.sendMessage(ChatColor.GREEN + "Healed!");
			}else{
				player.sendMessage(ChatColor.RED + "That player is not online!");
			}
		}
		}
			
		if(commandLabel.equalsIgnoreCase("beam")){
			if(args.length == 0){
				player.sendMessage(ChatColor.DARK_RED + "Not enough information!");
			}else if(args.length == 1){
				Player targetPlayer = player.getServer().getPlayer(args[0]);
				Location targetPlayerLocation = targetPlayer.getLocation();
				player.teleport(targetPlayerLocation);
			}else if(args.length == 2){
				Player targetPlayer = player.getServer().getPlayer(args[0]);
				Player targetPlayer1 = player.getServer().getPlayer(args[1]);
				Location targetPlayer1Location = targetPlayer1.getLocation();
				targetPlayer.teleport(targetPlayer1Location);
				targetPlayer.sendMessage("You have been teleported to " + player.getName());
				targetPlayer1.sendMessage(targetPlayer1.getName() + " has teleported to you!");
				
			}
		}
	
	
		return false;	
}
}