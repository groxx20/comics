package com.challenge.comicus.remote.service

import com.challenge.comicus.remote.model.ComicDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Pavel on 07/09/2020.
 **/
interface ComicService {

    @GET("info.0.json")
    fun getLatestComic(): Single<ComicDto>

    @GET("{id}/info.0.json")
    fun getRandomComic(@Path("id") comicId: Int): Single<ComicDto>
}