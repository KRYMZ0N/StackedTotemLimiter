package me.krymz0n.stackedtotemlimiter.listener;

import me.krymz0n.stackedtotemlimiter.Main;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryPickupItemEvent;

public class BlockPickup implements Listener {
    private final Main plugin;

    public BlockPickup(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void ItemPickup(InventoryPickupItemEvent evt) {
        if (plugin.getConfig().getBoolean("RevertStacks")) {
            if (evt.getItem().getItemStack().getType() == Material.TOTEM) {
                if (evt.getItem().getItemStack().getAmount() > 1) {
                    evt.getItem().getItemStack().setAmount(1);
                }
            }
        }
    }
}
