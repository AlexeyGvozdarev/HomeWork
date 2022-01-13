package com.example.homework118

sealed class FireType(val queueLength: Int){
    object SingleShot: FireType(1)
    data class BurstShot(val burstSize: Int): FireType(burstSize)
}
