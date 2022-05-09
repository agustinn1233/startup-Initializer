package com.mercadolibre.startup_initializer

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.startup.AppInitializer
import com.mercadolibre.rest_client.RestClientInit
import com.mercadolibre.rest_client.RestClientDownloadInit
import com.mercadolibre.dynamic_feature.FirstInitDF
import com.mercadolibre.dynamic_feature.SecondInitDF
import com.mercadolibre.dynamic_feature.ThirdInitDF


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val autoInit = findViewById<TextView>(R.id.automaticInitialization)
        val manualInit = findViewById<TextView>(R.id.manualInitialization)
        val initButton = findViewById<TextView>(R.id.performManualInitialization)

        // Automatic initialization
        if (isAutomaticInitializationDone()) {
            autoInit.setText(R.string.automatic_initialization_done)
        } else {
            autoInit.setText(R.string.automatic_initialization_not_done)
        }

        // Manual initialization
        if (isManualInitializationDone()) {
            manualInit.setText(R.string.manual_initialization_done)
        } else {
            manualInit.setText(R.string.manual_initialization_not_done)
        }

        // Manual initialization by button
        initButton.setOnClickListener {
            AppInitializer.getInstance(applicationContext)
                .initializeComponent(RestClientDownloadInit::class.java)
        }
    }

    private fun isAutomaticInitializationDone(): Boolean =
        RestClientInit.Dependency.isInitialized && FirstInitDF.Dependency.isInitialized
                && SecondInitDF.Dependency.isInitialized && ThirdInitDF.Dependency.isInitialized

    private fun isManualInitializationDone(): Boolean =
        RestClientDownloadInit.Dependency.isInitialized
}
