package me.arasple.mc.trhologram.module.command.impl

import me.arasple.mc.trhologram.module.service.Performance
import org.bukkit.Bukkit
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.command.subCommand
import taboolib.common.platform.function.submit

/**
 * @author Arasple
 * @date 2021/2/12 18:45
 */
object CommandMirror {

    val command = subCommand {
        dynamic {
            execute<ProxyCommandSender> { sender, _, _ ->
                commandMirror(sender)
            }
        }
    }

    private fun commandMirror(sender: ProxyCommandSender) {
        submit(async = !Bukkit.isPrimaryThread()) {
            Performance.collect(sender) {
                childFormat = "§8  {0}§7{1} §2[{3} ms] §7{4}%"
                parentFormat = "§8  §8{0}§7{1} §8[{3} ms] §7{4}%"
            }.run {
                sender.sendMessage("\n§2§lHologram §a§l§nPerformance Mirror\n§r")
                print(sender, getTotal(), 0)
            }
        }
    }

}