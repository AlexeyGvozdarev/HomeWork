package com.example.homework118

abstract class AbstractWeapon(val magazineSize: Int, val fireType: FireType) {

    var magazine: Stack<Ammo> = Stack()
    val isEmpty: Boolean
        get() {
            return magazine.isEmpty()
        }

    abstract fun createAmmo(): Ammo

    fun reload() {
        for (i in 0..magazineSize) {
            magazine.push(createAmmo())
        }
    }

    fun takeBullets(): MutableList<Ammo> {
        val ammoForShot = mutableListOf<Ammo>()
        if (this.isEmpty) {
            for (i in 1..fireType.queueLength)
                ammoForShot.add(createAmmo())
            println("$ammoForShot in the gun!")
            for (each in ammoForShot) {
                magazine.pop()
            }
        }
        return ammoForShot
    }                                                           // в завистимости от фаер тайпа уменьшение на 1 или очередь
}

object Weapons {
    fun createPistol(): AbstractWeapon {
        return object : AbstractWeapon(8, FireType.SingleShot) {
            override fun createAmmo(): Ammo {
                return Ammo.LIGHTBULLET
            }
        }
    }

    fun createAk47(): AbstractWeapon {
        return object : AbstractWeapon(30, FireType.BurstShot(5)) {
            override fun createAmmo(): Ammo {
                return Ammo.MIDLEBULLET
            }
        }
    }

    fun createRiffle(): AbstractWeapon {
        return object : AbstractWeapon(12, FireType.SingleShot) {
            override fun createAmmo(): Ammo {
                return Ammo.HEAVYBULLET
            }
        }
    }


}