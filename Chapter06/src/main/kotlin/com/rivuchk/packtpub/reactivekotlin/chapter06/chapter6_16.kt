package com.rivuchk.packtpub.reactivekotlin.chapter06

import io.reactivex.Observable
import java.util.*
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    Observable.range(1,10)
            .switchMap {
                val randDelay = Random().nextInt(10)
                if(it%3 == 0)
                    Observable.just(it)
                else
                    Observable.just(it)
                            .delay(randDelay.toLong(), TimeUnit.MILLISECONDS)
            }
            .blockingSubscribe {
                println("Received $it")
            }
}