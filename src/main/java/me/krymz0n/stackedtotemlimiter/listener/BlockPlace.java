package me.krymz0n.stackedtotemlimiter.listener;

import me.krymz0n.stackedtotemlimiter.Main;
import org.bukkit.Material;
import org.bukkit.block.Container;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class BlockPlace implements Listener {
    private final Main plugin;

    public BlockPlace(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent evt) {
        if (plugin.getConfig().getBoolean("RevertStacks")) {
            if (evt.getBlock() instanceof Container) {
                for (ItemStack container : ((Container) evt.getBlock()).getInventory().getContents()) {
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
