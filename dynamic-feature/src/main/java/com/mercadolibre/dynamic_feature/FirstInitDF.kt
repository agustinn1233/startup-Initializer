package com.mercadolibre.dynamic_feature

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import com.mercadolibre.rest_client.RestClientInit

class FirstInitDF : Initializer<FirstInitDF.Dependency> {

    override fun create(context: Context): Dependency {
        Log.d(TAG, "FirstInitDF#create()")
        return Dependency()
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return listOf(RestClientInit::class.java)
    }

    companion object {
        private const val TAG = "FirstInitDF"
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
