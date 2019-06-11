package com.streetography.stphotomap.examples.extensions.router

import android.app.Activity
import android.content.Context
import android.content.Intent

object ActivityRouter {
    inline fun <reified T: Activity> start(context: Context) {
        val intent = Intent(context, T::class.java)
        context.startActivity(intent)
    }
}