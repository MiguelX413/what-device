package me.miguelcr.whatdevice

import me.miguelcr.whatdevice.commands.DeviceCommand
import org.bukkit.plugin.java.JavaPlugin

class WhatDevice : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
        getCommand("device")?.setExecutor(DeviceCommand(logger))
        server.pluginManager.registerEvents(JoinListener(logger), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
