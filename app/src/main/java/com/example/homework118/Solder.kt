package com.example.homework118

class Solder(
    maxHP: Int = 200,
    dodgeChance: Int = 10,
    accuracy: Int = 30,
    weapon: AbstractWeapon = Weapons.pistol
) : AbstractWarrior(maxHP, dodgeChance, accuracy, weapon) {

    override fun toString(): String {
        return "Solder"
    }
}