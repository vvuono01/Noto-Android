package com.vvuono.noto.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vvuono.noto.create.CreateNotoView
import com.vvuono.noto.data.ui.NotoScreen
import com.vvuono.noto.gallery.NotoGalleryView
import com.vvuono.noto.view.ViewNotoView

private const val TRANSITION_DURATION_MILLIS = 250

@Composable
fun NotoNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val navigator: NotoNavigator = NotoNavigatorImpl(navController)
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
            NotoGalleryView(navigator)
        }

        composable(route = NotoScreen.CreateNoto.name) {
            CreateNotoView(navigator)
        }

        composable(route = NotoScreen.ViewNoto.name) {
            ViewNotoView()
        }
    }
}