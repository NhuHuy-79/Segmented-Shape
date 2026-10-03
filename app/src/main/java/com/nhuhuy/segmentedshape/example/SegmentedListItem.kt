package com.nhuhuy.segmentedshape.example

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.nhuhuy.segmented_shape.ItemPosition
import com.nhuhuy.segmented_shape.constant.SegmentedDirection
import com.nhuhuy.segmented_shape.toSegmentedShape

enum class ListItem(val label: String) {
    MILK("Milk"),
    CHICKEN("Chicken"),
    FISH("Fish"),
    SODA("Soda"),
    BREAD("Bread"),
    VEGETABLES("Vegetable")
}

@Composable
fun SegmentedListItem(
    modifier: Modifier = Modifier,
){
    LazyRow(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        itemsIndexed(
            items = ListItem.entries,
            key = { _: Int, item: ListItem -> item.hashCode() }
        ){ index: Int, item: ListItem ->
            val position = ItemPosition.fromIndexedItem(
                count = ListItem.entries.size,
                index = index
            )

            Box(
                modifier = Modifier.size(48.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = position.toSegmentedShape(
                            direction = SegmentedDirection.HORIZONTAL
                        )
                    ),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = item.label,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}