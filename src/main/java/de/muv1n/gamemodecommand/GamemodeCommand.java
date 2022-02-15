package de.muv1n.gamemodecommand;

import de.muv1n.gamemodecommand.commands.GmCommand;
import de.muv1n.gamemodecommand.commands.tabcompleter.GmCommandTabComplete;
import org.apache.logging.log4j.Logger;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class GamemodeCommand extends JavaPlugin {

    public Logger LOGGER = this.getLog4JLogger();

    @Override
    public void onEnable() {
        LOGGER.info("§4Thank you for using the §5Gamemode Command Plugin!");
        LOGGER.info("§2The Server had been started successfully with the Gamemode Command!");
        LOGGER.info("§2If you started the server the first Time with this Plugin please be sure that you have Operator or the Permission 'gamemode.change'!");
        Objects.requireNonNull(getCommand("gm")).setExecutor(new GmCommand());
        Objects.requireNonNull(getCommand("gm")).setTabCompleter(new GmCommandTabComplete());
    }

    @Override
    public void onDisable() {

    }
}
