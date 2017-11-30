package com.rivuchk.packtpub.reactivekotlin.chapter07

import io.reactivex.Observable

/**
 * Created by Rivu Chakraborty on 11-07-2017.
 */

inline fun Int.isEven():Boolean = (this%2)==0
infix inline fun Sequence<Any>.join(delimeter:String):String {
    var retString = ""
    this.forEach {
        retString+= "$it${delimeter.trim()} "
    }
    return retString.substring(0,retString.lastIndexOf(delimeter)).trim()
}

inline fun Any.toIntOrError():Int = toString().toInt()
