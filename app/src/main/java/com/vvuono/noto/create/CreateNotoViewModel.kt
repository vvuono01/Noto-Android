package com.vvuono.noto.create

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vvuono.noto.data.exceptions.CreateNotoImageCaptureFailure
import com.vvuono.noto.utils.content.createNotoImageFile
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class CreateNotoViewModel @Inject constructor(
    @ApplicationContext private val appContext: Context,
) : ViewModel() {
    private val _newNotoUri = MutableStateFlow(Uri.EMPTY)
    private val _capturedNotoUri = MutableStateFlow(Uri.EMPTY)
    private val _capturedNotoError: MutableStateFlow<Exception?> = MutableStateFlow(null)

    val captureNotoImageStatus: StateFlow<CaptureNotoImageStatus> =
        combine(
            _newNotoUri,
            _capturedNotoUri,
            _capturedNotoError,
        ) { newUri, capturedUri, error ->
            if (error != null) {
                CaptureNotoImageStatus.Failure(error)
            } else if (capturedUri != Uri.EMPTY) {
                CaptureNotoImageStatus.Success(capturedUri)
            } else {
                CaptureNotoImageStatus.Pending(newUri)
            }
        }.stateIn(
            scope = viewModelScope,
            started = kotlinx.coroutines.flow.SharingStarted.WhileSubscribed(500),
            initialValue = CaptureNotoImageStatus.Initial
        )

    fun createNewNotoUri() {
        val photoFile = appContext.createNotoImageFile()
        _newNotoUri.value = FileProvider.getUriForFile(
            appContext,
            "${appContext.packageName}.fileprovider",
            photoFile,
        )
    }

    fun onNotoImageCaptured(uri: Uri) {
        _capturedNotoUri.value = uri
    }

    fun onNotoImageCaptureFailure(exception: Exception? = null) {
        _capturedNotoError.value = exception ?: CreateNotoImageCaptureFailure()
    }
}

sealed class CaptureNotoImageStatus() {
    object Initial : CaptureNotoImageStatus()
    data class Pending(val uri: Uri): CaptureNotoImageStatus()
    data class Success(val uri: Uri) : CaptureNotoImageStatus()
    data class Failure(val error: Throwable) : CaptureNotoImageStatus()
}