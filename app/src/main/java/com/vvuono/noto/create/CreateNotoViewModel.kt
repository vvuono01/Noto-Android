package com.vvuono.noto.create

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModel
import com.vvuono.noto.utils.content.createNotoImageFile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CreateNotoViewModel : ViewModel() {
    private val _newNotoUri = MutableStateFlow(Uri.EMPTY)
    val newNotoUri: StateFlow<Uri> = _newNotoUri.asStateFlow()

    fun createNewNotoUri(context: Context) {
        val photoFile = context.createNotoImageFile()
        _newNotoUri.value = FileProvider.getUriForFile(
            context,
            "${context.packageName}.fileprovider",
            photoFile,
        )
    }
}