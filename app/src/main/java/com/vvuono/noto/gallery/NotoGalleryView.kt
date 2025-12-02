package com.vvuono.noto.gallery

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.vvuono.noto.navigation.LocalNotoNavigator

@Composable
fun NotoGalleryView() {
    Scaffold(
        floatingActionButton = {
            NewNotoButton()
        },
    ) { innerPadding ->
        // TODO: Add Gallery UI
    }
}

@Composable
fun NewNotoButton() {
    val navigator = LocalNotoNavigator.current
    FloatingActionButton(
        onClick = { navigator.navigateToCreateNoto() },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "New Noto")
    }
}
