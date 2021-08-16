package me.arasple.mc.trhologram.module.command

import me.arasple.mc.trhologram.module.command.impl.*
import taboolib.common.platform.command.CommandBody
import taboolib.common.platform.command.CommandHeader

/**
 * @author Arasple
 * @date 2021/2/11 16:46
 */
@CommandHeader(name = "trhologram", aliases = ["hologram", "trhd", "hd"], permission = "trhologram.access")
object CommandHandler {

    @CommandBody(permission = "trhologram.command.list")
    val list = CommandList.command

    @CommandBody(permission = "trhologram.command.teleport")
    val teleport = CommandTeleport.command

    @CommandBody(permission = "trhologram.command.movehere")
    val movehere = CommandMovehere.command

    @CommandBody(permission = "trhologram.command.create")
    val create = CommandCreate

    @CommandBody(permission = "trhologram.command.delete")
    val delete = CommandDelete.command

    @CommandBody(permission = "trhologram.command.reload")
    val reload = CommandReload.command

    @CommandBody(permission = "trhologram.command.mirror")
    val mirror = CommandMirror.command

}