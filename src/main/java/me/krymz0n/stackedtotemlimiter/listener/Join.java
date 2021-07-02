package me.krymz0n.stackedtotemlimiter.listener;

import me.krymz0n.stackedtotemlimiter.Main;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class Join implements Listener {
    private Main plugin;

    public Join(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent evt) {
        if (plugin.getConfig().getBoolean("RevertStacks")) {
            for (ItemStack inventory : evt.getPlayer().getInventory().getContents()) {
                if (inventory != null) {
                    if (inventory.getType() == Material.TOTEM) {
                        if (inventory.getAmount() > 1) {
                            inventory.setAmount(1);
                        }
                    }
                }
            }
            if (evt.getPlayer().getInventory().getItemInOffHand().getType() == Material.TOTEM) {
                if (evt.getPlayer().getInventory().getItemInOffHand().getAmount() > 1) {
                    evt.getPlayer().getInventory().getItemInOffHand().setAmount(1);
                }
            }
        }
    }
}
