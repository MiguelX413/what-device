package me.miguelcr.whatdevice.commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.geysermc.floodgate.api.FloodgateApi

class DeviceCommand : CommandExecutor {

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

        if (player.name == sender.name) {
            if (!sender.hasPermission("whatdevice.device")) {
                sender.sendMessage("${ChatColor.RED}You lack permission to run /device on yourself")
                return true
            }
        } else {
            if (!sender.hasPermission("whatdevice.device.others")) {
                sender.sendMessage("${ChatColor.RED}You lack permission to run /device on others")
                return true
            }
        }

        sender.sendMessage(
            "${player.displayName}'s device: ${
            FloodgateApi.getInstance().getPlayer(player.uniqueId)?.deviceOs?.name ?: "Java"
            }"
        )
        return true
    }
}
