package com.vvuono.noto.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vvuono.noto.gallery.NewNotoButton
import com.vvuono.noto.gallery.NotoGalleryViewModel
import com.vvuono.noto.navigation.NotoNavHost

@Composable
fun NotoApp(
    galleryViewModel: NotoGalleryViewModel,
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        floatingActionButton = {
            // TODO: Check this conditionally depending on screen
            NewNotoButton(galleryViewModel)
        }
    ) { innerPadding ->
        NotoNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
        )
    }
}