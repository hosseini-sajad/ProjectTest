package com.example.projecttest

data class Phone(val number: String) {

    private var mobile: Boolean = number.startsWith("+") && number.endsWith("9")

    fun isMobile(): Boolean {
        return mobile
    }
}