package com.vvuono.noto.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vvuono.noto.create.CreateNotoView
import com.vvuono.noto.data.ui.NotoScreen
import com.vvuono.noto.gallery.NotoGalleryView
import com.vvuono.noto.view.ViewNotoView

private const val TRANSITION_DURATION_MILLIS = 250

val LocalNotoNavigator = compositionLocalOf<NotoNavigator> { error("No NotoNavigator provided") }

@Composable
fun NotoNavHost(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    val navigator = remember(navController) { NotoNavigatorImpl(navController) }
    CompositionLocalProvider(LocalNotoNavigator provides navigator) {
        createNavHost(navController, modifier)
    }
}

@Composable
private fun createNavHost(
    navController: NavHostController,
    modifier: Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NotoScreen.Gallery(),
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
        composable<NotoScreen.Gallery> {
            NotoGalleryView()
        }

        composable<NotoScreen.CreateNoto> {
            CreateNotoView()
        }

        composable<NotoScreen.ViewNoto> {
            ViewNotoView()
        }
    }
}