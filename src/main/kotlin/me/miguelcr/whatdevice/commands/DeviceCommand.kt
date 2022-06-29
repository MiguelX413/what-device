package me.miguelcr.whatdevice.commands

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.geysermc.floodgate.api.FloodgateApi

class DeviceCommand(private val floodgateApi: FloodgateApi) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val player: Player = if (args.isEmpty()) {
            if (sender is Player) {
                sender
            } else {
                return false
            }
        } else {
            Bukkit.getServer().getPlayerExact(args[0])
                ?: run {
                    sender.sendMessage("Could not find player")
                    return false
                }
        }

        sender.sendMessage("${player.displayName}'s device: ${floodgateApi.getPlayer(player.uniqueId)?.deviceOs?.name ?: "Java"}")
        return true
    }
}
