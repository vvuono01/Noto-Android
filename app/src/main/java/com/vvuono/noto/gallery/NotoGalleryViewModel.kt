package com.vvuono.noto.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vvuono.noto.utils.lifecycle.emit
import kotlinx.coroutines.launch

class NotoGalleryViewModel : ViewModel() {
    private val _newNotoButtonClicked = MutableLiveData<Unit>()
    val newNotoButtonClicked: LiveData<Unit> = _newNotoButtonClicked

    fun onNewNotoButtonClicked() {
        viewModelScope.launch {
            _newNotoButtonClicked.emit()
        }
    }
}