package com.rivuchk.packtpub.reactivekotlin.chapter03

import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.toObservable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit

/**
 * Created by rivuc on 22-07-2017.
 */

fun main(args: Array<String>) {
    val connectableObservable = Observable.interval(100,TimeUnit.MILLISECONDS)
            .publish()//1
    connectableObservable.
            subscribe({ println("Subscription 1: $it") })//2
    connectableObservable
            .subscribe({ println("Subscription 2 $it")})//3
    connectableObservable.connect()//4
    runBlocking { delay(500) }//5

    connectableObservable.
            subscribe({ println("Subscription 3: $it") })//6
    runBlocking { delay(500) }//7
}