package com.willychuang.access.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.willychuang.access.UserDetailViewModel
import com.willychuang.access.data.source.AccessRepository

@Suppress("UNCHECKED_CAST")
class StringViewModelFactory constructor(
    private val repository: AccessRepository,
    private val string: String?
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(UserDetailViewModel::class.java) ->
                    UserDetailViewModel(repository, string)

                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}