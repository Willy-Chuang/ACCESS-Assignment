package com.willychuang.access.utils

import android.content.Context
import androidx.annotation.VisibleForTesting
import com.willychuang.access.data.source.AccessDataSource
import com.willychuang.access.data.source.AccessRepository
import com.willychuang.access.data.source.DefaultAccessRepository
import com.willychuang.access.data.source.local.AccessLocalDataSource
import com.willychuang.access.data.source.remote.AccessRemoteDataSource

object ServiceLocator {
    @Volatile
    var repository: AccessRepository? = null
        @VisibleForTesting set

    fun provideRepository(context: Context): AccessRepository {
        synchronized(this) {
            return repository
                ?: repository
                ?: createAccessRepository(context)
        }
    }

    private fun createAccessRepository(context: Context): AccessRepository {
        return DefaultAccessRepository(
            AccessRemoteDataSource,
            createLocalDataSource(context)
        )
    }

    private fun createLocalDataSource(context: Context): AccessDataSource {
        return AccessLocalDataSource(context)
    }
}