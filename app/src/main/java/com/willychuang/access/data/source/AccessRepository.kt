package com.willychuang.access.data.source

import com.willychuang.access.data.User

interface AccessRepository {
    suspend fun getAllUsers(): List<User>

    suspend fun getUser(login: String): User

}