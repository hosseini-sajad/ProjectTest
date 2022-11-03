package com.example.projecttest

import com.example.projecttest.exercises.FootballTeam
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class FootballTeamTest{

    fun numberOfGamesWon() = arrayOf(0, 3, 4)

    @Test
    @Parameters(method = "numberOfGamesWon")
    fun constructorShouldSetGamesWon(won: Int) {
        val team = FootballTeam(won)

        assertEquals(won, team.getGamesWon())
    }

    fun illegalNumberOfGamesWon() = arrayOf(-1, -10)

    @Test(expected = IllegalArgumentException::class)
    @Parameters(method = "illegalNumberOfGamesWon")
    fun constructorShouldThrowExceptionForIllegalNumber(illegalNumberOfGamesWon: Int) {
        FootballTeam(illegalNumberOfGamesWon)
    }

    @Test
    fun shouldBePossibleCompareTeams() {
        val team = FootballTeam(ANY_NUMBER)

        assertTrue(team is Comparable<FootballTeam>)
    }

    @Test
    fun teamWithMoreMatchesWonShouldBeGrater() {
        val team2 = FootballTeam(2)
        val team3 = FootballTeam(3)

        assertTrue(team3.compareTo(team2) > 0)
    }

    @Test
    fun teamWithLessMatchesWonShouldBeLesser() {
        val team2 = FootballTeam(2)
        val team3 = FootballTeam(3)

        assertTrue(team2.compareTo(team3) < 0)
    }

    @Test
    fun teamWithSameMatchesWonShouldBeEqual() {
        val teamA = FootballTeam(2)
        val teamB = FootballTeam(2)

        assertTrue(teamA.compareTo(teamB) == 0)
    }
}

private const val ANY_NUMBER = 123