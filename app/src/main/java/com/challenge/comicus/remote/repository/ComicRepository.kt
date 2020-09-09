package com.challenge.comicus.remote.repository

import com.challenge.comicus.remote.mapper.ComicDtoDbMapper
import com.challenge.comicus.remote.service.ComicService
import com.challenge.comicus.room.dao.ComicDao
import com.challenge.comicus.room.model.ComicEntity
import com.challenge.comicus.utils.preferences.PreferencesUtil
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
    private val comicService: ComicService,
    private val preferencesUtil: PreferencesUtil
) {

    companion object {
        const val MAX_COMIC_NUM = "max_comic_num"
        const val CURRENT_COMIC_NUM = "current_comic_num"
    }

    fun getComicById(): Flowable<ComicEntity> =
        comicDao.getById(preferencesUtil.getInt(CURRENT_COMIC_NUM, 0))
            .subscribeOn(Schedulers.single())

    fun getLatestComic(): Flowable<ComicEntity> =
        comicDao.getLatestComic()
            .subscribeOn(Schedulers.single())

    fun requestRandomComic(randomId: Int): Completable {
        return comicService.getRandomComic(randomId)
            .map(comicDtoDbMapper::mapFromRemote)
            .flatMapCompletable(comicDao::insert)
            .subscribeOn(Schedulers.io())
    }

    fun requestLatestComic(): Completable =
        comicService.getLatestComic()
            .map {
                preferencesUtil.putInt(MAX_COMIC_NUM, it.num)
                comicDtoDbMapper.mapFromRemote(it)
            }
            .flatMapCompletable(comicDao::insert)
            .subscribeOn(Schedulers.io())
}