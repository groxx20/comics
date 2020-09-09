package com.challenge.comicus.mapper

import com.challenge.comicus.data.model.Comic
import com.challenge.comicus.remote.model.ComicDto
import com.challenge.comicus.room.model.ComicEntity

/**
 * Created by Pavel on 09/09/2020.
 **/
object ComicFactory {

    fun generateComicDto() = ComicDto(
        month = 1,
        num = 10,
        link = "",
        year = 2020,
        news = "",
        safeTitle = "",
        transcript = "",
        alt = "",
        img = "random link",
        title = "",
        day = 1
    )

    fun generateComicEntity() = ComicEntity(
        comicNumber = 100,
        day = 10,
        month = 10,
        year = 2030,
        link = "",
        news = "",
        alt = "",
        imgLink = "",
        title = "",
        safeTitle = "",
        transcript = "",
        favorite = false
    )

    fun generateComic() = Comic(
        comicNumber = 100,
        day = 10,
        month = 10,
        year = 2030,
        link = "",
        news = "",
        alt = "",
        imgLink = "",
        title = "",
        safeTitle = "",
        transcript = "",
        favorite = false
    )
}