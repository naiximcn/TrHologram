package me.arasple.mc.trhologram.util

import org.bukkit.inventory.EquipmentSlot
import taboolib.module.nms.MinecraftVersion
import java.util.*

/**
 * 装备类型转换工具
 *
 * @Author 坏黑
 * @Since 2019-04-25 22:01
 */
enum class Equipments(val bukkit: EquipmentSlot, val nms: String, val slot: Int) {

    /**
     * 主手
     */
    HAND(EquipmentSlot.HAND, "mainhand", -1),

    /**
     * 副手
     */
    OFF_HAND(EquipmentSlot.OFF_HAND, "offhand", 40),

    /**
     * 脚
     */
    FEET(EquipmentSlot.FEET, "feet", 36),

    /**
     * 腿
     */
    LEGS(EquipmentSlot.LEGS, "legs", 37),

    /**
     * 胸
     */
    CHEST(EquipmentSlot.CHEST, "chest", 38),

    /**
     * 头
     */
    HEAD(EquipmentSlot.HEAD, "head", 39);

    private val supported: Boolean = MinecraftVersion.majorLegacy >= 10900


    companion object {

        /**
         * 通过 bukkit 物品类型名称获取 [Equipments]
         */
        fun fromBukkit(bukkit: EquipmentSlot): Equipments? {
            return Arrays.stream(values()).filter { tEquipment: Equipments -> tEquipment.bukkit == bukkit }
                .findFirst().orElse(null)
        }

    }

}