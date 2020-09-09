package com.challenge.comicus.data.mapper

import com.challenge.comicus.data.model.Comic
import com.challenge.comicus.room.model.ComicEntity
import javax.inject.Inject

/**
 * Created by Pavel on 07/09/2020.
 **/

class ComicMapper @Inject constructor() : FromDbMapper<ComicEntity, Comic> {
    override fun mapFromDb(entity: ComicEntity): Comic {
        return Comic(
            comicNumber = entity.comicNumber,
            day = entity.day,
            month = entity.month,
            year = entity.year,
            link = entity.link,
            news = entity.news,
            alt = entity.alt,
            imgLink = entity.imgLink,
            title = entity.title,
            safeTitle = entity.safeTitle,
            transcript = entity.transcript,
            favorite = entity.favorite
        )
    }
}