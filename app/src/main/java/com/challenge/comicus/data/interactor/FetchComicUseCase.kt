package com.challenge.comicus.data.interactor

import com.challenge.comicus.remote.repository.ComicRepository
import javax.inject.Inject

/**
 * Created by Pavel on 07/09/2020.
 **/

class FetchComicUseCase @Inject constructor(
    private val comicRepository: ComicRepository
) {

    fun fetchComicByNumber(number: Int) = comicRepository.requestComicByNumber(number)

    fun fetchLatestComic() = comicRepository.requestLatestComic()
}
