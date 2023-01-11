package com.example.projecttest.exercises

import java.lang.Exception

class UserServiceImpl(private val userDAO: UserDAO, private val securityService: SecurityService) {
    @Throws(Exception::class)
    fun assignPassword(user: User) {
        val passwordMd5 = securityService.md5(user.password)
        user.password = passwordMd5
        userDAO.updateUser(user)
    }
}