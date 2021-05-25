package com.willychuang.access.data.source.local

import android.content.Context
import com.willychuang.access.data.User
import com.willychuang.access.data.source.AccessDataSource
import com.willychuang.access.utils.Result

class AccessLocalDataSource(val context: Context) : AccessDataSource {
    override suspend fun getAllUsers(): Result<List<User>> {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(login: String): Result<User> {
        TODO("Not yet implemented")
    }
}