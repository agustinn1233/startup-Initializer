package com.mercadolibre.rest_client

import android.content.Context
import android.util.Log
import androidx.startup.Initializer

class RestClientInit : Initializer<RestClientInit.Dependency> {

    override fun create(context: Context): Dependency {
        Log.d(TAG, "RestClientInit#create()")
        return Dependency()
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }

    companion object {
        private const val TAG = "RestClientInit"
    }

    class Dependency {
        init {
            isInitialized = true
        }

        companion object {
            var isInitialized = false
        }
    }
}
