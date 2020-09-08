package com.challenge.comicus.ui.comic

import android.util.Log
import androidx.lifecycle.LiveDataReactiveStreams.fromPublisher
import com.challenge.comicus.data.interactor.FetchComicUseCase
import com.challenge.comicus.data.interactor.GetComicUseCase
import com.challenge.comicus.ui.base.BaseViewModel
import com.challenge.comicus.ui.base.mapper.ComicUiMapper
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Pavel on 03/09/2020.
 **/
class ComicViewModel @Inject constructor(
    private val comicUseCase: GetComicUseCase,
    private val fetchComicUseCase: FetchComicUseCase,
    private val comicUiMapper: ComicUiMapper
) : BaseViewModel() {

    fun getLatestComic() = fromPublisher(
        comicUseCase.getLatestComic()
            .map(comicUiMapper::mapFromData)
    )

    fun getComicByNumber(number: Int) = fromPublisher(
        comicUseCase.getComicByNumber(number)
            .map(comicUiMapper::mapFromData)
    )

    fun fetchLatestComic() = fetchComicUseCase.fetchLatestComic()
        .subscribeBy(
            onError = { Timber.d(it.localizedMessage) },
            onComplete = { clearDisposables() }
        )
        .addToDisposables()

    fun fetchComicByNumber(number: Int) = fetchComicUseCase.fetchComicByNumber(number)
        .subscribeBy(
            onError = { Timber.d(it.localizedMessage) },
            onComplete = { clearDisposables() }
        )
        .addToDisposables()
}