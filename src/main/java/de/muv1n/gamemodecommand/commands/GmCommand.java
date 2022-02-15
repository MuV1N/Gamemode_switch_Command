package de.muv1n.gamemodecommand.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GmCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        String NO_PERMS = "§cYou don´t have enough permissions to perform this command!";
        String NO_PLAYER = "§cYou must be an Player to perform this command!";
        String USSAGE = "§7Ussage = /gm <0,1,2,3> <player>";
        String TARGET_NO_PLAYER = "§7 dosn´t exist!";
        String CHANGED_YOUR_GAMEMODE = "§7You changed your gamemode to §6";
        String ALREADY_IN_THIS_GAMEMODE = "§7Your gamemode is already ";
            if (sender.hasPermission("gamemode.change")){
                if (sender instanceof Player p){
                    if (!(Integer.parseInt(args[0]) > 3)) {
                        if (args.length == 1) {
                            if (args[0].equalsIgnoreCase("0")) {
                                if (p.getGameMode() != GameMode.SURVIVAL) {
                                    p.sendMessage(CHANGED_YOUR_GAMEMODE + "Survival§7!");
                                    p.setGameMode(GameMode.SURVIVAL);
                                } else {
                                    p.sendMessage(ALREADY_IN_THIS_GAMEMODE + "Survival§7!");
                                }
                            } else if (args[0].equalsIgnoreCase("1")) {
                                if (p.getGameMode() != GameMode.CREATIVE) {
                                    p.sendMessage(CHANGED_YOUR_GAMEMODE + "Creative§7!");
                                    p.setGameMode(GameMode.CREATIVE);
                                } else {
                                    p.sendMessage(ALREADY_IN_THIS_GAMEMODE + "Creative§7!");
                                }
                            } else if (args[0].equalsIgnoreCase("2")) {
                                if (p.getGameMode() != GameMode.ADVENTURE) {
                                    p.sendMessage(CHANGED_YOUR_GAMEMODE + "Adventure§7!");
                                    p.setGameMode(GameMode.ADVENTURE);
                                } else {
                                    p.sendMessage(ALREADY_IN_THIS_GAMEMODE + "Adventure§7!");
                                }
                            } else if (args[0].equalsIgnoreCase("3")) {
                                if (p.getGameMode() != GameMode.SPECTATOR) {
                                    p.sendMessage(CHANGED_YOUR_GAMEMODE + "Spectator§7!");
                                    p.setGameMode(GameMode.SPECTATOR);
                                } else {
                                    p.sendMessage(ALREADY_IN_THIS_GAMEMODE + "Spectator§7!");
                                }
                            }
                        } else if (args.length == 2) {
                            String TARGET_ALREADY_IN_THIS_GAMEMODE = "§7The Player §6" + args[1] + " §7is already in the the gamemode §6";
                            String CHANGED_OTHER_GAMEMODE = "§7Yo had changed the Gamemode of the Player §6" + args[1] + " §7to the Gamemode §6";
                            Player target = Bukkit.getPlayer(args[1]);
                            if (target != null) {
                                if (args[0].equalsIgnoreCase("0")) {
                                    if (target.getGameMode() != GameMode.SURVIVAL) {
                                        target.sendMessage(CHANGED_OTHER_GAMEMODE + "Survival§7!");
                                        target.setGameMode(GameMode.SURVIVAL);
                                    } else {
                                        target.sendMessage(TARGET_ALREADY_IN_THIS_GAMEMODE + "Survival§7!");
                                    }
                                } else if (args[0].equalsIgnoreCase("1")) {
                                    if (target.getGameMode() != GameMode.CREATIVE) {
                                        target.sendMessage(CHANGED_YOUR_GAMEMODE + "Creative§7!");
                                        target.setGameMode(GameMode.CREATIVE);
                                    } else {
                                        target.sendMessage(TARGET_ALREADY_IN_THIS_GAMEMODE + "Creative§7!");
                                    }
                                } else if (args[0].equalsIgnoreCase("2")) {
                                    if (target.getGameMode() != GameMode.ADVENTURE) {
                                        target.sendMessage(TARGET_ALREADY_IN_THIS_GAMEMODE + "Adventure§7!");
                                        target.setGameMode(GameMode.ADVENTURE);
                                    } else {
                                        target.sendMessage(ALREADY_IN_THIS_GAMEMODE + "Adventure§7!");
                                    }
                                } else if (args[0].equalsIgnoreCase("3")) {
                                    if (target.getGameMode() != GameMode.SPECTATOR) {
                                        target.sendMessage(TARGET_ALREADY_IN_THIS_GAMEMODE + "Spectator§7!");
                                        target.setGameMode(GameMode.SPECTATOR);
                                    } else {
                                        target.sendMessage(ALREADY_IN_THIS_GAMEMODE + "Spectator§7!");
                                    }
                                }
                            } else {
                                sender.sendMessage("§7The Player §6" + args[1] + TARGET_NO_PLAYER);
                            }
                        } else {
                            sender.sendMessage(USSAGE);
                        }
                    }else{
                        sender.sendMessage(USSAGE);
                    }
                }else{
                    sender.sendMessage(NO_PLAYER);
                }
            }else {
                sender.sendMessage(NO_PERMS);
            }
        return true;
    }
}
