package com.challenge.comicus.di.module.rx

import com.challenge.comicus.remote.rx.RxSchedulers
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Pavel on 09/09/2020.
 **/

@Module
object RxSchedulersModule {

    @JvmStatic
    @Provides
    @Named("dbScheduler")
    internal fun provideDbScheduler(): Scheduler {
        return Schedulers.single()
    }

    @JvmStatic
    @Provides
    @Named("networkScheduler")
    internal fun provideNetworkScheduler(): Scheduler {
        return Schedulers.io()
    }

    @JvmStatic
    @Provides
    @Singleton
    internal fun provideRxSchedulers(
        @Named("dbScheduler") dbIO: Scheduler,
        @Named("networkScheduler") networkIO: Scheduler
    ): RxSchedulers {
        return RxSchedulers(dbIO, networkIO)
    }
}