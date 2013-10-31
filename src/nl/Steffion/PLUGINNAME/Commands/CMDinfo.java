package nl.Steffion.PLUGINNAME.Commands;

import nl.Steffion.PLUGINNAME.ConfigC;
import nl.Steffion.PLUGINNAME.PLUGINNAME;
import nl.Steffion.PLUGINNAME.CommandsC.Commands;
import nl.Steffion.PLUGINNAME.SteffionsEngine.Managers.MessageM;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class CMDinfo extends DefaultCMD {
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
		MessageM.sendFMessage(player, ConfigC.chat_headerhigh, "header-"
				+ PLUGINNAME.pdfFile.getName());
		MessageM.sendMessage(player, "%A%name%%N made by %A%autors%%N.",
				"name-" + PLUGINNAME.pdfFile.getName(), "autors-"
						+ PLUGINNAME.pdfFile.getAuthors().get(0));
		MessageM.sendMessage(player, "%NVersion: %A%version%%N.", "version-"
				+ PLUGINNAME.pdfFile.getVersion());
		MessageM.sendMessage(player, "%NType %A%helpusage% %Nfor help.",
				"helpusage-" + Commands.PLUGINNAME_HELP.usage);
		MessageM.sendFMessage(player, ConfigC.chat_headerhigh,
				"header-&oInfo Page");
		return true;
	}
}
