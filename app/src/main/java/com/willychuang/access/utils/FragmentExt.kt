package com.willychuang.access.utils

import androidx.fragment.app.Fragment
import com.willychuang.access.AccessApplication
import com.willychuang.access.factory.ViewModelFactory

fun Fragment.getVmFactory(): ViewModelFactory {
    val repository = (requireContext().applicationContext as AccessApplication).accessRepository
    return ViewModelFactory(repository)
}