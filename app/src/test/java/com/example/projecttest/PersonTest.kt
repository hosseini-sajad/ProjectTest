package com.example.projecttest

import com.example.projecttest.exercises.Person
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class PersonTest {

    private val VALID_ID = 5
    private val VALID_NAME = "USD"

    private fun getPerson() = arrayOf(arrayOf("aida", 1), arrayOf("sajad", 2))

    private fun getInvalidName() = arrayOf(null, "")

    @Test
    @Parameters(method = "getInvalidName")
    fun constructorShouldThrowIAEForInvalidName(invalidName: String?) {
        Person(invalidName, VALID_ID)
    }

    private fun getInvalidId() = arrayOf(-1, -5)

    @Test
    @Parameters(method = "getInvalidId")
    fun constructorShouldThrowIAEForInvalidId(invalidId: Int) {
        Person(VALID_NAME, invalidId)
    }

    @Test
    @Parameters(method = "getPerson")
    fun constructorShouldSetNameAndId(name: String, id: Int) {
        val person = Person(name, id)

        assertEquals(name, person.name)
        assertEquals(id, person.id)
    }

}