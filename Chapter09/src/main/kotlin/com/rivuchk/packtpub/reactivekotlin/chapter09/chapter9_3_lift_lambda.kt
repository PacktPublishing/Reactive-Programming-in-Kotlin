package com.rivuchk.packtpub.reactivekotlin.chapter09

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import java.util.concurrent.atomic.AtomicInteger

fun main(args: Array<String>) {
    listOf("Reactive","Programming","in","Kotlin","by Rivu Chakraborty","Packt")
            .toObservable()
            .lift<Pair<Int,String>> {
                observer ->
                val counter = AtomicInteger()
                object :Observer<String> {
                    override fun onSubscribe(d: Disposable) {
                        observer.onSubscribe(d)
                    }

                    override fun onNext(t: String) {
                        observer.onNext(Pair(counter.incrementAndGet(), t))
                    }

                    override fun onComplete() {
                        observer.onComplete()
                    }

                    override fun onError(e: Throwable) {
                        observer.onError(e)
                    }

                }
            }
            .subscribeBy (
                    onNext = {
                        println("Next $it")
                    },
                    onError = {
                        it.printStackTrace()
                    },
                    onComplete = {
                        println("Completed")
                    }
            )
}