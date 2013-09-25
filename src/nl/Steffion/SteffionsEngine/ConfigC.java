package nl.Steffion.SteffionsEngine;

import nl.Steffion.SteffionsEngine.Managers.ConfigM;

public enum ConfigC {
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

	chat_tag ("[" + SteffionsEngine.pdfFile.getName() + "] ", W.config),
	chat_normal ("&b", W.config),
	chat_warning ("&c", W.config),
	chat_error ("&c", W.config),
	chat_arg ("&e", W.config),
	chat_header ("&9", W.config),
	chat_headerhigh ("%H_______.[ %A%header%%H ]._______", W.config),

	commandEnabled_info (true, W.config),
	commandEnabled_help (true, W.config),
	commandEnabled_reload (true, W.config),

	log_enabledPlugin ("%TAG%name%&a&k + %N%version% is now Enabled. Made by %A%autors%%N.",
			W.messages),
	log_disabledPlugin ("%TAG%name%&c&k - %N%version% is now Disabled. Made by %A%autors%%N.",
			W.messages),

	help_info ("%NDisplays the plugin's info.", W.messages),
	help_help ("%NShows a list of commands.", W.messages),
	help_reload ("%NReloads all configs.", W.messages),

	normal_reloadedConfigs ("%TAG&aReloaded all configs!", W.messages),

	error_noPermission ("%TAG%EYou don't have the permissions to do that!",
			W.messages),
	error_commandNotFound ("%TAG%ECouldn't find the command. Try %A/"
			+ SteffionsEngine.pdfFile.getName()
			+ " <help|h> [page number] %Efor more info.", W.messages),
	error_commandNotEnabled ("%EThis command has been disabled! Ask your administrator if you belive this is an error.",
			W.messages),
	error_notEnoughArguments ("%EYou're missing arguments, correct syntax: %A/%syntax%",
			W.messages);

	public Object value;
	public ConfigM config;
	public String location;

	/**
	 * Makes an object from the list above.
	 * 
	 * @param value
	 *            Setting in the config file.
	 * @param config
	 *            The config file.
	 */
	private ConfigC (Object value, ConfigM config) {
		this.value = value;
		this.config = config;
		this.location = this.name().replaceAll("_", ".");
	}
}
