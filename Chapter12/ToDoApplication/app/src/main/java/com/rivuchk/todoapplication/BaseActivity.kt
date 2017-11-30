package com.rivuchk.todoapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

abstract class BaseActivity : AppCompatActivity() {

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateBaseActivity(savedInstanceState)
    }

    abstract fun onCreateBaseActivity(savedInstanceState: Bundle?)

}
