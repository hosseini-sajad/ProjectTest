package com.example.projecttest

import junit.framework.Assert.assertEquals
import junit.framework.Assert.fail
import junitparams.JUnitParamsRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class Phone2Test {
    val phone = Phone2()

    @Test
    fun shouldThrowIAEForEmptyNumber() {
        try {
            phone.number = null
            fail("Should have thrown IllegalArgumentException")
        } catch (iae: IllegalArgumentException) {
            assertEquals("number can not be null or empty", iae.message)
        }
    }

    @Test
    fun shouldThrowIAEForPlusPrefixedNumber() {
        try {
            phone.number = "+123"
            fail("Should have thrown IllegalArgumentException")
        }catch (iae: IllegalArgumentException) {
            assertEquals("plus sign prefix not allowed, " + "number: [+123]", iae.message)
        }
    }
}