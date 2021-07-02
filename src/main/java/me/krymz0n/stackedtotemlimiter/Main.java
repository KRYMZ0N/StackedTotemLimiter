package me.krymz0n.stackedtotemlimiter;

import me.krymz0n.stackedtotemlimiter.listener.*;
import me.krymz0n.stackedtotemlimiter.util.Utils;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println(Utils.chat("&eEnabling STL!" + "&2v " + this.getDescription().getVersion()));
        saveDefaultConfig();
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this, this);
        pm.registerEvents(new BlockPlace(this), this);
        pm.registerEvents(new InventoryClick(this), this);
        pm.registerEvents(new InventoryClose(this), this);
        pm.registerEvents(new InventoryOpen(this), this);
        pm.registerEvents(new Join(this), this);
        pm.registerEvents(new BlockPickup(this), this);
        pm.registerEvents(new BlockDrop(this), this);
        pm.registerEvents(new PlayerInteract(this), this);
    }

    @Override
    public void onDisable() {
        System.out.println(Utils.chat("&eDisabling STL!"));
    }
}
