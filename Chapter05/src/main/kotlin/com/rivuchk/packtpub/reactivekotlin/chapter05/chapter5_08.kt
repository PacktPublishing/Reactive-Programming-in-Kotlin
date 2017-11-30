package com.rivuchk.packtpub.reactivekotlin.chapter05

import io.reactivex.Observable
import io.reactivex.rxkotlin.cast
import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    val list = listOf<MyItemInherit>(
            MyItemInherit(1),
            MyItemInherit(2),
            MyItemInherit(3),
            MyItemInherit(4),
            MyItemInherit(5),
            MyItemInherit(6),
            MyItemInherit(7),
            MyItemInherit(8),
            MyItemInherit(9),
            MyItemInherit(10)
    )//(1)

    list.toObservable()//(2)
            .map { it as MyItem }//(3)
            .subscribe {
                println(it)
            }

    println("cast")

    list.toObservable()
            .cast(MyItem::class.java)//(4)
            .subscribe {
                println(it)
            }
}

open class MyItem(val id:Int) {//(5)
    override fun toString(): String {
        return "[MyItem $id]"
    }
}

class MyItemInherit(id:Int):MyItem(id) {//(6)
    override fun toString(): String {
        return "[MyItemInherit $id]"
    }
}