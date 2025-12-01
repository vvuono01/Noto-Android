package com.vvuono.noto.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vvuono.noto.create.CreateNotoView
import com.vvuono.noto.create.CreateNotoViewModel
import com.vvuono.noto.data.ui.NotoScreen
import com.vvuono.noto.gallery.NotoGalleryView

private const val TRANSITION_DURATION_MILLIS = 250

@Composable
fun NotoNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NotoScreen.Gallery.name,
        modifier = modifier,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(TRANSITION_DURATION_MILLIS),
            )
        },
        exitTransition = {
            scaleOut(
                targetScale = 0.9f,
                animationSpec = tween(TRANSITION_DURATION_MILLIS),
            )
        },
        popEnterTransition = {
            scaleIn(
                initialScale = 0.9f,
                animationSpec = tween(TRANSITION_DURATION_MILLIS),
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(TRANSITION_DURATION_MILLIS),
            )
        }
    ) {
        composable(route = NotoScreen.Gallery.name) {
            NotoGalleryView(navController)
        }

        composable(route = NotoScreen.CreateNoto.name) {
            val createNotoViewModel = hiltViewModel<CreateNotoViewModel>()
            CreateNotoView(createNotoViewModel)
        }
    }
}