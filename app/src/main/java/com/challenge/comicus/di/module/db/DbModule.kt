package com.challenge.comicus.di.module.db

import android.app.Application
import android.content.Context
import com.challenge.comicus.room.ComicRoomDataBase
import com.challenge.comicus.room.dao.ComicDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Pavel on 07/09/2020.
 **/

@Module
class DbModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): ComicRoomDataBase {
        return ComicRoomDataBase.getDbInstance(context)
    }

    @Singleton
    @Provides
    fun provideComicDao(adminAppDatabase: ComicRoomDataBase): ComicDao {
        return adminAppDatabase.comicDao()
    }
}