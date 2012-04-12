package com.example.groupid;

import org.bukkit.plugin.java.JavaPlugin;

/*
 * This is the main class of the sample plug-in
 */
public class SamplePlugin extends JavaPlugin {
    /*
     * This is called when your plug-in is enabled
     */
    @Override
    public void onEnable() {
        // Register the listener
        this.getServer().getPluginManager().registerEvents(new SampleListener(this), this);
        // set the command executor for sample
        this.getCommand("sample").setExecutor(new SampleCommandExecutor(this));
    }
    
    /*
     * This is called when your plug-in shuts down
     */
    @Override
    public void onDisable() {        
        // save the configuration file, if there are no values, write the defaults.
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
    }

}
