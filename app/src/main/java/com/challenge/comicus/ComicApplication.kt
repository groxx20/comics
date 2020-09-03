package com.challenge.comicus

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by Pavel on 03/09/2020.
 **/
class ComicApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder()
            .application(this)
            .build()
}