package com.vvuono.noto.data.ui

import kotlinx.serialization.Serializable

sealed class NotoScreen() : java.io.Serializable {
    @Serializable class Gallery() : NotoScreen()
    @Serializable class CreateNoto() : NotoScreen()
    @Serializable data class ViewNoto(val notoPhotoUri: String) : NotoScreen()
}