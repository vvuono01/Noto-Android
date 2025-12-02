package com.vvuono.noto.create

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.vvuono.noto.R
import com.vvuono.noto.navigation.NotoNavigator

@Composable
fun CreateNotoView(
    navigator: NotoNavigator,
    viewModel: CreateNotoViewModel = hiltViewModel(),
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

    val context = LocalContext.current
    LaunchedEffect(captureImageStatus) {
        when (val status = captureImageStatus) {
            is CaptureNotoImageStatus.Initial -> viewModel.createNewNotoUri()
            is CaptureNotoImageStatus.Pending -> takePictureLauncher.launch(status.uri)
            is CaptureNotoImageStatus.Success -> navigator.navigateToViewNoto()
            is CaptureNotoImageStatus.Failure -> {
                Toast.makeText(
                    context,
                    R.string.create_noto_image_capture_failed,
                    Toast.LENGTH_SHORT,
                ).show()
                navigator.popBackStack()
            }
        }
    }
}