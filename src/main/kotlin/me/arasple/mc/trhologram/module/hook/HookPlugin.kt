package me.arasple.mc.trhologram.module.hook

import org.bukkit.Bukkit
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.function.console
import taboolib.module.lang.sendLang

/**
 * @author Arasple
 * @date 2021/2/12 21:12
 */
object HookPlugin {

    val TRMENU by lazy {

        val plugin = Bukkit.getPluginManager().getPlugin("TrMenu")

        plugin != null && plugin.isEnabled && plugin.description.version.startsWith("3")

    }

    @Awake(LifeCycle.ENABLE)
    fun printInfo() {
        if (TRMENU) {
            console().sendLang("Plugin-Dependency-Hooked", "TrMenu")
        }
    }

}