package com.challenge.comicus.ui.base.mapper

/**
 * Created by Pavel on 07/09/2020.
 **/

interface UiMapper<in From, out To> {
    fun mapFromData(data: From): To
}