package com.rivuchk.packtpub.reactivekotlin.chapter06

import org.apache.http.impl.nio.client.HttpAsyncClients
import rx.apache.http.ObservableHttp

fun main(args: Array<String>) {
    val httpClient = HttpAsyncClients.createDefault()//(1)
    httpClient.start()//(2)
    ObservableHttp.createGet("http://rivuchk.com/feed/json", httpClient).toObservable()//(3)
            .flatMap{ response ->
                response.content.map{ bytes ->
                    String(bytes)
                }//(4)
            }
            .onErrorReturn {//(5)
                "Error Parsing data "
            }
            .subscribe {
                println(it)//(6)
                httpClient.close()//(7)
            }
}