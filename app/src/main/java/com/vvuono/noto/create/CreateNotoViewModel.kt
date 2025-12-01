package com.vvuono.noto.create

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModel
import com.vvuono.noto.utils.content.createNotoImageFile
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CreateNotoViewModel @Inject constructor(
    @ApplicationContext private val appContext: Context,
) : ViewModel() {
    private val _newNotoUri = MutableStateFlow(Uri.EMPTY)
    val newNotoUri: StateFlow<Uri> = _newNotoUri.asStateFlow()

    fun createNewNotoUri() {
        val photoFile = appContext.createNotoImageFile()
        _newNotoUri.value = FileProvider.getUriForFile(
            appContext,
            "${appContext.packageName}.fileprovider",
            photoFile,
        )
    }
}