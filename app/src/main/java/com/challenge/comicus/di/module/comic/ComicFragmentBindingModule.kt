package com.challenge.comicus.di.module.comic

import com.challenge.comicus.ui.comic.ComicFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Pavel on 03/09/2020.
 **/

@Module
abstract class ComicFragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun bindComicFragment(): ComicFragment
}