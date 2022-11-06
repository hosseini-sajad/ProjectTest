package com.example.projecttest

import junit.framework.Assert.assertTrue
import org.junit.Test
import org.mockito.Mockito.mock

class FirstMockitoTest {

    private val myFerrari = mock(Car::class.java)

    @Test
    fun testIfCarIsACar() {
        assertTrue(myFerrari is Car)
    }
}