package com.rivuchk.packtpub.reactivekotlin.chapter05

import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    println("default with integer")
    listOf(2,6,7,1,3,4,5,8,10,9)
            .toObservable()
            .sorted()//(1)
            .subscribe { println("Received $it") }

    println("default with String")
    listOf("alpha","gamma","beta","theta")
            .toObservable()
            .sorted()//(2)
            .subscribe { println("Received $it") }

    println("custom sortFunction with integer")
    listOf(2,6,7,1,3,4,5,8,10,9)
            .toObservable()
            .sorted { item1, item2 -> if(item1>item2) -1 else 1 }//(3)
            .subscribe { println("Received $it") }

    println("custom sortFunction with custom class-object")
    listOf(MyItem1(2),MyItem1(6),
            MyItem1(7),MyItem1(1),MyItem1(3),
            MyItem1(4),MyItem1(5),MyItem1(8),
            MyItem1(10),MyItem1(9))
            .toObservable()
            .sorted { item1, item2 -> if(item1.item<item2.item) -1 else 1 }//(4)
            .subscribe { println("Received $it") }
}

data class MyItem1(val item:Int)