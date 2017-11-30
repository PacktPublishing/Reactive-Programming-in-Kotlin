package com.rivuchk.packtpub.reactivekotlin.chapter06

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val observable1 = Observable.interval(100, TimeUnit.MILLISECONDS)

    val observable2 = Observable.timer(500,TimeUnit.MILLISECONDS)//(1)

    observable1
            .skipUntil(observable2)//(2)
            .subscribe(
                    object: Observer<Long> {
                        override fun onError(e: Throwable) {
                            println("Error $e")
                        }

                        override fun onComplete() {
                            println("Complete")
                        }

                        override fun onNext(t: Long) {
                            println("Received $t")
                        }

                        override fun onSubscribe(d: Disposable) {
                            println("starting skipUntil")
                        }

                    }
            )

    runBlocking { delay(1500) }
}