package com.rivuchk.packtpub.reactivekotlin.chapter04

import io.reactivex.schedulers.Schedulers
import io.reactivex.Flowable
import io.reactivex.processors.PublishProcessor
import io.reactivex.rxkotlin.toFlowable
import io.reactivex.rxkotlin.toObservable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import org.reactivestreams.Processor

fun main(args: Array<String>) {
    val flowable = listOf("String 1","String 2","String 3","String 4","String 5").toFlowable()//(1)

    val processor = PublishProcessor.create<String>()//(2)

    processor.//(3)
            subscribe({
                println("Subscription 1: $it")
                runBlocking { delay(1000) }
                println("Subscription 1 delay")
            })
    processor//(4)
            .subscribe({ println("Subscription 2 $it")})

    flowable.subscribe(processor)//(5)

}
