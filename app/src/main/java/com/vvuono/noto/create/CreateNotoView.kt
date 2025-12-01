package com.vvuono.noto.create

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun CreateNotoView(
    viewModel: CreateNotoViewModel,
) {
    val captureImageStatus by viewModel.captureNotoImageStatus.collectAsStateWithLifecycle()
    val takePictureLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
        onResult = { success ->
            if (success) {
                (captureImageStatus as? CaptureNotoImageStatus.Pending)?.let {
                    viewModel.onNotoImageCaptured(it.uri)
                } ?: viewModel.onNotoImageCaptureFailure(
                    IllegalStateException(
                        "captureImageStatus is in incorrect state ($captureImageStatus); can't extract URI"
                    )
                )
            } else {
                viewModel.onNotoImageCaptureFailure()
            }
        }
    )

    LaunchedEffect(captureImageStatus) {
        when (val status = captureImageStatus) {
            is CaptureNotoImageStatus.Initial -> viewModel.createNewNotoUri()
            is CaptureNotoImageStatus.Pending -> takePictureLauncher.launch(status.uri)
            is CaptureNotoImageStatus.Success -> {
                // TODO: Navigate to ViewNotoView with the saved image
            }
            is CaptureNotoImageStatus.Failure -> {
                // TODO: Handle failed image capture
            }
        }
    }
}