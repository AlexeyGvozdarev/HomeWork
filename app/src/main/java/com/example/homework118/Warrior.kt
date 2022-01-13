package com.example.homework118

interface Warrior {
    var isKilled: Boolean
    var dodge: Int

    fun attack(enemy: Warrior)
    fun takeDamage(damage: Int): Int
}