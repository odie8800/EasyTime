package com.github.odie8800.EasyTime;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class EasyTime extends JavaPlugin
{
	public static EasyTime plugin;
	
	@Override
	public void onEnable()
	{
		getLogger().info("Enabled.");
	}
	
	@Override
	public void onDisable()
	{
		getLogger().info("Disabled.");
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		switch(label.toLowerCase())
		{
			case "time":
				doCmdTime(sender, args);
				return false;
				
			case "t":
				doCmdTime(sender, args);
				return false;
		}
		return false;
	}

	private void doCmdTime(CommandSender sender, String[] args) 
	{
		if(sender instanceof Player)
		{
			Player psend = (Player) sender;
			World wd = psend.getWorld();
			
			if(args.length == 0)
			{
				psend.sendMessage(ChatColor.BLUE + "EasyTime> " + ChatColor.RED + "Wrong usage.");
				psend.sendMessage(ChatColor.BLUE + "EasyTime> " + ChatColor.RED + "/time [Day, Afternoon, Night]");
			} else if(args[0].equalsIgnoreCase("day"))
			{
				if(psend.hasPermission("easytime.time"))
				{
					wd.setTime(0);
					Bukkit.broadcastMessage(ChatColor.GOLD + "Time set to day (0 Ticks).");
				} else
					psend.sendMessage(ChatColor.BLUE + "EasyTime> " + ChatColor.RED + "You don't have permissions to execute this command.");
			} else if(args[0].equalsIgnoreCase("afternoon") || args[0].equalsIgnoreCase("a"))
			{
				if(psend.hasPermission("easytime.time"))
				{
					wd.setTime(5000);
					Bukkit.broadcastMessage(ChatColor.GOLD + "Time set to afternoon (5000 Ticks).");
				} else
					psend.sendMessage(ChatColor.BLUE + "EasyTime> " + ChatColor.RED + "You don't have permissions to execute this command.");
			} else if(args[0].equalsIgnoreCase("night"))
			{
				if(psend.hasPermission("easytime.time"))
				{
					wd.setTime(15000);
					Bukkit.broadcastMessage(ChatColor.GOLD + "Time set to night (15000 Ticks).");
				} else
					psend.sendMessage(ChatColor.BLUE + "EasyTime> " + ChatColor.RED + "You don't have permissions to execute this command.");
			} else
				psend.sendMessage(ChatColor.BLUE + "EasyTime> " + ChatColor.RED + "Wrong usage.");
				psend.sendMessage(ChatColor.BLUE + "EasyTime> " + ChatColor.RED + "/time [Day, Afternoon, Night]");
		} else
			sender.sendMessage(ChatColor.BLUE + "EasyTime> " + ChatColor.RED + "You must be a player to do that.");
	}
}
