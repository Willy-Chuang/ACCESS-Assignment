package com.willychuang.access.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.willychuang.access.UserListViewModel
import com.willychuang.access.data.source.AccessRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val accessRepository: AccessRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(UserListViewModel::class.java) ->
                    UserListViewModel(accessRepository)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T

}