package com.rivuchk.packtpub.reactivekotlin.chapter01

import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable


/**
 * Created by Rivu Chakraborty on 7/3/2017.
 */

fun main(args: Array<String>) {
    var list:List<Any> = listOf("One", 2, "Three", "Four", 4.5, "Five", 6.0f)
    var observable: io.reactivex.Observable<Any> = list.toObservable(); //1

    observable.subscribeBy(  // 2 named arguments for lambda Subscribers
            onNext = { println(it) },
            onError =  { it.printStackTrace() },
            onComplete = { println("Done!") }
    )

}