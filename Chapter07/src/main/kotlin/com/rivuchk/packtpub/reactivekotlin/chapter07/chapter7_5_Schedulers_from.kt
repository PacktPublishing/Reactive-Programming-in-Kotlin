package com.rivuchk.packtpub.reactivekotlin.chapter7

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.Executor
import java.util.concurrent.Executors

fun main(args: Array<String>) {

    val executor:Executor = Executors.newFixedThreadPool(2)//(1)
    val scheduler:Scheduler = Schedulers.from(executor)//(2)

    Observable.range(1, 10)
            .subscribeOn(scheduler)//(3)
            .subscribe {
                runBlocking { delay(200) }
                println("Observable1 Item Received $it - ${Thread.currentThread().name}")
            }

    Observable.range(21, 10)
            .subscribeOn(scheduler)//(4)
            .subscribe {
                runBlocking { delay(100) }
                println("Observable2 Item Received $it - ${Thread.currentThread().name}")
            }

    Observable.range(51, 10)
            .subscribeOn(scheduler)//(4)
            .subscribe {
                runBlocking { delay(100) }
                println("Observable3 Item Received $it - ${Thread.currentThread().name}")
            }
    runBlocking { delay(10000) }//(5)
}