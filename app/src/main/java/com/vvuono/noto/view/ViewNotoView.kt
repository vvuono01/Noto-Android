package com.vvuono.noto.view

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ViewNotoView() {
    val viewModel: ViewNotoViewModel = hiltViewModel()
    val notoPhotoUri by viewModel.notoPhotoUri.collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        // TODO: Display image
    }
}