package com.willychuang.access.data.source

import com.willychuang.access.data.User

class DefaultAccessRepository(
    private val remoteDataSource: AccessDataSource,
    private val localDataSource: AccessDataSource
) : AccessRepository {

    override suspend fun getAllUsers(): List<User> {
        return remoteDataSource.getAllUsers()
    }

    override suspend fun getUser(login: String): User {
        return remoteDataSource.getUser(login)
    }

}