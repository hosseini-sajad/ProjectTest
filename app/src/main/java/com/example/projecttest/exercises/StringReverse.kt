package com.example.projecttest.exercises

import java.lang.IllegalArgumentException

object StringReverse {

    fun reverse(s: String): String? {
        if (s == "")
            throw IllegalArgumentException("Illegal ex")

        val tempArray: MutableList<String> = ArrayList(s.length)
        for (i in s.indices) {
            tempArray.add(s.substring(i, i + 1))
        }
        val reversedString = StringBuilder(s.length)
        for (i in tempArray.indices.reversed()) {
            reversedString.append(tempArray[i])
        }
        return reversedString.toString()
    }
}