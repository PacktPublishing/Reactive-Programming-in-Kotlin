package com.rivuchk.packtpub.reactivekotlin.chapter03

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit


/**
 * Created by rivuc on 22-07-2017.
 */

fun main(args: Array<String>) {
    val observer: Observer<Any> = object : Observer<Any> {
        override fun onComplete() {
            println("All Completed")
        }

        override fun onNext(item: Any) {
            println("Next $item")
        }

        override fun onError(e: Throwable) {
            println("Error Occured ${e.message}")
        }

        override fun onSubscribe(d: Disposable) {
            println("New Subscription ")
        }
    }//Create Observer

    Observable.range(1,10).subscribe(observer)//(1)
    Observable.empty<String>().subscribe(observer)//(2)

    runBlocking {

        Observable.interval(300,TimeUnit.MILLISECONDS).subscribe(observer)//(3)
        delay(900)
        val subscription = Observable.timer(400,TimeUnit.MILLISECONDS).subscribe(observer)//(4)
        delay(450)
    }

}