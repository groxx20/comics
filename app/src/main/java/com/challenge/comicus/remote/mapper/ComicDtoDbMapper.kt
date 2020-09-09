package com.challenge.comicus.remote.mapper

import com.challenge.comicus.remote.model.ComicDto
import com.challenge.comicus.room.model.ComicEntity
import javax.inject.Inject

/**
 * Created by Pavel on 07/09/2020.
 **/
class ComicDtoDbMapper @Inject constructor() : FromRemoteMapper<ComicDto, ComicEntity> {
    override fun mapFromRemote(dto: ComicDto): ComicEntity {
        return ComicEntity(
            comicNumber = dto.num,
            day = dto.day,
            month = dto.month,
            year = dto.year,
            link = dto.link,
            news = dto.news,
            alt = dto.alt,
            imgLink = dto.img,
            title = dto.title,
            safeTitle = dto.safeTitle,
            transcript = dto.transcript,
            favorite = false
        )
    }
}