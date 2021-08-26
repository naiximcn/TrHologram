package me.arasple.mc.trhologram.module.service

import org.bukkit.event.player.PlayerJoinEvent
import taboolib.common.platform.event.EventPriority
import taboolib.common.platform.event.SubscribeEvent
import taboolib.common.platform.function.console
import taboolib.common.platform.function.pluginVersion
import taboolib.common.platform.function.submit
import taboolib.module.lang.sendLang
import taboolib.platform.util.sendLang
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets

/**
 * @author Arasple
 * @date 2020/7/28 18:30
 */
object Updater {

    private val url = URL("https://github.com/Micalhl/TrHologram/raw/master/Version.txt")

    fun init() {
        submit(delay = 20, period = (10 * 60 * 20), async = true) {
            grabInfo()
        }
    }

    private fun grabInfo() {
        val latest = getLatestVersion()
        if (latest != null && latest != pluginVersion) {
            console().sendLang("Plugin-Update", latest)
        }
    }

    private fun getLatestVersion(): String? {
        var connection: HttpURLConnection? = null
        try {
            connection = url.openConnection() as HttpURLConnection
            connection.connectTimeout = 5000
            val buffer = StringBuilder(255)
            BufferedReader(InputStreamReader(connection.inputStream, StandardCharsets.UTF_8)).use { reader ->
                val buffer0 = CharArray(255)
                while (true) {
                    val length = reader.read(buffer0)
                    if (length == -1) break
                    buffer.append(buffer0, 0, length)
                }
            }
            return buffer.toString().trim()
        } catch (ignored: Throwable) {
        } finally {
            connection?.disconnect()
        }
        return null
    }

    @SubscribeEvent(EventPriority.HIGHEST)
    fun e(e: PlayerJoinEvent) {
        val latest = getLatestVersion()
        if (latest != null && latest != pluginVersion && e.player.isOp) {
            e.player.sendLang("Plugin-Update", latest)
        }
    }

}