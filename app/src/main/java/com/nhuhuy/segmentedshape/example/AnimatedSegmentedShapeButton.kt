package com.nhuhuy.segmentedshape.example

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
    CAMERA("Camera"),
}

@Composable
fun AnimatedSegmentedShapeButton(
    modifier: Modifier = Modifier,
    selectedItem: ButtonItem,
    direction: SegmentedDirection = SegmentedDirection.HORIZONTAL,
    onClick: (ButtonItem) -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        ButtonItem.entries.forEachIndexed { index, item ->
            val position = ItemPosition.fromIndexedItem(
                count = ButtonItem.entries.size,
                index = index
            )

            Button(
                modifier = Modifier,
                onClick = { onClick(item) },
                shape = position.toAnimatedSegmentedShape(
                    direction = direction,
                    animatedToSelected = selectedItem == item,
                    large = 24.dp,
                ),
            ) {
                Text(
                    text = item.label,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                )
            }
        }
    }
}
