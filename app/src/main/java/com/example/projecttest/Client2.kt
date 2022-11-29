package com.example.projecttest

class Client2 {
    private val phones: MutableList<Phone> = ArrayList()

    fun addPhone(phone: Phone) {
        phones.add(phone)
    }

    fun hasMobile(): Boolean {
        for (phone in phones) {
            if (phone.isMobile()) {
                return true
            }
        }
        return false
    }

}