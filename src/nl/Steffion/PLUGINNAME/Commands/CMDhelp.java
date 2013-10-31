package nl.Steffion.PLUGINNAME.Commands;

import nl.Steffion.PLUGINNAME.CommandsC.Commands;
import nl.Steffion.PLUGINNAME.ConfigC;
import nl.Steffion.PLUGINNAME.PLUGINNAME;
import nl.Steffion.PLUGINNAME.W;
import nl.Steffion.PLUGINNAME.SteffionsEngine.Managers.MessageM;
import nl.Steffion.PLUGINNAME.SteffionsEngine.Managers.PermissionsM;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class CMDhelp extends DefaultCMD {
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

	@Override
	public boolean exectue(Player player, Command cmd, String label,
			String[] args) {
		int amountCommands = 0;
		for (Commands command : Commands.values()) {
			if (command.usage != null) {
				amountCommands = amountCommands + 1;
			}
		}

		int maxPages = Math.round(amountCommands / 3);
		if (maxPages <= 0) {
			maxPages = 1;
		}

		if (args.length == 1) {
			int page = 1;
			MessageM.sendFMessage(player, ConfigC.chat_headerhigh, "header-"
					+ PLUGINNAME.pdfFile.getName() + " %Nhelp page %A" + page
					+ "%N/%A" + maxPages);
			int i = 1;
			for (Commands command : Commands.values()) {
				if (i <= 4) {
					if (command.usage != null) {
						if (PermissionsM.hasPerm(player, command.permission,
								false)) {
							MessageM.sendMessage(
									player,
									"%A"
											+ command.usage
											+ "%N - "
											+ W.messages.getFile().get(
													command.help.location));
						} else {
							MessageM.sendMessage(
									player,
									"%W"
											+ command.usage
											+ "%N - "
											+ W.messages.getFile().get(
													command.help.location));
						}
						i = i + 1;
					}
				}
			}

			MessageM.sendFMessage(player, ConfigC.chat_headerhigh,
					"header-&oHelp Page");
		} else {
			int page = 1;
			try {
				page = Integer.valueOf(args[1]);
			} catch (NumberFormatException e) {
				page = 1;
			}

			if (maxPages < page) {
				maxPages = page;
			}

			MessageM.sendFMessage(player, ConfigC.chat_headerhigh, "header-"
					+ PLUGINNAME.pdfFile.getName() + " %Nhelp page %A" + page
					+ "%N/%A" + maxPages);

			int i = 1;
			for (Commands command : Commands.values()) {
				if (i <= (page * 4) + 4) {
					if (command.usage != null) {
						if (i >= ((page - 1) * 4) + 1
								&& i <= ((page - 1) * 4) + 4) {
							if (PermissionsM.hasPerm(player,
									command.permission, false)) {
								MessageM.sendMessage(
										player,
										"%A"
												+ command.usage
												+ "%N - "
												+ W.messages.getFile().get(
														command.help.location));
							} else {
								MessageM.sendMessage(
										player,
										"%W"
												+ command.usage
												+ "%N - "
												+ W.messages.getFile().get(
														command.help.location));
							}
						}
						i = i + 1;
					}
				}
			}

			MessageM.sendFMessage(player, ConfigC.chat_headerhigh,
					"header-&oHelp Page");
		}
		return true;
	}
}
