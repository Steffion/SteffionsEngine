package nl.Steffion.SteffionsEngine;

import java.util.ArrayList;

import nl.Steffion.SteffionsEngine.Managers.CommandM;
import nl.Steffion.SteffionsEngine.Managers.ConfigM;

public class W {
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

	/*
	 * Standard stuff.
	 */
	public static ArrayList<String> newFiles = new ArrayList<String>();
	public static ArrayList<CommandM> commands = new ArrayList<CommandM>();

	/*
	 * If you want another file to be created. Copy and paste this line.
	 */
	public static ConfigM config = new ConfigM("config");
	public static ConfigM messages = new ConfigM("messages");

	/*
	 * Add any variable you need in different classes here:
	 */
}