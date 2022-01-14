package com.example.homework118

import kotlin.random.Random

fun Int.toBoolean(): Boolean {
    return this > Random.nextInt(101)
}