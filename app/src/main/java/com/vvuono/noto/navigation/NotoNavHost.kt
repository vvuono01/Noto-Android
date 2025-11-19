package com.vvuono.noto.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vvuono.noto.data.ui.NotoScreen
import com.vvuono.noto.gallery.NotoGalleryView

@Composable
fun NotoNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NotoScreen.Gallery.name,
        modifier = modifier,
    ) {
        composable(route = NotoScreen.Gallery.name) {
            NotoGalleryView()
        }
    }
}