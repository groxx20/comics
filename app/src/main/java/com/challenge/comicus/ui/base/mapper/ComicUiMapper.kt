package com.challenge.comicus.ui.base.mapper

import com.challenge.comicus.data.model.Comic
import com.challenge.comicus.ui.base.model.ComicUi
import javax.inject.Inject

/**
 * Created by Pavel on 07/09/2020.
 **/

class ComicUiMapper @Inject constructor() : UiMapper<Comic, ComicUi> {
    override fun mapFromData(data: Comic): ComicUi {
        return ComicUi(
            comicNumber = data.comicNumber,
            day = data.day,
            month = data.month,
            year = data.year,
            link = data.link,
            news = data.news,
            alt = data.alt,
            imgLink = data.imgLink,
            title = data.title,
            safeTitle = data.safeTitle,
            transcript = data.transcript
        )
    }
}