package com.example.rpwg.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun MainLayout(modifier: Modifier = Modifier,
               header: @Composable () -> Unit,
               content: @Composable () -> Unit,
               footer: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Row(modifier = Modifier
        ) {
            header()
        }

        Column(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
        ) {
            content()
        }
        Row(modifier = Modifier
        ) {
            footer()
        }

    }
}
