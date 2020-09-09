package com.challenge.comicus.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Pavel on 07/09/2020.
 **/

@Entity(tableName = "comic")
data class ComicEntity(
    @PrimaryKey
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