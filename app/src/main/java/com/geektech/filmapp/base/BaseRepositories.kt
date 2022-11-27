package com.geektech.filmapp.base

import androidx.lifecycle.liveData
import com.geektech.filmapp.common.Resource

abstract class BaseRepositories {

    protected fun <T> doRequest(result: suspend () -> T) = liveData {

        emit(Resource.Loading())
        try {
            emit(Resource.Success(result()))
        } catch (exception: Exception) {
            emit(Resource.Error(massage = exception.localizedMessage ?: "Error"))
        }
    }
}