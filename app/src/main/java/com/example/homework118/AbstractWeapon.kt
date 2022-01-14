package com.example.homework118

abstract class AbstractWeapon(
    val sizeOfMagazine: Int,
    val fireType: FireType
) {

    var currentAmmo: MutableList<Ammo> = mutableListOf()

    val hasAmmo: Boolean
        get() = currentAmmo.isNotEmpty()

    abstract fun createTheAmmo(): Ammo

    fun reload() {
        val tempAmmo = MutableList(sizeOfMagazine) { createTheAmmo() }
        currentAmmo = tempAmmo
    }

    fun getAmmoToFire(): List<Ammo> {
        return mutableListOf<Ammo>().apply {
            while (size < fireType.numbersOfAmmo /*&& hasAmmo*/) {
                try {
                    if (!hasAmmo) throw NoAmmoException()
                    add(currentAmmo.removeFirst())
                } catch (t: NoAmmoException) {
//                    println(t.message)
//                    println("Reloading weapon")
                    reload()
                }
            }
        }
    }
}

object Weapons {

    private fun Ammo.createPistol(): AbstractWeapon {
        return object : AbstractWeapon(7, FireType.Single) {
            override fun createTheAmmo(): Ammo = this@createPistol
        }
    }

    private fun Ammo.createShotgun(): AbstractWeapon {
        return object : AbstractWeapon(2, FireType.Burst(2)) {
            override fun createTheAmmo(): Ammo = this@createShotgun
        }
    }

    private fun Ammo.createSniperRifle(): AbstractWeapon {
        return object : AbstractWeapon(5, FireType.Single) {
            override fun createTheAmmo(): Ammo = this@createSniperRifle
        }
    }

    private fun Ammo.createAutomaticWeapon(): AbstractWeapon {
        return object : AbstractWeapon(30, FireType.Burst(30)) {
            override fun createTheAmmo(): Ammo = this@createAutomaticWeapon
        }
    }

    val pistol: AbstractWeapon = Ammo.WATER.createPistol()
    val shotgun: AbstractWeapon = Ammo.FIRE.createShotgun()
    val sniperRifle: AbstractWeapon = Ammo.LONGSHOT.createSniperRifle()
    val automaticWeapon: AbstractWeapon = Ammo.ELECTRIC.createAutomaticWeapon()
}

//abstract class AbstractWeapon(val magazineSize: Int, val fireType: FireType) {
//
//    var magazine: Stack<Ammo> = Stack()
//    val isEmpty: Boolean
//        get() {
//            return magazine.isEmpty()
//        }
//
//    abstract fun createAmmo(): Ammo
//
//    fun reload() {
//        for (i in 0..magazineSize) {
//            magazine.push(createAmmo())
//        }
//    }
//
//    fun takeBullets(): MutableList<Ammo> {
//        val ammoForShot = mutableListOf<Ammo>()
//        if (this.isEmpty) {
//            for (i in 1..fireType.queueLength)
//                ammoForShot.add(createAmmo())
//            println("$ammoForShot in the gun!")
//            for (each in ammoForShot) {
//                magazine.pop()
//            }
//        }
//        return ammoForShot
//    }                                                           // в завистимости от фаер тайпа уменьшение на 1 или очередь
//}
//
//object Weapons {
//    fun createPistol(): AbstractWeapon {
//        return object : AbstractWeapon(8, FireType.SingleShot) {
//            override fun createAmmo(): Ammo {
//                return Ammo.LIGHTBULLET
//            }
//        }
//    }
//
//    fun createAk47(): AbstractWeapon {
//        return object : AbstractWeapon(30, FireType.BurstShot(5)) {
//            override fun createAmmo(): Ammo {
//                return Ammo.MIDLEBULLET
//            }
//        }
//    }
//
//    fun createRiffle(): AbstractWeapon {
//        return object : AbstractWeapon(12, FireType.SingleShot) {
//            override fun createAmmo(): Ammo {
//                return Ammo.HEAVYBULLET
//            }
//        }
//    }
//
//
//}