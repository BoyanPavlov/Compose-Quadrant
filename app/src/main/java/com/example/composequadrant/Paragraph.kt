package com.example.composequadrant

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class Paragraph (val title: String,val text:String,val color: Color){
    @Composable
    fun ParagraphFilled(
        modifier: Modifier
    ) {
        Column(
            modifier = Modifier
                .background(color)
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.5f)
                .padding(16.dp)
                .then(modifier),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val gradientColors = listOf(Color.Cyan, Color.Blue, Color.Magenta /*...*/)
            val offset = Offset(5.0f, 10.0f)
            Text(
                text = title,
                style = TextStyle(
                    brush = Brush.linearGradient(
                        colors = gradientColors
                    )
                ),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(4.dp)
            )

            Text(
                text = text,
                style = TextStyle(
                    shadow = Shadow(
                        color = Color.Black,
                        offset = offset,
                        blurRadius = 7f
                    )
                ),
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(4.dp)
            )
        }
    }
}