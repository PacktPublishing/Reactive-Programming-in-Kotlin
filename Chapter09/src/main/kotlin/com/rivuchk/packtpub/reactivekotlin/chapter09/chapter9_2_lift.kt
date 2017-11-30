package com.rivuchk.packtpub.reactivekotlin.chapter09

import io.reactivex.Observable
import io.reactivex.ObservableOperator
import io.reactivex.Observer
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import java.util.concurrent.atomic.AtomicInteger

fun main(args: Array<String>) {
    Observable.range(10,20)
            .lift(AddSerialNumber<Int>())
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

class AddSerialNumber<T> : ObservableOperator<Pair<Int,T>,T> {
    val counter:AtomicInteger = AtomicInteger()

    override fun apply(observer: Observer<in Pair<Int, T>>): Observer<in T> {
        return object : Observer<T> {
            override fun onComplete() {
                observer.onComplete()
            }

            override fun onSubscribe(d: Disposable) {
                observer.onSubscribe(d)
            }

            override fun onError(e: Throwable) {
                observer.onError(e)
            }

            override fun onNext(t: T) {
                observer.onNext(Pair(counter.incrementAndGet(),t))
            }

        }
    }
}