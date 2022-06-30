package me.miguelcr.whatdevice

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.geysermc.floodgate.api.FloodgateApi
import java.util.logging.Logger

class JoinListener(private val logger: Logger) : Listener {
    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        FloodgateApi.getInstance().getPlayer(e.player.uniqueId)?.deviceOs?.name?.let {
            logger.info("${e.player.displayName} join on $it device")
        }
    }
}
