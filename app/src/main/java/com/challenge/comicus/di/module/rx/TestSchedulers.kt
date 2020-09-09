package com.challenge.comicus.di.module.rx

import com.challenge.comicus.remote.rx.RxSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Pavel on 09/09/2020.
 **/

open class TestSchedulers : RxSchedulers(
    Schedulers.trampoline(),
    Schedulers.trampoline()
)

