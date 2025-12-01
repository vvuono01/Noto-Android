package com.vvuono.noto.create

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun CreateNotoView(
    viewModel: CreateNotoViewModel,
) {
    val newNotoUri by viewModel.newNotoUri.collectAsStateWithLifecycle()
    val takePictureLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
        onResult = { success ->
            if (success) {
                // TODO: Navigate to ViewNotoView with the saved image
            } else {
                // TODO: Handle failed image capture
            }
        }
    )

    val context = LocalContext.current
    LaunchedEffect(newNotoUri) {
        if (newNotoUri != Uri.EMPTY) {
            takePictureLauncher.launch(newNotoUri)
        } else {
            viewModel.createNewNotoUri(context)
        }
    }
}