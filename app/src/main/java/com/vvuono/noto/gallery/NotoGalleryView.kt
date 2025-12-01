package com.vvuono.noto.gallery

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.vvuono.noto.data.ui.NotoScreen

@Composable
fun NotoGalleryView(navController: NavController) {
    Scaffold(
        floatingActionButton = {
            NewNotoButton(navController)
        },
    ) { innerPadding ->
        // TODO: Add Gallery UI
    }
}

@Composable
fun NewNotoButton(navController: NavController) {
    FloatingActionButton(
        onClick = { navController.navigate(NotoScreen.CreateNoto.name) },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "New Noto")
    }
}
