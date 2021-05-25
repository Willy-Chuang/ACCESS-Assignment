package com.willychuang.access.data.source.remote

import com.willychuang.access.data.User
import com.willychuang.access.data.source.AccessDataSource
import com.willychuang.access.network.ServerApi
import com.willychuang.access.utils.Logger
import com.willychuang.access.utils.Result
import com.willychuang.access.utils.isInternetConnected
import retrofit2.HttpException
import java.net.ConnectException

object AccessRemoteDataSource : AccessDataSource {

    override suspend fun getAllUsers(): Result<List<User>> {
        if (!isInternetConnected()) {
            return Result.Fail("There is no internet connection")
        }
        return try {
            val result = ServerApi.retrofitService.getAllUsers()

            Result.Success(result)
        } catch (e: HttpException) {
            val text = e.response()?.errorBody()?.string()
            Logger.w("[${this::class.simpleName}] exception error message=$text")
            Result.Fail(text.toString())
        } catch (ce: ConnectException) {
            Logger.w("[${this::class.simpleName}] exception=${ce.message}")
            Result.Error(ce)
        }
    }

    override suspend fun getUser(login: String): Result<User> {
        if (!isInternetConnected()) {
            return Result.Fail("There is no internet connection")
        }
        return try {
            val result = ServerApi.retrofitService.getUser(login)

            Result.Success(result)
        } catch (e: HttpException) {
            val text = e.response()?.errorBody()?.string()
            Logger.w("[${this::class.simpleName}] exception error message=$text")
            Result.Fail(text.toString())
        } catch (ce: ConnectException) {
            Logger.w("[${this::class.simpleName}] exception=${ce.message}")
            Result.Error(ce)
        }
    }

}