package com.challenge.comicus.data.interactor

import com.challenge.comicus.remote.repository.ComicRepository
import com.challenge.comicus.utils.extensions.getRandomNumberInRange
import com.challenge.comicus.utils.preferences.PreferencesUtil
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by Pavel on 07/09/2020.
 **/

class FetchComicUseCase @Inject constructor(
    private val comicRepository: ComicRepository,
    private val preferencesUtil: PreferencesUtil
) {

    fun fetchRandomComic(): Completable {
        val randomNumberInRange =
            getRandomNumberInRange(preferencesUtil.getInt(ComicRepository.MAX_COMIC_NUM, 0))
        preferencesUtil.putInt(ComicRepository.CURRENT_COMIC_NUM, randomNumberInRange)
        return comicRepository.requestRandomComic(randomNumberInRange)
    }

    fun fetchLatestComic() = comicRepository.requestLatestComic()
}
