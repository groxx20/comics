package com.challenge.comicus.data.mapper

/**
 * Created by Pavel on 07/09/2020.
 **/
interface FromDbMapper<in From, out To> {
    fun mapFromDb(entity: From): To
}