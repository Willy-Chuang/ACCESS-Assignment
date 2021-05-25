package com.willychuang.access.data.source

import com.willychuang.access.data.User
import com.willychuang.access.utils.Result

interface AccessDataSource {
    suspend fun getAllUsers(): Result<List<User>>

    suspend fun getUser(login: String): Result<User>
}