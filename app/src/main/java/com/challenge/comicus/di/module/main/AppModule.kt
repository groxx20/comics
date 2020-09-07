package com.challenge.comicus.di.module.main

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.challenge.comicus.di.annotation.ViewModelKey
import com.challenge.comicus.di.module.db.DbModule
import com.challenge.comicus.ui.base.BaseViewModel
import com.challenge.comicus.ui.base.ComicViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

/**
 * Created by Pavel on 03/09/2020.
 **/

@Module (includes = [DbModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    fun provideViewModelFactory(comicViewModelFactory: ComicViewModelFactory): ViewModelProvider.Factory {
        return comicViewModelFactory
    }

    @Provides
    @IntoMap
    @ViewModelKey(BaseViewModel::class)
    fun provideBaseViewModel(baseViewModel: BaseViewModel): ViewModel {
        return baseViewModel
    }
}