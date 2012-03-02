package sample.example.groupid;

import org.bukkit.entity.Creature;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Entity;
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
        if (entity instanceof Creature) {
            Creature creature = (Creature) entity;
            StringBuilder sb = new StringBuilder("You interacted with a ");
            sb.append(creature.getClass().getSimpleName());
            short s = creatureIdFromCreature(creature);
            if (s > 0) {
                sb.append(" it has a id of ");
                sb.append(s);
            }
        }
    }
    
    /**
     * This is an example of a helper method.
     * 
     * @param entity
     *            you wish to get the creatureType Id of.
     * @return the type id of the creature or -1 if the entity does not have a
     *         creature id
     */
    private short creatureIdFromCreature(Creature entity) {
        Class<?>[] interfaces = entity.getClass().getInterfaces();
        if (interfaces.length == 1) {
            Class<?> clazz = interfaces[0];
            CreatureType creatureType = CreatureType.fromName(clazz.getSimpleName());
            if (creatureType != null) {
                return creatureType.getTypeId();
            }
        }
        return -1;
    }
}
