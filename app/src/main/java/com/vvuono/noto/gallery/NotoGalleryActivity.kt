package com.vvuono.noto.gallery

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels

class NotoGalleryActivity : ComponentActivity() {
    private val viewModel: NotoGalleryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotoGalleryView(viewModel)
        }

        viewModel.newNotoButtonClicked.observe(this) { navigateToNewNotoScreen() }
    }

    private fun navigateToNewNotoScreen() {
        // TODO: Navigate
        Toast.makeText(this, "Make a new Noto!", Toast.LENGTH_SHORT).show()
    }
}
