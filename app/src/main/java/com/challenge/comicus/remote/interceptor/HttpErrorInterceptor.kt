package com.challenge.comicus.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import java.net.HttpURLConnection

/**
 * Created by Pavel on 03/09/2020.
 **/

class HttpErrorInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        if (response.isSuccessful) {
            return response
        } else {
            if (response.code == HttpURLConnection.HTTP_BAD_REQUEST) {
                throw BadRequestException(response.body?.string())
            } else {
                throw HttpException(response.message)
            } // add any exception to handle
        }
    }
}

open class BaseThrowable(message: String? = null, cause: Throwable? = null) : Throwable(message, cause)

class BadRequestException(message: String? = null) : BaseThrowable(message)
class HttpException(message: String): Throwable(message)