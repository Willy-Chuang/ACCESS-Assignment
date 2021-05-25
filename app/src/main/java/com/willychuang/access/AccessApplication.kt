package com.willychuang.access

import android.app.Application
import android.content.Context
import com.willychuang.access.data.source.AccessRepository
import com.willychuang.access.utils.ServiceLocator
import kotlin.properties.Delegates

class AccessApplication : Application(){

    val accessRepository: AccessRepository
        get() = ServiceLocator.provideRepository(this)

    companion object {
        var instance: AccessApplication by Delegates.notNull()
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        instance = this
    }
}