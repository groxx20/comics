package com.challenge.comicus.remote.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Pavel on 07/09/2020.
 **/
data class ComicDto(
    @SerializedName("month")
    val month: Int,
    @SerializedName("num")
    val num: Int,
    @SerializedName("link")
    val link: String,
    @SerializedName("year")
    val year: Int,
    @SerializedName("news")
    val news: String,
    @SerializedName("safe_title")
    val safeTitle: String,
    @SerializedName("transcript")
    val transcript: String,
    @SerializedName("alt")
    val alt: String,
    @SerializedName("img")
    val img: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("day")
    val day: Int
)