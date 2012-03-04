package com.example.groupid;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

/*
 * This is a sample event listener
 */
public class SampleListener implements Listener {
    private final SamplePlugin plugin;

    /*
     * This listener needs to know about the plugin which it came from
     */
    public SampleListener(SamplePlugin plugin) {
        this.plugin = plugin;
    }

    /*
     * Send the sample message to all players that join
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(this.plugin.getConfig().getString("sample.message"));
    }
    
    /*
     * Another example of a event handler. This one will give you the name of
     * the entity you interact with, if it is a Creature it will give you the
     * creature Id.
     */
    @EventHandler
    public void onPlayerInteract(PlayerInteractEntityEvent event) {
        final Entity entity = event.getRightClicked();
        final EntityType entityType = entity.getType();

        StringBuilder sb = new StringBuilder("You interacted with a ");
        sb.append(entityType.getName());
        sb.append(" it has an id of ");
        sb.append(entityType.getTypeId());

        event.getPlayer().sendMessage(sb.toString());
    }
}
