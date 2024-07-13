package com.achmadss.quill.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardComponent(
    title: String = "",
    content: String = "",
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .heightIn(min = 10.dp, 200.dp),
        border = BorderStroke(2.dp, Color.DarkGray),
        colors = CardDefaults.cardColors().copy(
            containerColor = Color.Transparent,
            contentColor = Color.White
        ),
        onClick = {
            onClick()
        }
    ) {
        Column (
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = title,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = content,
                overflow = TextOverflow.Ellipsis,
                maxLines = 4,
                softWrap = true,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}
