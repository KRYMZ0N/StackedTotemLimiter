package me.krymz0n.stackedtotemlimiter.listener;

import me.krymz0n.stackedtotemlimiter.Main;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class BlockDrop implements Listener {
    private final Main plugin;

    public BlockDrop(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockDrop(PlayerDropItemEvent evt) {
        if (plugin.getConfig().getBoolean("RevertStacks")) {
            if (evt.getItemDrop().getItemStack().getType() == Material.TOTEM) {
                if (evt.getItemDrop().getItemStack().getAmount() > 1) {
                    evt.getItemDrop().getItemStack().setAmount(1);
                }
            }
        }
    }
}