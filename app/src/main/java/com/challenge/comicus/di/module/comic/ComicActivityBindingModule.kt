package com.challenge.comicus.di.module.comic

import androidx.lifecycle.ViewModel
import com.challenge.comicus.di.annotation.ViewModelKey
import com.challenge.comicus.ui.comic.ComicViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Pavel on 03/09/2020.
 **/

@Module
abstract class ComicActivityBindingModule {

    @Binds
    @IntoMap
    @ViewModelKey(ComicViewModel::class)
    abstract fun bindComicViewModel(loginViewModel: ComicViewModel): ViewModel
}