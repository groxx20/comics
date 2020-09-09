package com.challenge.comicus.repository

import com.challenge.comicus.remote.rx.TestSchedulers
import com.challenge.comicus.remote.mapper.ComicDtoDbMapper
import com.challenge.comicus.remote.model.ComicDto
import com.challenge.comicus.remote.repository.ComicRepository
import com.challenge.comicus.remote.repository.ComicRepository.Companion.CURRENT_COMIC_NUM
import com.challenge.comicus.remote.repository.ComicRepository.Companion.MAX_COMIC_NUM
import com.challenge.comicus.remote.rx.RxSchedulers
import com.challenge.comicus.remote.service.ComicService
import com.challenge.comicus.room.dao.ComicDao
import com.challenge.comicus.room.model.ComicEntity
import com.challenge.comicus.utils.preferences.PreferencesUtil
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

/**
 * Created by Pavel on 09/09/2020.
 **/
class ComicRepositoryTest {

    companion object {
        const val MOCK_COMIC_ID = 1000
    }

    private lateinit var comicRepository: ComicRepository

    private val comicDao: ComicDao = mockk()
    private val comicDtoDbMapper: ComicDtoDbMapper = mockk()
    private val comicService: ComicService = mockk()
    private val preferencesUtil: PreferencesUtil = mockk()
    private val rxSchedulers: RxSchedulers = TestSchedulers()

    private val latestComicEntity: ComicEntity = mockk()
    private val randomComicEntity: ComicEntity = mockk()
    private val comicDto: ComicDto = mockk()

    @Before
    fun setUp() {
        comicRepository = ComicRepository(comicDao, comicDtoDbMapper, comicService, preferencesUtil, rxSchedulers)
    }

    @Test
    fun `get latest comic from DB`() {
        every { comicDao.getLatestComic() } returns Flowable.just(latestComicEntity)

        comicRepository.getLatestComic().test().assertValue(latestComicEntity)
    }

    @Test
    fun `get random comic by ID from DB`() {
        every { preferencesUtil.getInt(CURRENT_COMIC_NUM, 0) } returns MOCK_COMIC_ID
        every { comicDao.getById(MOCK_COMIC_ID) } returns Flowable.just(randomComicEntity)

        comicRepository.getComicById().test().assertValue(randomComicEntity)
    }

    @Test
    fun `verify fetching latest comic response`() {
        every { comicService.getLatestComic() } returns Single.just(comicDto)
        every { comicDto.num } returns MOCK_COMIC_ID
        every { preferencesUtil.putInt(MAX_COMIC_NUM, MOCK_COMIC_ID) } returns true
        every { comicDtoDbMapper.mapFromRemote(comicDto) } returns latestComicEntity
        every { comicDao.insert(latestComicEntity) } returns Completable.complete()

        comicRepository.requestLatestComic().test().assertComplete()
    }

    @Test
    fun `verify fetching random comic response`() {
        every { comicService.getRandomComic(MOCK_COMIC_ID) } returns Single.just(comicDto)
        every { comicDtoDbMapper.mapFromRemote(comicDto) } returns randomComicEntity
        every { comicDao.insert(randomComicEntity) } returns Completable.complete()

        comicRepository.requestRandomComic(MOCK_COMIC_ID).test().assertComplete()
    }
}