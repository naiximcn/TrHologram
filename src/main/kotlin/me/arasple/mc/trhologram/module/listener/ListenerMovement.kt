package me.arasple.mc.trhologram.module.listener

import me.arasple.mc.trhologram.module.display.Hologram
import me.arasple.mc.trhologram.util.Cooldown
import org.bukkit.event.player.PlayerMoveEvent
import taboolib.common.platform.event.SubscribeEvent

/**
 * @author Arasple
 * @date 2021/2/11 9:58
 */
object ListenerMovement {

    val cd = Cooldown("TrHologram:MoveCheck", 1)

    @SubscribeEvent
    fun onMove(e: PlayerMoveEvent) {
        val player = e.player

        if (!cd.isCooldown(player.name)) {
            Hologram.refreshAll(player)
        }
    }

}