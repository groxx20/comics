package com.challenge.comicus.data.interactor

import com.challenge.comicus.data.mapper.ComicMapper
import com.challenge.comicus.remote.repository.ComicRepository
import javax.inject.Inject

/**
 * Created by Pavel on 07/09/2020.
 **/
class GetComicUseCase @Inject constructor(
    private val comicRepository: ComicRepository,
    private val comicMapper: ComicMapper
) {

    fun getComicById() = comicRepository.getComicById()
        .map(comicMapper::mapFromDb)

    fun getLatestComic() = comicRepository.getLatestComic()
        .map(comicMapper::mapFromDb)
}