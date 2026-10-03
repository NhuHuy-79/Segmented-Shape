package com.nhuhuy.segmentedshape

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.nhuhuy.segmentedshape.example.HorizontalExampleScreen
import com.nhuhuy.segmentedshape.example.VerticalExampleScreen
import com.nhuhuy.segmentedshape.ui.theme.SegmentedShapeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SegmentedShapeTheme {
               /* HorizontalExampleScreen()*/
                VerticalExampleScreen()
            }
        }
    }
}
