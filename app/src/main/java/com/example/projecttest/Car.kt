package com.example.projecttest

interface Car {
    fun needsFuel(): Boolean
    fun getEngineTemperature(): Double
    fun driveTo(destination: String?)
}