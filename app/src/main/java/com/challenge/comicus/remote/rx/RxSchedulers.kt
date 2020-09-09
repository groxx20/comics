package com.challenge.comicus.remote.rx

import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Pavel on 09/09/2020.
 **/

@Singleton
open class RxSchedulers
@Inject
constructor(
    @Named("dbScheduler")  val dbIO: Scheduler,
    @Named("networkScheduler") val networkIO: Scheduler
)