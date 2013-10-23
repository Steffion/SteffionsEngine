package nl.Steffion.PLUGINNAME.Commands;

import nl.Steffion.PLUGINNAME.ConfigC;
import nl.Steffion.PLUGINNAME.W;
import nl.Steffion.SteffionsEngine.Managers.ConfigM;
import nl.Steffion.SteffionsEngine.Managers.MessageM;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class CMDreload extends DefaultCMD {
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
		ConfigM.newFiles();
		W.config.load();
		W.messages.load();
		MessageM.sendFMessage(player, ConfigC.normal_reloadedConfigs);
		return true;
	}
}
