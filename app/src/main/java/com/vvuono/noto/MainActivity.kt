package com.vvuono.noto

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.vvuono.noto.gallery.NotoGalleryViewModel
import com.vvuono.noto.ui.NotoApp
import com.vvuono.noto.ui.theme.NotoTheme
import kotlin.getValue

class MainActivity : ComponentActivity() {
    private val galleryViewModel: NotoGalleryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotoTheme {
                NotoApp(
                    galleryViewModel,
                )
            }
        }

        galleryViewModel.newNotoButtonClicked.observe(this) { navigateToNewNotoScreen() }
    }

    private fun navigateToNewNotoScreen() {
        // TODO: Navigate
        Toast.makeText(this, "Make a new Noto!", Toast.LENGTH_SHORT).show()
    }
}
