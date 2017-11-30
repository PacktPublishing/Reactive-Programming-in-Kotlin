package com.rivuchk.packtpub.reactivekotlin.chapter04

import io.reactivex.Flowable
import org.reactivestreams.Subscriber

fun main(args: Array<String>) {
    val flowable = Flowable.range(1,111)
    flowable.buffer(10,15)//(1)
            .subscribe { println("Subscription 1 $it") }

    flowable.buffer(15,7)//(2)
            .subscribe { println("Subscription 2 $it") }
}