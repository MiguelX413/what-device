package me.miguelcr.whatdevice

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.geysermc.floodgate.api.FloodgateApi
import java.util.logging.Logger

class JoinListener(private val logger: Logger) : Listener {
    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        val deviceName = (
            FloodgateApi.getInstance()
                ?: run { logger.warning("Failed to get Floodgate API"); return }
            ).getPlayer(e.player.uniqueId)?.deviceOs?.name
        if (deviceName != null) {
            logger.info("${e.player.displayName} joined on $deviceName device")
        }
    }
}
