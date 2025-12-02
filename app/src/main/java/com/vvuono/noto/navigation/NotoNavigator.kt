package com.vvuono.noto.navigation

import android.net.Uri

interface NotoNavigator {
    fun popBackStack()
    fun navigateToGallery()
    fun navigateToCreateNoto()
    fun navigateToViewNoto(notoPhotoUri: Uri)
}
