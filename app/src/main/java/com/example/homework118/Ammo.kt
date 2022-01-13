package com.example.homework118

import kotlin.random.Random

enum class Ammo(val damage: Int, val criticalChance: Int, val criticalReal: Int) {
    LIGHTBULLET(1, 15, 5),
    MIDLEBULLET(5, 23, 7),
    HEAVYBULLET(10, 40, 10);

    fun getDamage(
        damage: Int = this.damage,
        criticalChance: Int = this.criticalChance,
        criticalReal: Int = this.criticalReal
    ): Int {
        return if (criticalChance.chanceRealize())
            damage * criticalReal
        else damage
    }

    private fun Int.chanceRealize(): Boolean {
        return this > Random.nextInt(100)
    }
}