package com.rivuchk.packtpub.reactivekotlin.chapter03

import io.reactivex.rxkotlin.toObservable


fun main(args: Array<String>) {
    val connectableObservable = listOf("String 1","String 2","String 3","String 4","String 5").toObservable()
            .publish()//1
    connectableObservable.
            subscribe({ println("Subscription 1: $it") })//2
    connectableObservable.map(String::reversed)//3
            .subscribe({ println("Subscription 2 $it")})//4
    connectableObservable.connect()//5

    connectableObservable.
            subscribe({ println("Subscription 3: $it") })//6 //Will never get called
}