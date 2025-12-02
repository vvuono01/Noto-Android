package com.vvuono.noto.view

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ViewNotoViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _notoPhotoUri = MutableStateFlow(Uri.parse(savedStateHandle.get<String>("notoPhotoUri")!!))
    val notoPhotoUri = _notoPhotoUri.asStateFlow()
}