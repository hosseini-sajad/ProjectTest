package com.example.projecttest

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class ClientTest {

    val ANY_NUMBER = "+123456777-88889"
    val MOBILE_PHONE = Phone(ANY_NUMBER)
    val STATIONARY_PHONE = Phone("123")
    private val MOBILE_PHONE_TEST_DOUBLES = mock(Phone::class.java)
    private val STATIONARY_PHONE_TEST_DOUBLES = mock(Phone::class.java)

    val client = Client2()

    @Test
    fun shouldReturnTrueIfClientHasMobile() {
        client.addPhone(MOBILE_PHONE)
        client.addPhone(STATIONARY_PHONE)
        assertTrue(client.hasMobile())
    }

    @Test
    fun shouldReturnFalseIfClientHasNoMobile() {
        client.addPhone(STATIONARY_PHONE)
        assertFalse(client.hasMobile())
    }

    // ------------------Test Doubles-----------------

    @Test
    fun shouldReturnTrueIfClientHasMobileTestDoubles() {
        `when`(MOBILE_PHONE_TEST_DOUBLES.isMobile()).thenReturn(true)

        client.addPhone(MOBILE_PHONE_TEST_DOUBLES)
        client.addPhone(STATIONARY_PHONE_TEST_DOUBLES)

        assertTrue(client.hasMobile())
    }

    @Test
    fun shouldReturnFalseIfClientHasNoMobileTestDoubles() {
        client.addPhone(STATIONARY_PHONE)
        assertFalse(client.hasMobile())
    }

}