package com.rivuchk.packtpub.reactivekotlin.chapter7

import io.reactivex.Observable
import io.reactivex.rxkotlin.zipWith
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    Observable.range(1,10)
            .subscribe {
                runBlocking { delay(200) }
                println("Observable1 Item Received $it")
            }

    Observable.range(21,10)
            .subscribe {
                runBlocking { delay(100) }
                println("Observable2 Item Received $it")
            }
}