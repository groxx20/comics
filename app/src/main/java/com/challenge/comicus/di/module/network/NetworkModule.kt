package com.challenge.comicus.di.module.network

import com.challenge.comicus.BuildConfig
import com.challenge.comicus.remote.interceptor.HttpErrorInterceptor
import com.challenge.comicus.remote.interceptor.HttpRequestInterceptor
import com.challenge.comicus.remote.service.ComicService
import com.challenge.comicus.utils.constants.ComicAppConstants.DEFAULT_TIMEOUT
import com.challenge.comicus.utils.constants.ComicAppConstants.FULL_DATE_TIME_FORMAT
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Pavel on 03/09/2020.
 **/

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpErrorInterceptor() = HttpErrorInterceptor()

    @Provides
    @Singleton
    fun provideRequestInterceptor() = HttpRequestInterceptor()

    @Provides
    @Singleton
    fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG)
                level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        errorInterceptor: HttpErrorInterceptor,
        requestInterceptor: HttpRequestInterceptor,
        loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient().newBuilder()
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(errorInterceptor)
            .addInterceptor(requestInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideGson(): Gson =
        GsonBuilder()
            .setDateFormat(FULL_DATE_TIME_FORMAT)
            .create()

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
        gson: Gson
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()

    @Provides
    @Singleton
    fun provideComicService(retrofit: Retrofit): ComicService =
        retrofit.create(ComicService::class.java)
}