package com.pickuperic;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class CommandGetTeams implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		String message = ChatColor.GREEN + "Current teams: ";
		
		for (String team : Teams.teams.keySet()) {
			message += Teams.teams.get(team).printTeamName();
			message += ChatColor.GREEN + ", ";
		}
		
		sender.sendMessage(message);
		
		return true;
	}
	
}