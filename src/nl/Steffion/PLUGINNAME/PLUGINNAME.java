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

		// CMD = new CommandM("PLUGINNAME", "PLUGINNAME", null, null,
		// Permissions.info, ConfigC.help_info,
		// (Boolean) W.config.get(ConfigC.commandEnabled_info),
		// new CMDinfo(), null);
		// CMDinfo = new CommandM("PLUGINNAME INFO", "PLUGINNAME", "info", "i",
		// Permissions.info, ConfigC.help_info,
		// (Boolean) W.config.get(ConfigC.commandEnabled_info),
		// new CMDinfo(), "/PLUGINNAME [info|i]");
		// CMDhelp = new CommandM("PLUGINNAME HELP", "PLUGINNAME", "help", "h",
		// Permissions.help, ConfigC.help_help,
		// (Boolean) W.config.get(ConfigC.commandEnabled_help),
		// new CMDhelp(), "/PLUGINNAME <help|h> [page number]");
		// CMDreload = new CommandM("PLUGINNAME RELOAD", "PLUGINNAME", "reload",
		// "r", Permissions.reload, ConfigC.help_reload,
		// (Boolean) W.config.get(ConfigC.commandEnabled_reload),
		// new CMDreload(), "/PLUGINNAME <reload|r>");
		// CMDtest1 = new CommandM("PLUGINNAME TESTING", "PLUGINNAME", "test1",
		// "t1", Permissions.info, ConfigC.help_info,
		// (Boolean) W.config.get(ConfigC.commandEnabled_info),
		// new CMDinfo(), "/PLUGINNAME test1");
		// CMDtest2 = new CommandM("PLUGINNAME TESTING", "PLUGINNAME", "test2",
		// "t2", Permissions.info, ConfigC.help_info,
		// (Boolean) W.config.get(ConfigC.commandEnabled_info),
		// new CMDinfo(), "/PLUGINNAME test2");
		// CMDtest3 = new CommandM("PLUGINNAME TESTING", "PLUGINNAME", "test3",
		// "t3", Permissions.info, ConfigC.help_info,
		// (Boolean) W.config.get(ConfigC.commandEnabled_info),
		// new CMDinfo(), "/PLUGINNAME test3");
		// CMDtest4 = new CommandM("PLUGINNAME TESTING", "PLUGINNAME", "test4",
		// "t4", Permissions.info, ConfigC.help_info,
		// (Boolean) W.config.get(ConfigC.commandEnabled_info),
		// new CMDinfo(), "/PLUGINNAME test4");
		// CMDtest5 = new CommandM("PLUGINNAME TESTING", "PLUGINNAME", "test5",
		// "t5", Permissions.info, ConfigC.help_info,
		// (Boolean) W.config.get(ConfigC.commandEnabled_info),
		// new CMDinfo(), "/PLUGINNAME test5");

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
	
	// @Override
	// public boolean onCommand(CommandSender sender, Command cmd, String label,
	// String[] args) {
	// Player player = null;
	// if (sender instanceof Player) {
	// player = (Player) sender;
	// }
	//
	// for (CommandM command : EW.commands) {
	// String[] argsSplit = null;
	// String[] argsSplitAlias = null;
	//
	// if (command.args != null && command.argsalias != null) {
	// argsSplit = command.args.split("/");
	// argsSplitAlias = command.argsalias.split("/");
	// }
	//
	// if (cmd.getName().equalsIgnoreCase(command.label)) {
	// boolean equals = true;
	//
	// if (argsSplit == null) {
	// if (args.length == 0) {
	// equals = true;
	// } else {
	// equals = false;
	// }
	// } else {
	// if (args.length >= argsSplit.length) {
	// for (int i2 = argsSplit.length - 1; i2 >= 0; i2 = i2 - 1) {
	// int loc = argsSplit.length - i2 - 1;
	// if (!argsSplit[loc].equalsIgnoreCase(args[loc])
	// && !argsSplitAlias[loc]
	// .equalsIgnoreCase(args[loc])) {
	// equals = false;
	// }
	// }
	// } else {
	// equals = false;
	// }
	// }
	//
	// if (equals) {
	// if (PermissionsM.hasPerm(player, command.permission, true)) {
	// if (command.enabled) {
	// command.CMD.exectue(player, cmd, label, args);
	// } else {
	// MessageM.sendFMessage(player,
	// ConfigC.error_commandNotEnabled);
	// }
	// }
	//
	// return true;
	// }
	// }
	// }
	//
	// CMDnotfound.exectue(player, cmd, label, args);
	// return true;
	// }
}
