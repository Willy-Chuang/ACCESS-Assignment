package com.willychuang.access.data.source

class DefaultAccessRepository(
    private val remoteDataSource: AccessDataSource,
    private val localDataSource: AccessDataSource
) : AccessRepository {

}