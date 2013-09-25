package nl.Steffion.SteffionsEngine;

import java.util.ArrayList;
import java.util.List;

import nl.Steffion.SteffionsEngine.PermissionsC.Permissions;
import nl.Steffion.SteffionsEngine.Commands.*;
import nl.Steffion.SteffionsEngine.Managers.CommandM;
import nl.Steffion.SteffionsEngine.Managers.ConfigM;
import nl.Steffion.SteffionsEngine.Managers.MessageM;
import nl.Steffion.SteffionsEngine.Managers.PermissionsM;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class SteffionsEngine extends JavaPlugin implements Listener {
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

	@SuppressWarnings("serial")
	public static List<String> SteffionsEngineCMD = new ArrayList<String>() {
		{
			add("info");
			add("help");
			add("reload");
		}
	};

	public static CommandM CMD;
	public static CommandM CMDinfo;
	public static CommandM CMDhelp;
	public static CommandM CMDreload;
	public static CommandM CMDtest1;
	public static CommandM CMDtest2;
	public static CommandM CMDtest3;
	public static CommandM CMDtest4;
	public static CommandM CMDtest5;

	public void onEnable() {
		pdfFile = getDescription();

		ConfigM.newFiles();

		CMD = new CommandM("SteffionsEngine", "SteffionsEngine", null, null,
				Permissions.info, ConfigC.help_info,
				(Boolean) W.config.get(ConfigC.commandEnabled_info),
				SteffionsEngineCMD, new CMDinfo(), null);
		CMDinfo = new CommandM("SteffionsEngine INFO", "SteffionsEngine",
				"info", "i", Permissions.info, ConfigC.help_info,
				(Boolean) W.config.get(ConfigC.commandEnabled_info),
				SteffionsEngineCMD, new CMDinfo(), "/SteffionsEngine [info|i]");
		CMDhelp = new CommandM("SteffionsEngine HELP", "SteffionsEngine",
				"help", "h", Permissions.help, ConfigC.help_help,
				(Boolean) W.config.get(ConfigC.commandEnabled_help),
				SteffionsEngineCMD, new CMDhelp(),
				"/SteffionsEngine <help|h> [page number]");
		CMDreload = new CommandM("SteffionsEngine RELOAD", "SteffionsEngine",
				"reload", "r", Permissions.reload, ConfigC.help_reload,
				(Boolean) W.config.get(ConfigC.commandEnabled_reload),
				SteffionsEngineCMD, new CMDreload(),
				"/SteffionsEngine <reload|r>");
		CMDtest1 = new CommandM("SteffionsEngine TESTING", "SteffionsEngine",
				"test1", "t1", Permissions.info, ConfigC.help_info,
				(Boolean) W.config.get(ConfigC.commandEnabled_info),
				SteffionsEngineCMD, new CMDinfo(), "/SteffionsEngine test1");
		CMDtest2 = new CommandM("SteffionsEngine TESTING", "SteffionsEngine",
				"test2", "t1", Permissions.info, ConfigC.help_info,
				(Boolean) W.config.get(ConfigC.commandEnabled_info),
				SteffionsEngineCMD, new CMDinfo(), "/SteffionsEngine test2");
		CMDtest3 = new CommandM("SteffionsEngine TESTING", "SteffionsEngine",
				"test3", "t1", Permissions.info, ConfigC.help_info,
				(Boolean) W.config.get(ConfigC.commandEnabled_info),
				SteffionsEngineCMD, new CMDinfo(), "/SteffionsEngine test3");
		CMDtest4 = new CommandM("SteffionsEngine TESTING", "SteffionsEngine",
				"test4", "t1", Permissions.info, ConfigC.help_info,
				(Boolean) W.config.get(ConfigC.commandEnabled_info),
				SteffionsEngineCMD, new CMDinfo(), "/SteffionsEngine test4");
		CMDtest5 = new CommandM("SteffionsEngine TESTING", "SteffionsEngine",
				"test45", "t1", Permissions.info, ConfigC.help_info,
				(Boolean) W.config.get(ConfigC.commandEnabled_info),
				SteffionsEngineCMD, new CMDinfo(), "/SteffionsEngine test5");

		getServer().getPluginManager().registerEvents(this, this);

		MessageM.sendFMessage(null, ConfigC.log_enabledPlugin, "name-"
				+ SteffionsEngine.pdfFile.getName(), "version-"
				+ SteffionsEngine.pdfFile.getVersion(), "autors-"
				+ SteffionsEngine.pdfFile.getAuthors().get(0));
	}

	public void onDisable() {
		MessageM.sendFMessage(null, ConfigC.log_disabledPlugin, "name-"
				+ SteffionsEngine.pdfFile.getName(), "version-"
				+ SteffionsEngine.pdfFile.getVersion(), "autors-"
				+ SteffionsEngine.pdfFile.getAuthors().get(0));
	}

	/**
	 * Args to String. Makes 1 string.
	 * 
	 * @param input
	 *            String list which should be converted to a string.
	 * @param startArg
	 *            Start on this length.
	 * 
	 * @return The converted string.
	 */
	public static String stringBuilder(String[] input, int startArg) {
		if (input.length - startArg <= 0) {
			return null;
		}
		StringBuilder sb = new StringBuilder(input[startArg]);
		for (int i = ++startArg; i < input.length; i++) {
			sb.append(' ').append(input[i]);
		}
		return sb.toString();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player player = null;
		if (sender instanceof Player) {
			player = (Player) sender;
		}

		for (CommandM command : W.commands) {
			String[] argsSplit = null;
			String[] argsSplitAlias = null;

			if (command.args != null && command.argsalias != null) {
				argsSplit = command.args.split("/");
				argsSplitAlias = command.argsalias.split("/");
			}

			if (cmd.getName().equalsIgnoreCase(command.label)) {
				boolean equals = true;

				if (argsSplit == null) {
					if (args.length == 0) {
						equals = true;
					} else {
						equals = false;
					}
				} else {
					if (args.length >= argsSplit.length) {
						for (int i2 = argsSplit.length - 1; i2 >= 0; i2 = i2 - 1) {
							int loc = argsSplit.length - i2 - 1;
							if (!argsSplit[loc].equalsIgnoreCase(args[loc])
									&& !argsSplitAlias[loc]
											.equalsIgnoreCase(args[loc])) {
								equals = false;
							}
						}
					} else {
						equals = false;
					}
				}

				if (equals) {
					if (PermissionsM.hasPerm(player, command.permission, true)) {
						if (command.enabled) {
							command.CMD.exectue(player, cmd, label, args);
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

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd,
			String label, String[] args) {

		for (CommandM command : W.commands) {
			if (cmd.getName().equalsIgnoreCase(command.label)) {
				if (args.length == 1) {
					return command.mainTABlist;
				}
			}
		}

		return null;
	}
}
