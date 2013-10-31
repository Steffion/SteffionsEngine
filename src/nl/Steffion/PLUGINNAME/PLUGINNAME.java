package nl.Steffion.PLUGINNAME;

import nl.Steffion.PLUGINNAME.CommandsC.Commands;
import nl.Steffion.PLUGINNAME.Commands.CMDnotfound;
import nl.Steffion.PLUGINNAME.SteffionsEngine.SteffionsEngine;
import nl.Steffion.PLUGINNAME.SteffionsEngine.Managers.MessageM;
import nl.Steffion.PLUGINNAME.SteffionsEngine.Managers.PermissionsM;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class PLUGINNAME extends JavaPlugin implements Listener {
	/**
	 * Steffion's Engine - Made by Steffion.
	 * 
	 * You're allowed to use this engine for own usage, you're not allowed to
	 * republish the engine. Using this for your own plugin is allowed when a
	 * credit is placed somewhere in the plugin.
	 * 
	 * Thanks for your cooperate!
	 * 
	 * @author Steffion
	 */

	public static PluginDescriptionFile pdfFile;

	public static boolean metricsEnabled = false;

	public void onEnable() {
		pdfFile = this.getDescription();
		getServer().getPluginManager().registerEvents(this, this);
		SteffionsEngine.onEnable(this);

		MessageM.sendFMessage(null, ConfigC.log_enabledPlugin, "name-"
				+ PLUGINNAME.pdfFile.getName(),
				"version-" + PLUGINNAME.pdfFile.getVersion(), "autors-"
						+ PLUGINNAME.pdfFile.getAuthors().get(0));
	}

	public void onDisable() {
		MessageM.sendFMessage(null, ConfigC.log_disabledPlugin, "name-"
				+ PLUGINNAME.pdfFile.getName(),
				"version-" + PLUGINNAME.pdfFile.getVersion(), "autors-"
						+ PLUGINNAME.pdfFile.getAuthors().get(0));
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player player = null;
		if (sender instanceof Player) {
			player = (Player) sender;
		}

		for (Commands command : Commands.values()) {
			String[] commandArgsSplit = command.command.split("%");
			String[] argsSplit = commandArgsSplit[1].split("_");
			String[] argsSplitAlias = command.commandalias.split("%")[1]
					.split("_");

			if (cmd.getName().equalsIgnoreCase(commandArgsSplit[0])) {
				int i = 0;
				boolean equals = true;

				if (argsSplit.length == 0) {
					if (args.length == 0) {
						equals = true;
					} else {
						equals = false;
					}
				} else {
					if (!argsSplit[0].equals("*")) {
						if (args.length >= argsSplit.length) {
							for (String arg : argsSplit) {
								for (String arga : argsSplitAlias) {
									if (!arg.equalsIgnoreCase(args[i])
											&& !arga.equalsIgnoreCase(args[i])) {
										equals = false;
									}
									i = i + 1;
								}
							}
						} else {
							equals = false;
						}
					}
				}
				if (equals) {
					if (PermissionsM.hasPerm(player, command.permission, true)) {
						if ((Boolean) W.config.get(command.enabled)) {
							command.cmd.exectue(player, cmd, label, args);
						} else {
							MessageM.sendFMessage(player,
									ConfigC.error_commandNotEnabled);
						}
					}

					return true;
				}
			}
		}

		CMDnotfound.exectue(player, cmd, label, args);
		return true;
	}
}
