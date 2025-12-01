package com.vvuono.noto.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vvuono.noto.navigation.NotoNavHost

@Composable
fun NotoApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold { innerPadding ->
        NotoNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
        )
    }
}