package com.example.projecttest.exercises

import androidx.core.text.isDigitsOnly

class Account(val password: String?) {
    init {
        if (password == null || password == "")
            throw IllegalArgumentException()
    }

    fun validate(): Boolean {
        if (password?.length!! < 5) return false
        if (password.firstOrNull { it.isDigit() } == null) return false
        if (password.filter { it.isLetter() }.firstOrNull { it.isUpperCase() } == null) return false

        return true
    }

}