package com.rivuchk.todoapplication

import android.app.Application

/**
 * Created by Rivu on 30-10-2017.
 */
class ToDoApp:Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        var instance:ToDoApp? = null
    }
}