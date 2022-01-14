package com.example.homework118

class Captain(
    maxHP: Int = 500,
    dodgeChance: Int = 30,
    accuracy: Int = 50,
    weapon: AbstractWeapon = Weapons.shotgun
) : AbstractWarrior(maxHP, dodgeChance, accuracy, weapon) {

    override fun toString(): String {
        return "Captain"
    }
}