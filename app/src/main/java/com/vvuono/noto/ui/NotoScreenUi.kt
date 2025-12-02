package com.vvuono.noto.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vvuono.noto.navigation.NotoNavHost

@Composable
fun NotoApp() {
    Scaffold { innerPadding ->
        NotoNavHost(
            modifier = Modifier.padding(innerPadding),
        )
    }
}
