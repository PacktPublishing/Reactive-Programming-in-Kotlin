package com.rivuchk.packtpub.reactivekotlin.chapter04

import io.reactivex.Flowable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import org.reactivestreams.Subscriber
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val boundaryFlowable = Flowable.interval(350, TimeUnit.MILLISECONDS)

    val flowable = Flowable.interval(100, TimeUnit.MILLISECONDS)//(1)
    flowable.buffer(boundaryFlowable)//(2)
            .subscribe { println(it) }

    runBlocking { delay(5, TimeUnit.SECONDS) }//(3)

}
