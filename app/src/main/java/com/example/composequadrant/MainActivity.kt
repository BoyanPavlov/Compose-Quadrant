package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun extractValues(): List<Paragraph> {
    val titleTopLeft = "Text composable"
    val titleTopLeftText = "Displays text and follows the recommended Material Design guidelines."
    val color1 = Color(0xFFEADDFF)

    val titleBottomLeft = "Image composable"
    val titleBottomLeftText =
        "Creates a composable that lays out and draws a given Painter class object."
    val color2 = Color(0xFFD0BCFF)

    val titleTopRight = "Row composable"
    val titleTopRightText = "A layout composable that places its children in a horizontal sequence."
    val color3 = Color(0xFFB69DF8)

    val titleBottomRight = "Column composable"
    val titleBottomRightText =
        "A layout composable that places its children in a vertical sequence."
    val color4 = Color(0xFFF6EDFF)


    val paragraph1 = Paragraph(
        title = titleTopLeft,
        text = titleTopLeftText,
        color = color1
    )

    val paragraph2 = Paragraph(
        title = titleTopRight,
        text = titleTopLeftText,
        color = color2
    )

    val paragraph3 = Paragraph(
        title = titleBottomLeft,
        text = titleBottomLeftText,
        color = color3
    )

    val paragraph4 = Paragraph(
        title = titleBottomRight,
        text = titleBottomRightText,
        color = color4
    )

    return listOf(paragraph1, paragraph2, paragraph3, paragraph4)
}


@Composable
fun Page(paragraphs: List<Paragraph>,modifier: Modifier=Modifier) {

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        for (index in paragraphs.indices) {
            paragraphs[index].ParagraphFilled(modifier =
            Modifier.align(
                    alignment =
                    when (index) {
                        0 -> Alignment.TopStart
                        1 -> Alignment.TopEnd
                        2 -> Alignment.BottomStart
                        else -> Alignment.BottomEnd
                    }
                )
            )
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    val paragraphs = extractValues()
    Page(paragraphs)
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() {
    ComposeQuadrantTheme {
        App()
    }
}
