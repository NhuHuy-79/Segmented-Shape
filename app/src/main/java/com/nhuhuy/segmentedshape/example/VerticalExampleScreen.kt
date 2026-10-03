package com.nhuhuy.segmentedshape.example

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bluetooth
import androidx.compose.material.icons.filled.HomeWork
import androidx.compose.material.icons.filled.NewLabel
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nhuhuy.segmented_shape.ItemPosition
import com.nhuhuy.segmented_shape.animation.toAnimatedSegmentedShape
import com.nhuhuy.segmented_shape.constant.SegmentedDirection
import com.nhuhuy.segmented_shape.toSegmentedShape

enum class IconButton(
    val icon: ImageVector
){
    Home(Icons.Filled.HomeWork),
    Bluetooth(Icons.Filled.Bluetooth),
    Setting(Icons.Filled.HomeWork),
    Label(Icons.Filled.NewLabel),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerticalExampleScreen() {
    var selectedItem by remember { mutableStateOf(IconButton.Home) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Vertical Shape Examples",
                    )
                },
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            item {
                Text(
                    text = "Animated Segmented Buttons",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                )
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }

            itemsIndexed(
                items = IconButton.entries,
                key = { _: Int, item: IconButton -> item.hashCode() }
            ) { index: Int, item: IconButton ->
                val position = ItemPosition.fromIndexedItem(
                    count = IconButton.entries.size,
                    index = index
                )

                FilledIconButton(
                    modifier = Modifier.size(64.dp),
                    onClick = { selectedItem = item },
                    shape = position.toAnimatedSegmentedShape(
                        direction = SegmentedDirection.VERTICAL,
                        animatedToSelected = selectedItem == item,
                        large = 24.dp,
                    )
                ) {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = ""
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }

            item {
                Text(
                    text = "Segmented List",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                )
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }

            itemsIndexed(
                items = ListItem.entries,
                key = { _: Int, item: ListItem -> item.hashCode() }
            ) { index: Int, item: ListItem ->
                val position = ItemPosition.fromIndexedItem(
                    count = ListItem.entries.size,
                    index = index
                )

                Box(
                    modifier = Modifier
                        .width(56.dp)
                        .height(48.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = position.toSegmentedShape(
                                direction = SegmentedDirection.VERTICAL,
                                large = 24.dp,
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = item.label,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}
