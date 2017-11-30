package com.rivuchk.packtpub.reactivekotlin.chapter09

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) {
    Observable.range(1,10)
            .map {
                println("map - ${Thread.currentThread().name} $it")
                it
            }
            .subscribeOn(Schedulers.computation())
            .observeOn(Schedulers.io())
            .subscribe {
                println("onNext - ${Thread.currentThread().name} $it")
            }

    runBlocking { delay(100) }
}