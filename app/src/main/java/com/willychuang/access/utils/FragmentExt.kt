package com.willychuang.access.utils

import androidx.fragment.app.Fragment
import com.willychuang.access.AccessApplication
import com.willychuang.access.factory.StringViewModelFactory
import com.willychuang.access.factory.ViewModelFactory

fun Fragment.getVmFactory(): ViewModelFactory {
    val repository = (requireContext().applicationContext as AccessApplication).accessRepository
    return ViewModelFactory(repository)
}
fun Fragment.getVmFactory(string: String?) : StringViewModelFactory {
    val repository = (requireContext().applicationContext as AccessApplication).accessRepository
    return StringViewModelFactory(repository, string)
}