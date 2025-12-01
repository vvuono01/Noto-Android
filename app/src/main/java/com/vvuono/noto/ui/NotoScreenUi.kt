package com.vvuono.noto.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vvuono.noto.create.CreateNotoViewModel
import com.vvuono.noto.gallery.NotoGalleryViewModel
import com.vvuono.noto.navigation.NotoNavHost

@Composable
fun NotoApp(
    galleryViewModel: NotoGalleryViewModel = viewModel(),
    createNotoViewModel: CreateNotoViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold { innerPadding ->
        NotoNavHost(
            navController = navController,
            createNotoViewModel = createNotoViewModel,
            modifier = Modifier.padding(innerPadding),
        )
    }
}