package com.example.projecttest

import junit.framework.Assert.*
import org.junit.Test
import org.mockito.Mockito.*
import java.lang.RuntimeException


class FirstMockitoTest {

    private val myFerrari = mock(Car::class.java)

    @Test
    fun testIfCarIsACar() {
        assertTrue(myFerrari is Car)
    }

    @Test
    fun testDefaultBehaviourOfTestDouble() {
        assertFalse(
            "new test double should return false as boolean",
            myFerrari.needsFuel()
        );
        assertEquals(
            "new test double should return 0.0 as double",
            0.0, myFerrari.getEngineTemperature()
        );

    }

    @Test
    fun testStubbing() {
        assertFalse(
            "new test double should return false as boolean",
            myFerrari.needsFuel()
        )

        `when`(myFerrari.needsFuel()).thenReturn(true)

        assertTrue(
            "after instructed test double should return what we want",
            myFerrari.needsFuel()
        )
    }

    @Test(expected = RuntimeException::class)
    fun throwException() {
        `when`(myFerrari.needsFuel()).thenThrow(RuntimeException())
        myFerrari.needsFuel()
    }

    @Test
    fun testVerification() {
        myFerrari.driveTo("Sweet home Shiraz")
        myFerrari.needsFuel()

        verify(myFerrari).driveTo("Sweet home Shiraz")
        verify(myFerrari).needsFuel()
    }

}