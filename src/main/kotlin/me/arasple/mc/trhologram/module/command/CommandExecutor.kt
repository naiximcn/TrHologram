package me.arasple.mc.trhologram.module.command

import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.command.SimpleCommandBody
import taboolib.module.chat.colored
import taboolib.module.lang.asLangText

interface CommandExecutor {

    val command: SimpleCommandBody

    fun description(sender: ProxyCommandSender): String =
        sender.asLangText("COMMAND-${name.toUpperCase()}-DESCRIPTION").colored()

    val name: String

}