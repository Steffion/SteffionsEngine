package nl.Steffion.SteffionsEngine;

import nl.Steffion.PLUGINNAME.ConfigC;
import nl.Steffion.PLUGINNAME.PLUGINNAME;
import nl.Steffion.SteffionsEngine.MCStats.Metrics;
import nl.Steffion.SteffionsEngine.Managers.ConfigM;
import nl.Steffion.SteffionsEngine.Managers.MessageM;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class SteffionsEngine {
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

	public static String engineVersion = "4.0.0";
	public static String engineAuthors = "Steffion";

	public static void onEnable(Plugin plugin) {
		ConfigM.newFiles();

		if (PLUGINNAME.metricsEnabled) {
			try {
				Metrics metrics = new Metrics(plugin);
				metrics.start();
				FileConfiguration metrics_fc = new YamlConfiguration();
				metrics_fc.load(metrics.getConfigFile());
				if (!metrics_fc.getBoolean("opt-out", false)) {
					MessageM.sendMessage(null,
							"%TAG%NSending %AMCStats %Nto their server.");
				} else {
					MessageM.sendMessage(null,
							"%TAG%EUnable to send %AMCStats %Eto their server. %AMCStats%E is disabled?");
				}
			} catch (Exception e) {
				MessageM.sendMessage(null,
						"%TAG%EUnable to send %AMCStats %Eto their server. Something went wrong ;(!");
			}
		}

		MessageM.sendFMessage(null, ConfigC.log_loadingPlugin, "pluginname-"
				+ PLUGINNAME.pdfFile.getName(), "name-SteffionsEngine",
				"version-" + engineVersion, "authors-" + engineAuthors);
	}
}
