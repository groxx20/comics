package com.challenge.comicus.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Pavel on 03/09/2020.
 **/

class HttpRequestInterceptor(): Interceptor {

    companion object {
        const val CONTENT_TYPE = "Content-Type"
        const val APPLICATION_FORM_URLENCODED = "application/x-www-form-urlencoded"
        const val GET = "get"
    }

    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest = chain.request()

        val requestBuilder = if (originalRequest.method.toLowerCase() == GET) {
            originalRequest.newBuilder()
        } else {
            originalRequest.newBuilder()
                .header(CONTENT_TYPE, APPLICATION_FORM_URLENCODED)
        }
        return chain.proceed(requestBuilder.build())
    }
}