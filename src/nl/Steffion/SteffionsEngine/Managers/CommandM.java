package nl.Steffion.SteffionsEngine.Managers;

import nl.Steffion.PLUGINNAME.ConfigC;
import nl.Steffion.PLUGINNAME.PermissionsC.Permissions;
import nl.Steffion.PLUGINNAME.Commands.DefaultCMD;
import nl.Steffion.SteffionsEngine.EW;

public class CommandM {
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

	public String name;
	public String label;
	public String args;
	public String argsalias;
	public Permissions permission;
	public ConfigC help;
	public boolean enabled;
	public DefaultCMD CMD;
	public String usage;

	public CommandM (String name, String label, String args, String argsalias,
			Permissions permission, ConfigC help, Boolean enabled,
			DefaultCMD CMD, String usage) {
		this.name = name;
		this.label = label;
		this.args = args;
		this.argsalias = argsalias;
		this.permission = permission;
		this.help = help;
		this.enabled = enabled;
		this.CMD = CMD;
		this.usage = usage;

		EW.commands.add(this);
	}
}
