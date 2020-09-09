package com.challenge.comicus.ui.base.model

/**
 * Created by Pavel on 07/09/2020.
 **/
data class ComicUi(
    val comicNumber: Int,
    val day:Int,
    val month:Int,
    val year: Int,
    val link: String,
    val news: String,
    val alt: String,
    val imgLink: String,
    val title: String,
    val safeTitle: String,
    val transcript: String,
    var favorite: Boolean
)
