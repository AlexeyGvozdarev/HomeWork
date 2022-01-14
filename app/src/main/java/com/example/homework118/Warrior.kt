package com.example.homework118

interface Warrior {

    val currentHP: Int

    val isKilled: Boolean

    val dodgeChance: Int

    fun attack(warrior: Warrior)

    fun takeDamage(damage: Int)
}

//interface Warrior {
//    var isKilled: Boolean
//    var dodge: Int
//
//    fun attack(enemy: Warrior)
//    fun takeDamage(damage: Int): Int
//}