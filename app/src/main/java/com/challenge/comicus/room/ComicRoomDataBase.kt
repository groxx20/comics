package com.challenge.comicus.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.challenge.comicus.room.ComicRoomDataBase.Companion.DB_VERSION
import com.challenge.comicus.room.dao.ComicDao
import com.challenge.comicus.room.model.ComicEntity

/**
 * Created by Pavel on 04/09/2020.
 **/

@Database(
    entities = [ComicEntity::class],
    version = DB_VERSION
)

abstract class ComicRoomDataBase: RoomDatabase() {

    companion object {
        const val DB_VERSION = 1
        private const val DB_NAME = "comics.db"
        private lateinit var instance: ComicRoomDataBase

        fun getDbInstance(context: Context): ComicRoomDataBase {
            return if (!this::instance.isInitialized) {
                synchronized(ComicRoomDataBase::class) {
                    Room.databaseBuilder(
                        context.applicationContext,
                        ComicRoomDataBase::class.java,
                        DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            } else {
                instance
            }
        }
    }

    abstract fun comicDao() : ComicDao
}