package com.rivuchk.packtpub.reactivekotlin.chapter03

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.concurrent.Callable
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit


/**
 * Created by rivuc on 22-07-2017.
 */

fun main(args: Array<String>) {

    val observer: Observer<String> = object : Observer<String> {
        override fun onComplete() {
            println("All Completed")
        }

        override fun onNext(item: String) {
            println("Next $item")
        }

        override fun onError(e: Throwable) {
            println("Error Occured ${e.message}")
        }

        override fun onSubscribe(d: Disposable) {
            println("New Subscription ")
        }
    }//Create Observer

    val list = listOf("String 1","String 2","String 3","String 4")
    val observableFromIterable: Observable<String> = Observable.fromIterable(list)//1
    observableFromIterable.subscribe(observer)


    val callable = object : Callable<String> {
        override fun call(): String {
            return "From Callable"
        }

    }
    val observableFromCallable:Observable<String> = Observable.fromCallable(callable)//2
    observableFromCallable.subscribe(observer)

    val future:Future<String> = object :Future<String> {
        override fun get(): String = "Hello From Future"

        override fun get(timeout: Long, unit: TimeUnit?): String  = "Hello From Future"

        override fun isDone(): Boolean = true

        override fun isCancelled(): Boolean = false

        override fun cancel(mayInterruptIfRunning: Boolean): Boolean = false

    }
    val observableFromFuture:Observable<String> = Observable.fromFuture(future)//3
    observableFromFuture.subscribe(observer)
}