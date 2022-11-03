package com.example.projecttest

import com.example.projecttest.exercises.Person
import com.example.projecttest.exercises.StringReverse
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class StringReverseTest {

    private fun getString() = arrayOf(arrayOf("sajad"),
        arrayOf("SaJad"),
        arrayOf("a"))

    private fun getInvalidString() = arrayOf("")

    @Test(expected = IllegalArgumentException::class)
    @Parameters(method = "getInvalidString")
    fun constructorShouldThrowIAEForInvalidName(invalidString: String) {
        StringReverse.reverse(invalidString)
    }

    @Test
    @Parameters(method = "getString")
    fun shouldReversString(text: String) {
        assertEquals(text.reversed(), StringReverse.reverse(text))
    }
}