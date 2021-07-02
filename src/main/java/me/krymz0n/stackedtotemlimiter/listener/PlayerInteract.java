package me.krymz0n.stackedtotemlimiter.listener;

import me.krymz0n.stackedtotemlimiter.Main;
import org.bukkit.Material;
import org.bukkit.block.Container;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract implements Listener {
    private final Main plugin;

    public PlayerInteract(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent evt) {
        if (plugin.getConfig().getBoolean("RevertStacks")) {
            if (evt.getClickedBlock() != null) {
                if (evt.getClickedBlock().getState() instanceof Container) {
                    for (ItemStack container : ((Container) evt.getClickedBlock().getState()).getInventory().getContents()) {
                        if (container != null) {
                            if (container.getType() == Material.TOTEM) {
                                if (container.getAmount() > 1) {
                                    container.setAmount(1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
