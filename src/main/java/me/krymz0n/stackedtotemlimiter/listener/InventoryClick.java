package me.krymz0n.stackedtotemlimiter.listener;

import me.krymz0n.stackedtotemlimiter.Main;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener {
    private final Main plugin;

    public InventoryClick(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent evt) {
        if (plugin.getConfig().getBoolean("RevertStacks")) {
            for (ItemStack inventory : evt.getWhoClicked().getInventory().getContents()) {
                if (inventory != null) {
                    if (inventory.getType() == Material.TOTEM) {
                        if (inventory.getAmount() > 1) {
                            inventory.setAmount(1);
                        }
                    }
                }
            }
        }
    }
}
