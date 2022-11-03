package com.example.projecttest.exercises

import java.lang.IllegalArgumentException

class FootballTeam(private var wonGame: Int) : Comparable<FootballTeam> {

    init {
        if (wonGame < 0)
            throw IllegalArgumentException()
    }

    fun getGamesWon(): Int {
        return wonGame
    }

    override fun compareTo(other: FootballTeam): Int {
        return wonGame - other.getGamesWon();
    }
}
