package com.kngrck.rickmortycompose.presentation.ui.characters.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.kngrck.rickmortycompose.domain.model.CharacterDetail

@Composable
fun CharacterListItem(
    character: CharacterDetail,
    onItemClick: (CharacterDetail) -> Unit
) = with(character) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 4.dp)
            .clickable { onItemClick(this) },
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = rememberImagePainter(image),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .padding(2.dp)
                .clip(RoundedCornerShape(20.dp))
        )
        Column(
            modifier = Modifier
                .padding(16.dp, 0.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.h6,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Text(
                    text = "Status: ",
                    style = MaterialTheme.typography.body1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = status,
                    style = MaterialTheme.typography.body1,
                    color = if (status == "Alive") Color.Green else Color.Red,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            Text(
                text = "Species: $species",
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis,

                )
        }
    }
}