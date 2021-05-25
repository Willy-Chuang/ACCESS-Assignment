package com.willychuang.access.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.willychuang.access.AccessApplication

fun isInternetConnected(): Boolean {
    val cm = AccessApplication.instance
        .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkCapabilities = cm.activeNetwork ?: return false
    val activeNetwork = cm.getNetworkCapabilities(networkCapabilities) ?: return false

    return when {

        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) ||
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        else -> false
    }
}