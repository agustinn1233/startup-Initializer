package com.mercadolibre.dynamic_feature

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import com.mercadolibre.rest_client.RestClientInit

class SecondInitDF : Initializer<SecondInitDF.Dependency> {

    override fun create(context: Context): Dependency {
        Log.d(TAG, "SecondInitDF#create()")
        return Dependency()
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return listOf(FirstInitDF::class.java, RestClientInit::class.java)
    }

    companion object {
        private const val TAG = "SecondInitDF"
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
