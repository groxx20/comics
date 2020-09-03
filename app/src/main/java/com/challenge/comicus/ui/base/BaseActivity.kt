package com.challenge.comicus.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.challenge.comicus.remote.interceptor.BadRequestException
import com.challenge.comicus.remote.interceptor.BaseThrowable
import com.challenge.comicus.utils.extensions.getViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by Pavel on 03/09/2020.
 **/


abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: ComicViewModelFactory

    private val baseViewModel by lazy {
        factory.getViewModel<BaseViewModel>(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        baseViewModel?.httpException?.observe(this, Observer {
            handleHttpException(it)
        })
    }

    override fun onDestroy() {
        baseViewModel?.httpException?.removeObservers(this)
        super.onDestroy()
    }

    private fun handleHttpException(httpException: BaseThrowable) {
        when (httpException) {
            is BadRequestException -> {
                Toast.makeText(this, "Bad request!", Toast.LENGTH_SHORT).show()
            } // handle any other defined exception below
        }
    }
}