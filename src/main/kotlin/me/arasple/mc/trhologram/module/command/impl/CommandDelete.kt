package me.arasple.mc.trhologram.module.command.impl

import me.arasple.mc.trhologram.module.display.Hologram
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.command.CommandContext
import taboolib.common.platform.command.subCommand
import taboolib.platform.util.sendLang
import java.io.File

/**
 * @author Arasple
 * @date 2021/2/12 17:41
 */
object CommandDelete {

    val command = subCommand {
        dynamic {
            suggestion<Player>(uncheck = true) { _, _ ->
                Hologram.holograms.map { it.id }
            }
            execute<Player> { sender, _, argument ->
                val args = argument.split(" ")
                commandDelete(sender, args[0])
            }
        }
    }

    private fun commandDelete(sender: Player, name: String) {
        val hologram = Hologram.findHologram { it.id.equals(name, true) }

        if (hologram == null) {
            sender.sendLang("Command-Not-Exists", name)
            return
        }
        hologram.loadedPath?.let { File(it).delete() }
        hologram.destroy()
        Hologram.holograms.remove(hologram)
        sender.sendLang("Command-Deleted", name)
    }

}