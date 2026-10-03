package com.nhuhuy.segmentedshape

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.nhuhuy.segmentedshape.example.ExampleScreen
import com.nhuhuy.segmentedshape.ui.theme.SegmentedShapeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SegmentedShapeTheme {
                ExampleScreen()
            }
        }
    }
}
