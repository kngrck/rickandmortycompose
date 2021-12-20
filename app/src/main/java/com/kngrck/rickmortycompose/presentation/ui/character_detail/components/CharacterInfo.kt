package com.kngrck.rickmortycompose.presentation.ui.character_detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun CharacterInfo(
    header: String,
    info: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = header,
            style = MaterialTheme.typography.h6
        )
        Text(
            text = info,
            style = MaterialTheme.typography.body1,
        )
    }
}