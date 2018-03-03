package com.pickuperic;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CommandDeleteTeam {
	
	public static boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		
		//======================== ERROR CHECKING ===============================
		//Command format: /teams delete
		if (args.length == 1) {
			
			//If sender is console and did not enter a team name
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Console must enter a team name!");
				return true;
			} 
			
			Player player = (Player) sender;
			
			//If player did not enter a team name and also does not belong to a team
			if (Teams.getPlayerTeam(player) == null) {
				player.sendMessage(ChatColor.RED + "You are not a member of a team. Please use /teams delete <teamName>");
				return true;
			}
		}
		
		//Command format: /teams delete <teamName>
		//If player entered a team that does not exist
		if (args.length == 2 && !Teams.containsTeam(args[1])) {
			sender.sendMessage(ChatColor.RED + "Invalid team name. Please choose from: " + String.join(", ", Teams.getTeamNames()));
			return true;
		}
		//=========================================================================
		
		
		
		//SUCCESSFUL EXECUTION:
		Team deleteTeam;
		
		//Command format: /teams delete
		if (args.length == 1) {
			deleteTeam = Teams.getPlayerTeam((Player) sender);
		} 
		
		//Command format: /teams delete <teamName>
		else {	
			deleteTeam = Teams.getTeam(args[1]);
		}
		
		sender.sendMessage(ChatColor.GREEN + "Removed team " + deleteTeam.printTeamName());
		Teams.removeTeam(deleteTeam);
		
		return true;
		
		
	}

}
