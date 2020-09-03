package com.challenge.comicus.di.module.main

import com.challenge.comicus.di.module.comic.ComicActivityBindingModule
import com.challenge.comicus.di.module.comic.ComicFragmentBindingModule
import com.challenge.comicus.ui.comic.ComicActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Pavel on 03/09/2020.
 **/

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [
        ComicActivityBindingModule::class,
        ComicFragmentBindingModule::class
    ])
    abstract fun bindComicActivity(): ComicActivity
}