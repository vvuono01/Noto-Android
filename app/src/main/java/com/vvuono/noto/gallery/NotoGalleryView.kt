package com.vvuono.noto.gallery

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.vvuono.noto.navigation.NotoNavigator

@Composable
fun NotoGalleryView(navigator: NotoNavigator) {
    Scaffold(
        floatingActionButton = {
            NewNotoButton(navigator)
        },
    ) { innerPadding ->
        // TODO: Add Gallery UI
    }
}

@Composable
fun NewNotoButton(navigator: NotoNavigator) {
    FloatingActionButton(
        onClick = { navigator.navigateToCreateNoto() },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "New Noto")
    }
}
