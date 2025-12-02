package com.vvuono.noto.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun ViewNotoView() {
    val viewModel: ViewNotoViewModel = hiltViewModel()
    val notoPhotoUri by viewModel.notoPhotoUri.collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        val context = LocalContext.current
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(notoPhotoUri)
                .build(),
            contentDescription = "Noto",
            modifier = Modifier.fillMaxSize()
        )
    }
}