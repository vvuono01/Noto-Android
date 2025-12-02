package com.vvuono.noto.data.ui

import kotlinx.serialization.Serializable

sealed class NotoScreen() : java.io.Serializable {
    @Serializable class Gallery() : NotoScreen()
    @Serializable class CreateNoto() : NotoScreen()
    @Serializable class ViewNoto() : NotoScreen()
}