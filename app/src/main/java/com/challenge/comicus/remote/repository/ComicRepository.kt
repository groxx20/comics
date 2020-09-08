package com.challenge.comicus.remote.repository

import com.challenge.comicus.remote.mapper.ComicDtoDbMapper
import com.challenge.comicus.remote.service.ComicService
import com.challenge.comicus.room.dao.ComicDao
import com.challenge.comicus.room.model.ComicEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Pavel on 07/09/2020.
 **/
class ComicRepository @Inject constructor(
    private val comicDao: ComicDao,
    private val comicDtoDbMapper: ComicDtoDbMapper,
    private val comicService: ComicService
) {

    fun getComicByNumber(number: Int): Flowable<ComicEntity> = comicDao.getById(number)
        .subscribeOn(Schedulers.single())

    fun getLatestComic(): Flowable<ComicEntity> = comicDao.getLatestComic()
        .subscribeOn(Schedulers.single())

    fun requestComicByNumber(number: Int): Completable {
        return comicService.getComicByNumber(number)
            .map (comicDtoDbMapper::mapFromRemote)
            .flatMapCompletable(comicDao::insert)
            .subscribeOn(Schedulers.io())
    }

    fun requestLatestComic(): Completable =
        comicService.getLatestComic()
            .map (comicDtoDbMapper::mapFromRemote)
            .flatMapCompletable(comicDao::insert)
            .subscribeOn(Schedulers.io())
}
