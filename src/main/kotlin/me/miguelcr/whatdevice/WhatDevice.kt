package me.miguelcr.whatdevice

import me.miguelcr.whatdevice.commands.DeviceCommand
import org.bukkit.plugin.java.JavaPlugin
import org.geysermc.floodgate.api.FloodgateApi

class WhatDevice : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
        val floodgateApi = FloodgateApi.getInstance()
        getCommand("device")?.setExecutor(DeviceCommand(floodgateApi))
        server.pluginManager.registerEvents(JoinListener(logger, floodgateApi), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
