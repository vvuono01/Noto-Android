package com.vvuono.noto.navigation

import android.net.Uri
import androidx.navigation.NavHostController
import com.vvuono.noto.data.ui.NotoScreen

class NotoNavigatorImpl(
    private val navController: NavHostController,
) : NotoNavigator {
    override fun popBackStack() {
        navController.popBackStack()
    }

    override fun navigateToGallery() {
        navController.navigate(NotoScreen.Gallery())
    }

    override fun navigateToCreateNoto() {
        navController.navigate(NotoScreen.CreateNoto())
    }

    override fun navigateToViewNoto(notoPhotoUri: Uri) {
        navController.navigate(NotoScreen.ViewNoto(notoPhotoUri.toString())) {
            popUpTo(NotoScreen.Gallery()) {
                inclusive = false
            }
        }
    }
}
