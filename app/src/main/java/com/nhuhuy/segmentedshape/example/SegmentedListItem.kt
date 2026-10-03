package com.nhuhuy.segmentedshape.example

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
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
}

@Composable
fun SegmentedListItem(
    modifier: Modifier = Modifier,
){
    LazyRow(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            space = 4.dp, alignment = Alignment.CenterHorizontally
        )
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
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = position.toSegmentedShape(
                            direction = SegmentedDirection.HORIZONTAL,
                            large = 24.dp
                        )
                    ),
                contentAlignment = Alignment.Center
            ){
                Text(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
                    text = item.label,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}