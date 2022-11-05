package com.example.projecttest

import com.example.projecttest.exercises.Account
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class AccountTest {

    fun differentPassword() = arrayOf("sajad", "aida")

    @Test
    @Parameters(method = "differentPassword")
    fun constructorShouldSetPassword(password: String?) {
        val account = Account(password)

        assertEquals(password, account.password)
    }

    fun illegalPassword() = arrayOf(null, "")

    @Test(expected = IllegalArgumentException::class)
    @Parameters(method = "illegalPassword")
    fun constructorShouldThrowExceptionForIllegalPassword(password: String?) {
        Account(password)
    }

    fun differentPasswordForValidate() = arrayOf("Sajad7")

    @Test
    @Parameters(method = "differentPasswordForValidate")
    fun passwordShouldBeValidate(password: String?) {
        val account = Account(password)

        assertTrue(account.validate())
    }
}