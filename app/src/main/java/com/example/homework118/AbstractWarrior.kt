package com.example.homework118

abstract class AbstractWarrior(
    maxHP: Int,
    override val dodgeChance: Int,
    val accuracy: Int,
    val weapon: AbstractWeapon,
) : Warrior {

    override val isKilled: Boolean
        get() = currentHP == 0

    override var currentHP = maxHP

    override fun attack(warrior: Warrior) {
        var summaryDamage = 0
//        if(!weapon.hasAmmo) {
//            weapon.reload()
//            return
//        } else {
        weapon.getAmmoToFire()
            .filter { accuracy > warrior.dodgeChance }
            .forEach { summaryDamage += it.getTheDamage() }
//        }
        warrior.takeDamage(summaryDamage)
    }

    override fun takeDamage(damage: Int) {
        if (currentHP - damage < 0) currentHP = 0 else currentHP -= damage
    }
}



//import kotlin.random.Random
//
//
//
//abstract class AbstractWarrior(
//    override var isKilled: Boolean,
//    var maxHp: Int,
//    override var dodge: Int,
//    private var accuracy: Int,
//    private var weapon: AbstractWeapon,
//    var hp: Int = maxHp
//
//) : Warrior {
//    override fun attack(enemy: Warrior) {
//        if (!enemy.isKilled) {
//            if (weapon.magazine.isEmpty()) {
//                println("Weapon reloaded")
//                weapon.reload()
//                //..................................
//            } else {
//                val ammoInGun = weapon.takeBullets()
//                var totalDamage = 0
//                for (each in ammoInGun) {
//                    if ((accuracy * Random.nextInt(100)) >= (enemy.dodge * Random.nextInt(100)))
//                        totalDamage += weapon.createAmmo().getDamage()
//                }
//            }
//
//        }
//    }
//
//
//        override fun takeDamage(damage: Int): Int {
//            if (this.hp <= 0) {
//                isKilled = true
//                println("Warrior is killed")
//            } else {
//                this.hp -= damage
//                println("Was hit $damage damage!")
//                println("He has ${this.hp} HP!")
//            }
//            return this.hp
//        }
//
//}
//class General(
//    isKilled: Boolean = false,
//    maxHP: Int = 300,
//    dodge: Int = 15,
//    accuracy: Int = 90,
//    weapon: AbstractWeapon = Weapons.createRiffle()
//): AbstractWarrior(isKilled,maxHP,dodge,accuracy,weapon)
//
//class Captain(
//    isKilled: Boolean = false,
//    maxHP: Int = 200,
//    dodge: Int = 10,
//    accuracy: Int = 80,
//    weapon: AbstractWeapon = Weapons.createAk47()
//): AbstractWarrior(isKilled,maxHP,dodge,accuracy,weapon)
//
//class Soilder(
//    isKilled: Boolean = false,
//    maxHP: Int = 100,
//    dodge: Int = 5,
//    accuracy: Int = 70,
//    weapon: AbstractWeapon = Weapons.createPistol()
//): AbstractWarrior(isKilled,maxHP,dodge,accuracy,weapon)

