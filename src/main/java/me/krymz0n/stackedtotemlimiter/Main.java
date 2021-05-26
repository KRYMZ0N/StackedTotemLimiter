package me.krymz0n.stackedtotemlimiter;

import me.krymz0n.stackedtotemlimiter.util.Utils;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println(Utils.chat("&eEnabling STL!" + "&2v " + this.getDescription().getVersion()));

    }

    @Override
    public void onDisable() {
        System.out.println(Utils.chat("&eDisabling STL!"));
    }
}
