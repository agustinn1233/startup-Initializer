package com.mercadolibre.dynamic_feature

import android.content.Context
import android.util.Log
import androidx.startup.Initializer

class ThirdInitDF : Initializer<ThirdInitDF.Dependency> {

    override fun create(context: Context): Dependency {
        Log.d(TAG, "ThirdInitDF#create()")
        return Dependency()
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return listOf(SecondInitDF::class.java)
    }

    companion object {
        private const val TAG = "ThirdInitDF"
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
