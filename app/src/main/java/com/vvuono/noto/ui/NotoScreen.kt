package com.vvuono.noto.ui

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.vvuono.noto.gallery.NewNotoButton
import com.vvuono.noto.gallery.NotoGalleryView
import com.vvuono.noto.gallery.NotoGalleryViewModel

@Composable
fun NotoApp(
    galleryViewModel: NotoGalleryViewModel,
) {
    Scaffold(
        floatingActionButton = {
            // TODO: Check this conditionally depending on screen
            NewNotoButton(galleryViewModel)
        }
    ) { innerPadding ->
        // TODO: Check this conditionally depending on screen
        NotoGalleryView(innerPadding)
    }
}