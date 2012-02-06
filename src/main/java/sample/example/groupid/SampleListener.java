package sample.example.groupid;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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
}
