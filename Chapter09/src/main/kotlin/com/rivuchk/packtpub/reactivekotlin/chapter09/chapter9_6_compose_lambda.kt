package com.rivuchk.packtpub.reactivekotlin.chapter09

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toSingle

fun main(args: Array<String>) {
    Observable.range(1,10)
            .compose<List<Int>> {
                upstream: Observable<Int> ->
                upstream.toList().toObservable()
            }
            .first(listOf())
            .subscribeBy {
                println(it)
            }
}