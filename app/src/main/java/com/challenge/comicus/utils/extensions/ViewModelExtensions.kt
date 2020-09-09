package com.challenge.comicus.utils.extensions

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.challenge.comicus.ui.base.ComicViewModelFactory

/**
 * Created by Pavel on 03/09/2020.
 **/

@Throws(IllegalArgumentException::class)
inline fun <reified T : ViewModel> ComicViewModelFactory.getViewModel(activity: FragmentActivity?): T? {
    activity ?: return null
    return ViewModelProvider(activity, this).get(T::class.java)
}

infix fun <T> MutableLiveData<T>.post(value: T) {
    postValue(value)
}