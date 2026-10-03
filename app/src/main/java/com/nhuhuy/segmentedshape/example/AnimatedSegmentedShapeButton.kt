package com.nhuhuy.segmentedshape.example

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nhuhuy.segmented_shape.ItemPosition
import com.nhuhuy.segmented_shape.animation.toAnimatedSegmentedShape
import com.nhuhuy.segmented_shape.constant.SegmentedDirection

enum class ButtonItem(val label: String) {
    SETTING("Label"),
    HOME("Home"),
    DETAIL("Detail"),
    CAMERA("Camera")
}

@Composable
fun AnimatedSegmentedShapeButton(
    modifier: Modifier = Modifier,
    selectedItem: ButtonItem,
    onClick: (ButtonItem) -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ButtonItem.entries.forEachIndexed { index, item ->
            val position = ItemPosition.fromIndexedItem(
                count = ButtonItem.entries.size,
                index = index
            )

            Button(
                onClick = { onClick(item) },
                shape = position.toAnimatedSegmentedShape(
                    direction = SegmentedDirection.HORIZONTAL,
                    animatedToSelected = selectedItem == item
                )
            ) {
                Text(
                    text = item.label,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}