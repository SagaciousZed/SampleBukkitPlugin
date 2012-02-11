SampleBukkitPlugin
======

This is a sample plug-in for the Bukkit API. It requires a CraftBukkit server.
Bukkit can be found at [http://bukkit.org](http://bukkit.org) 

The goal of this sample plug-in is to provide a base for other plug-ins.

<p>
This plug-in provides the ability for a login message to be sent to players
connecting. A player with the "sample.message" permissions can set the message.
Ops by default have this permission.
</p>

<p>
Originally this plugin was to serve as the basis of a Maven 3 Archetype for
quickly building Bukkit plug-ins.
</p>

Compilation
-----------

This plugin has a Maven 3 pom. Dependencies are therefore managed by Maven.
You should be able to build it with Maven by running

    mvn package

a jar will be generated in the target folder.

