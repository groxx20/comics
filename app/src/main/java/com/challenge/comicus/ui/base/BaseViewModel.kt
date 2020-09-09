package com.challenge.comicus.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.challenge.comicus.remote.interceptor.BaseThrowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by Pavel on 03/09/2020.
 **/

open class BaseViewModel @Inject constructor(

) : ViewModel() {

    private val _httpException = MutableLiveData<BaseThrowable>()
    val httpException: LiveData<BaseThrowable>
        get() = _httpException

    fun handleHttpException(httpException: BaseThrowable) {
        _httpException.value = httpException
    }

    protected val disposables = CompositeDisposable()

    protected fun Disposable.addToDisposables() {
        disposables.add(this)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}