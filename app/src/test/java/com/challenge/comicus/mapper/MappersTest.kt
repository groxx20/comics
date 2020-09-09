package com.challenge.comicus.mapper

import com.challenge.comicus.data.mapper.ComicMapper
import com.challenge.comicus.data.model.Comic
import com.challenge.comicus.mapper.ComicFactory.generateComic
import com.challenge.comicus.mapper.ComicFactory.generateComicDto
import com.challenge.comicus.mapper.ComicFactory.generateComicEntity
import com.challenge.comicus.remote.mapper.ComicDtoDbMapper
import com.challenge.comicus.remote.model.ComicDto
import com.challenge.comicus.room.model.ComicEntity
import com.challenge.comicus.ui.base.mapper.ComicUiMapper
import org.junit.Test

/**
 * Created by Pavel on 09/09/2020.
 **/
class MappersTest {

    private val comicDto: ComicDto = generateComicDto()
    private val comicEntity: ComicEntity = generateComicEntity()
    private val comic: Comic = generateComic()

    private val comicDtoDbMapper = ComicDtoDbMapper()
    private val comicMapper = ComicMapper()
    private val comicUiMapper = ComicUiMapper()

    @Test
    fun `verify dto entity mapper`() {
        val mappedEntity = comicDtoDbMapper.mapFromRemote(comicDto)

        assert(comicDto.day == mappedEntity.day)
        assert(comicDto.link == mappedEntity.link)
        assert(comicDto.year == mappedEntity.year)
        assert(comicDto.img == mappedEntity.imgLink)
        assert(comicDto.news == mappedEntity.news)
        assert(comicDto.alt == mappedEntity.alt)
        assert(comicDto.transcript == mappedEntity.transcript)
    }

    @Test
    fun `verify comic mapper`() {
        val mappedComic = comicMapper.mapFromDb(comicEntity)

        assert(comicEntity.day == mappedComic.day)
        assert(comicEntity.link == mappedComic.link)
        assert(comicEntity.year == mappedComic.year)
        assert(comicEntity.imgLink == mappedComic.imgLink)
        assert(comicEntity.news == mappedComic.news)
        assert(comicEntity.alt == mappedComic.alt)
        assert(comicEntity.transcript == mappedComic.transcript)
        assert(comicEntity.favorite == mappedComic.favorite)
    }

    @Test
    fun `verify comic ui mapper`() {
        val mappedComicUi = comicUiMapper.mapFromData(comic)

        assert(comic.day == mappedComicUi.day)
        assert(comic.link == mappedComicUi.link)
        assert(comic.year == mappedComicUi.year)
        assert(comic.imgLink == mappedComicUi.imgLink)
        assert(comic.news == mappedComicUi.news)
        assert(comic.alt == mappedComicUi.alt)
        assert(comic.transcript == mappedComicUi.transcript)
        assert(comic.favorite == mappedComicUi.favorite)
    }
}