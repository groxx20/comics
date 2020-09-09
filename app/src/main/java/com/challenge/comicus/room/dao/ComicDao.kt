package com.challenge.comicus.room.dao

import androidx.room.*
import com.challenge.comicus.room.model.ComicEntity
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created by Pavel on 07/09/2020.
 **/

@Dao
abstract class ComicDao {

    @Query("SELECT * FROM comic WHERE comic.comicNumber = :comicNum")
    abstract fun getById(comicNum: Int): Flowable<ComicEntity>

    @Query("SELECT * FROM comic WHERE comicNumber = (SELECT MAX(comicNumber) FROM comic)")
    abstract fun getLatestComic(): Flowable<ComicEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(comic: ComicEntity): Completable
}