package com.rivuchk.packtpub.reactivekotlin.chapter11

import reactor.core.publisher.Flux
import java.util.function.Consumer

fun main(args: Array<String>) {
    val flux = Flux.just("Item 1","Item 2","Item 3")
    flux.subscribe(object:Consumer<String>{
        override fun accept(item: String) {
            println("Got Next $item")
        }

    })
}