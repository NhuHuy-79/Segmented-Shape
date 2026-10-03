package com.nhuhuy.segmentedshape

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.nhuhuy.segmentedshape.example.HorizontalExampleScreen
import com.nhuhuy.segmentedshape.example.VerticalExampleScreen
import com.nhuhuy.segmentedshape.ui.theme.SegmentedShapeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        hideStatusBar()

        setContent {
            SegmentedShapeTheme {
               /* HorizontalExampleScreen()*/
                VerticalExampleScreen()
            }
        }
    }

    private fun hideStatusBar(){
        WindowCompat.setDecorFitsSystemWindows(window, false)

        WindowInsetsControllerCompat(
            window,
            window.decorView
        ).hide(WindowInsetsCompat.Type.statusBars())
    }
}
