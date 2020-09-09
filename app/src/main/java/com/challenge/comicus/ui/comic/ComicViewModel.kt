package com.challenge.comicus.ui.comic

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams.fromPublisher
import com.challenge.comicus.data.interactor.FetchComicUseCase
import com.challenge.comicus.data.interactor.GetComicUseCase
import com.challenge.comicus.ui.base.BaseViewModel
import com.challenge.comicus.ui.base.mapper.ComicUiMapper
import com.challenge.comicus.ui.base.model.ComicUi
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Pavel on 03/09/2020.
 **/
class ComicViewModel @Inject constructor(
    private val getComicUseCase: GetComicUseCase,
    private val fetchComicUseCase: FetchComicUseCase,
    private val comicUiMapper: ComicUiMapper
) : BaseViewModel() {

    var publisherComic = fromPublisher(
        getComicUseCase.getLatestComic()
            .map(comicUiMapper::mapFromData)
    )

    fun getLatestComic() = publisherComic

    fun getComicById(): LiveData<ComicUi> {
        publisherComic = fromPublisher(
            getComicUseCase.getComicById()
                .map(comicUiMapper::mapFromData)
        )
        return publisherComic
    }

    fun fetchLatestComic() = fetchComicUseCase.fetchLatestComic()
        .subscribeBy(
            onError = { Timber.d(it.localizedMessage) },
            onComplete = {}
        )
        .addToDisposables()

    fun fetchRandomComic() = fetchComicUseCase.fetchRandomComic()
        .subscribeBy(
            onError = { Timber.d(it.localizedMessage) },
            onComplete = {}
        )
        .addToDisposables()
}