package com.willychuang.access

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.willychuang.access.data.User
import com.willychuang.access.data.source.AccessRepository
import com.willychuang.access.network.LoadApiStatus
import com.willychuang.access.utils.Logger
import com.willychuang.access.utils.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class UserDetailViewModel(private val repository: AccessRepository, val login: String?) : ViewModel(){
    private val _user = MutableLiveData<User>()

    val user: LiveData<User>
        get() = _user

    // status: The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<LoadApiStatus>()

    val status: LiveData<LoadApiStatus>
        get() = _status

    // error: The internal MutableLiveData that stores the error of the most recent request
    private val _error = MutableLiveData<String>()

    val error: LiveData<String>
        get() = _error

    // Create a Coroutine scope using a job to be able to cancel when needed
    private var viewModelJob = Job()

    // the Coroutine runs using the Main (UI) dispatcher
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    init {
        Logger.i("------------------------------------")
        Logger.i("[${this::class.simpleName}]${this}")
        Logger.i("------------------------------------")
        login?.let {
            getUser(it)
        }

    }

    private fun getUser(login: String){
        coroutineScope.launch {

            val result = repository.getUser(login)

            _user.value = when (result) {
                is Result.Success -> {
                    _error.value = null
                    _status.value = LoadApiStatus.DONE
                    Logger.i("register status =${result.data}")
                    result.data
                }
                is Result.Fail -> {
                    _error.value = result.error
                    _status.value = LoadApiStatus.ERROR
                    null
                }
                is Result.Error -> {
                    _error.value = result.exception.toString()
                    _status.value = LoadApiStatus.ERROR
                    null
                }

                else -> {
                    _error.value = "You know nothing"
                    _status.value = LoadApiStatus.ERROR
                    null
                }

            }
        }
    }
}