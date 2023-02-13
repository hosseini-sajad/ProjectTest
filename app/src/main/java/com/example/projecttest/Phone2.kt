package com.example.projecttest

class Phone2 {
    var number: String? = null
        get() = field
        set(value) {
            number?.let {
                if (null == number || it.isEmpty()) {
                    throw IllegalArgumentException(
                        "number can not be null or empty")
                }
                if (it.startsWith("+")) {
                    throw IllegalArgumentException(
                        "plus sign prefix not allowed, number: [" + number + "]")
                }
            }
            field = value
        }
}