package com.willychuang.access.data.source

import com.willychuang.access.data.User
import com.willychuang.access.utils.Result

class DefaultAccessRepository(
    private val remoteDataSource: AccessDataSource,
    private val localDataSource: AccessDataSource
) : AccessRepository {

    override suspend fun getAllUsers(): Result<List<User>> {
        return remoteDataSource.getAllUsers()
    }

    override suspend fun getUser(login: String): Result<User> {
        return remoteDataSource.getUser(login)
    }

}