package com.vvuono.noto.data.ui

import kotlinx.serialization.Serializable

sealed class NotoScreen(val name: String) {
    @Serializable object Gallery : NotoScreen("gallery")
}