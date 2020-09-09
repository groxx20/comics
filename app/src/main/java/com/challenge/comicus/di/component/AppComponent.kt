package com.challenge.comicus.di.component

import android.app.Application
import com.challenge.comicus.application.ComicApplication
import com.challenge.comicus.di.module.main.ActivityBindingModule
import com.challenge.comicus.di.module.main.AppModule
import com.challenge.comicus.di.module.network.NetworkModule
import com.challenge.comicus.di.module.rx.RxSchedulersModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by Pavel on 03/09/2020.
 **/

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBindingModule::class,
        AppModule::class,
        NetworkModule::class,
        RxSchedulersModule::class
    ]
)
interface AppComponent : AndroidInjector<ComicApplication> {

    override fun inject(application: ComicApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}