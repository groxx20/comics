package com.challenge.comicus.remote.rx

import io.reactivex.schedulers.Schedulers

/**
 * Created by Pavel on 09/09/2020.
 **/

open class TestSchedulers : RxSchedulers(
    Schedulers.trampoline(),
    Schedulers.trampoline()
)

