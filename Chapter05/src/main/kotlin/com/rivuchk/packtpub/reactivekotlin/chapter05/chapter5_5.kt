package com.rivuchk.packtpub.reactivekotlin.chapter05

import io.reactivex.Observable


fun main(args: Array<String>) {
    Observable.range(1,20)//(1)
            .filter{//(2)
                it%2==0
            }
            .subscribe {
                println("Received $it")
            }
}