package com.rivuchk.packtpub.reactivekotlin.chapter06

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

fun main(args: Array<String>) {
    Observable.just(1,2,3,4,5)
            .map { it/(3-it) }
            .retry(3)//(1)
            .subscribeBy (
                    onNext  = {println("Received $it")},
                    onError = {println("Error")}
            )
    println("\n With Predicate \n")
    var retryCount = 0
    Observable.just(1,2,3,4,5)
            .map { it/(3-it) }
            .retry {//(2)
                _, _->
                (++retryCount)<3
            }
            .subscribeBy (
                    onNext  = {println("Received $it")},
                    onError = {println("Error")}
            )
}