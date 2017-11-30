package com.rivuchk.packtpub.reactivekotlin.chapter06

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val observable1 = Observable.interval(100,TimeUnit.MILLISECONDS)//(1)
    val observable2 = Observable.interval(250,TimeUnit.MILLISECONDS)//(2)

    Observable.zip(observable1,observable2,
            BiFunction { t1:Long, t2:Long -> "t1: $t1, t2: $t2" })//(3)
            .subscribe{
                println("Received $it")
            }

    runBlocking { delay(1100) }
}