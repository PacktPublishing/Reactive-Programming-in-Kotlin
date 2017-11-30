package com.rivuchk.packtpub.reactivekotlin.chapter06

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val observable1 = Observable.range(1,20)
    observable1
            .take(5)//(1)
            .subscribe(object:Observer<Int> {
                override fun onError(e: Throwable) {
                    println("Error $e")
                }

                override fun onComplete() {
                    println("Complete")
                }

                override fun onNext(t: Int) {
                    println("Received $t")
                }

                override fun onSubscribe(d: Disposable) {
                    println("starting skip(count)")
                }

            })

    val observable2 = Observable.interval(100,TimeUnit.MILLISECONDS)
    observable2
            .take(400,TimeUnit.MILLISECONDS)//(2)
            .subscribe(
                    object:Observer<Long> {
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
                            println("starting skip(time)")
                        }

                    }
            )

    runBlocking {
        delay(1000)
    }

}