package com.challenge.comicus.remote.mapper

/**
 * Created by Pavel on 07/09/2020.
 **/

interface FromRemoteMapper<in From, out To> {
    fun mapFromRemote(dto: From): To
}