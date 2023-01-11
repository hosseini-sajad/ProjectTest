package com.example.projecttest

import com.example.projecttest.exercises.SecurityService
import com.example.projecttest.exercises.User
import com.example.projecttest.exercises.UserDAO
import com.example.projecttest.exercises.UserServiceImpl
import org.junit.Test
import org.mockito.Mockito.*

class UserServiceImplTest {

    @Test
    fun shouldUserGetPassword() {
        val userDao = mock(UserDAO::class.java)
        val securityService = mock(SecurityService::class.java)
        val userServiceImpl = UserServiceImpl(userDao, securityService)
        val user = mock(User::class.java)

        `when`(user.password).thenReturn("password")
        userServiceImpl.assignPassword(user)

        verify(user).password
        verify(userDao).updateUser(user)
    }
}