package com.example.homework118

enum class Ammo(
    val damage: Int,
    val critChance: Int,
    val critRatio: Int
) {

    FIRE(40, 15, 2),
    ELECTRIC(25, 60, 3),
    WATER(30, 85, 2),
    LONGSHOT(50, 90, 4);

    fun getTheDamage(): Int {
        return if (critChance.toBoolean()) damage * critRatio else damage
    }
}

//import kotlin.random.Random
//
//enum class Ammo(val damage: Int, val criticalChance: Int, val criticalReal: Int) {
//    LIGHTBULLET(1, 15, 5),
//    MIDLEBULLET(5, 23, 7),
//    HEAVYBULLET(10, 40, 10);
//
//    fun getDamage(
//        damage: Int = this.damage,
//        criticalChance: Int = this.criticalChance,
//        criticalReal: Int = this.criticalReal
//    ): Int {
//        return if (criticalChance.chanceRealize())
//            damage * criticalReal
//        else damage
//    }
//
//    private fun Int.chanceRealize(): Boolean {
//        return this > Random.nextInt(101)
//    }
//}