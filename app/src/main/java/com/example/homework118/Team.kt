package com.example.homework118

import kotlin.random.Random



class Team(
    private val number: Int
) {

    val warriors: MutableList<Warrior> by lazy { createTheTeam() }

    private fun createTheTeam(): MutableList<Warrior> {
        val warriors = mutableListOf<Warrior>()
        var currentIndex = 0
        while (currentIndex < number) {
            when {
                10.toBoolean() -> warriors.add(General())
                15.toBoolean() -> warriors.add(Sniper())
                30.toBoolean() -> warriors.add(Captain())
                else -> warriors.add(Solder())
            }
            currentIndex++
        }
        return warriors
    }

    fun getHpOfTeam(): Int {
        var sumHpOfTeam = 0
        warriors.onEach {
            sumHpOfTeam += it.currentHP
//            println("$it have ${it.currentHP} HP")
        }
        return sumHpOfTeam
    }
}

//import kotlin.random.Random
//
//open class Team {
//    private fun Int.chanceRealize(): Boolean {
//        return this > Random.nextInt(101)
//    }
//
//    var team = mutableListOf<AbstractWarrior>()
//    fun makeTeam(teamSize: Int): MutableList<AbstractWarrior> {
//        var index = 0
//        while (index < teamSize){
//            when{
//                10.chanceRealize() -> team.add(General())
//                40.chanceRealize() -> team.add(Captain())
//                else -> team.add(Soilder())
//            }
//            index++
//        }
//        return team
//    }
//
//
//}
