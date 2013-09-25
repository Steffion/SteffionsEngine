package nl.Steffion.SteffionsEngine;

public class PermissionsC {
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

	public static String main = SteffionsEngine.pdfFile.getName().toLowerCase()
			+ ".";

	public enum PType {
		ALL, PLAYER, MODERATOR, ADMIN, OP;
	}

	public enum Permissions {
		info (main + "info", PType.ALL),
		help (main + "help", PType.ALL),
		reload (main + "reload", PType.MODERATOR);

		public String perm;
		public PType type;

		private Permissions (String perm, PType type) {
			this.perm = perm;
			this.type = type;
		}
	}
}