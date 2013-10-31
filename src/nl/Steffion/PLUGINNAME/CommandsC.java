package nl.Steffion.PLUGINNAME;

import nl.Steffion.PLUGINNAME.PermissionsC.Permissions;
import nl.Steffion.PLUGINNAME.Commands.CMDhelp;
import nl.Steffion.PLUGINNAME.Commands.CMDinfo;
import nl.Steffion.PLUGINNAME.Commands.CMDreload;
import nl.Steffion.PLUGINNAME.Commands.DefaultCMD;

public class CommandsC {
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

	public enum Commands {
		PLUGINNAME_ (new CMDinfo(),
				PLUGINNAME.pdfFile.getName() + "%_",
				PLUGINNAME.pdfFile.getName() + "%_",
				Permissions.info,
				ConfigC.help_info,
				ConfigC.commandEnabled_info,
				null),
		PLUGINNAME_INFO (new CMDinfo(),
				PLUGINNAME.pdfFile.getName() + "%info_",
				PLUGINNAME.pdfFile.getName() + "%i_",
				Permissions.info,
				ConfigC.help_info,
				ConfigC.commandEnabled_info,
				"/" + PLUGINNAME.pdfFile.getName() + " [info|i]"),
		PLUGINNAME_HELP (new CMDhelp(),
				PLUGINNAME.pdfFile.getName() + "%help_",
				PLUGINNAME.pdfFile.getName() + "%h_",
				Permissions.help,
				ConfigC.help_help,
				ConfigC.commandEnabled_help,
				"/" + PLUGINNAME.pdfFile.getName() + " <help|h> [page number]"),
		PLUGINNAME_RELOAD (new CMDreload(),
				PLUGINNAME.pdfFile.getName() + "%reload_",
				PLUGINNAME.pdfFile.getName() + "%r_",
				Permissions.reload,
				ConfigC.help_reload,
				ConfigC.commandEnabled_reload,
				"/" + PLUGINNAME.pdfFile.getName() + " <reload|r>"),
		TEST_ (new CMDreload(),
				"test%*_",
				"test%*_",
				Permissions.reload,
				ConfigC.help_reload,
				ConfigC.commandEnabled_reload,
				"/test");

		public DefaultCMD cmd;
		public String command;
		public String commandalias;
		public Permissions permission;
		public ConfigC help;
		public ConfigC enabled;
		public String usage;

		private Commands (DefaultCMD cmd, String command, String commandalias,
				Permissions permission, ConfigC help, ConfigC enabled,
				String usage) {
			this.cmd = cmd;
			this.command = command;
			this.commandalias = commandalias;
			this.permission = permission;
			this.help = help;
			this.enabled = enabled;
			this.usage = usage;
		}
	}
}