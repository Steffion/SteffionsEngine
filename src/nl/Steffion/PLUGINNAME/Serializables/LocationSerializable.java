package nl.Steffion.PLUGINNAME.Serializables;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;

@SerializableAs("PLUGINNAMELocation")
public class LocationSerializable extends Location implements
		ConfigurationSerializable {
	public LocationSerializable (World world, double x, double y, double z,
			float yaw, float pitch) {
		super(world, x, y, z, yaw, pitch);
	}

	public LocationSerializable (Location loc) {
		super(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(),
				loc.getPitch());
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof LocationSerializable || o instanceof Location) {
			Location loc = (Location) o;
			return loc.getWorld().getName().equals(getWorld().getName())
					&& loc.getX() == getX() && loc.getY() == getY()
					&& loc.getZ() == getZ() && loc.getYaw() == getYaw()
					&& loc.getPitch() == getPitch();
		}
		return false;
	}

	@Override
	public Map<String, Object> serialize() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("world", getWorld().getName());
		map.put("x", getX());
		map.put("y", getY());
		map.put("z", getZ());
		if (getYaw() != 0D)
			map.put("yaw", getYaw());
		if (getPitch() != 0D)
			map.put("pitch", getPitch());
		return map;
	}

	public static LocationSerializable deserialize(Map<String, Object> map) {
		World world = Bukkit.getWorld((String) M.g(map, "world", ""));
		if (world == null) {
			Bukkit.getConsoleSender().sendMessage(
					"Error deserializing LocationSerializable - world not found! ("
							+ world + ")");
			return null;
		}
		return new LocationSerializable(world, (Double) M.g(map, "x", 0D),
				(Double) M.g(map, "y", 0D), (Double) M.g(map, "z", 0D),
				((Double) M.g(map, "yaw", 0D)).floatValue(), ((Double) M.g(map,
						"pitch", 0D)).floatValue());
	}
}
