package me.miguelcr.whatdevice

import me.miguelcr.whatdevice.commands.DeviceCommand
import org.bukkit.plugin.java.JavaPlugin
import org.geysermc.floodgate.api.FloodgateApi

class WhatDevice : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
        val floodgateApi = FloodgateApi.getInstance()
        getCommand("device")?.setExecutor(DeviceCommand(floodgateApi))
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
