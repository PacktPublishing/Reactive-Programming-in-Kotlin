package com.rivuchk.packtpub.reactivekotlin.chapter03

import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.toObservable

/**
 * Created by rivuc on 22-07-2017.
 */

fun main(args: Array<String>) {

    val observer: Observer<Any> = object :Observer<Any>{//1
        override fun onComplete() {//2
            println("All Completed")
        }

        override fun onNext(item: Any) {//3
            println("Next $item")
        }

        override fun onError(e: Throwable) {//4
            println("Error Occured $e")
        }

        override fun onSubscribe(d: Disposable) {//5
            println("Subscribed to $d")
        }
    }

    val observable: io.reactivex.Observable<Any> = listOf("One", 2, "Three", "Four", 4.5, "Five", 6.0f).toObservable() //6

    observable.subscribe(observer)//7

    val observableOnList: io.reactivex.Observable<List<Any>> = io.reactivex.Observable.just(listOf("One", 2, "Three", "Four", 4.5, "Five", 6.0f),
            listOf("List with Single Item"),
            listOf(1,2,3,4,5,6))//8



    observableOnList.subscribe(observer)//9


}