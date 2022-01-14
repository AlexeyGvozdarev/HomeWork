package com.example.homework118

class NoAmmoException(override val message: String = "Magazine not have a ammo") : RuntimeException()