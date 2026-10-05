package com.nhuhuy.segmented_shape.lazy_list

import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.nhuhuy.segmented_shape.ItemPosition

inline fun <T> LazyListScope.segmentedItemIndexed(
    items: List<T>,
    noinline key: ((index: Int, item: T) -> Any)? = null,
    crossinline contentType: (index: Int, item: T) -> Any? = { _, _ -> null },
    crossinline itemContent: @Composable LazyItemScope.(index: Int, item: T, position: ItemPosition) -> Unit,
) = itemsIndexed(
    items = items,
    key = key,
    contentType = contentType,
) { index, item ->
    val position = ItemPosition.fromIndexedItem(items.size, index)
    itemContent(index, item, position)
}

inline fun <T> LazyListScope.segmentedItemIndexed(
    items: Array<T>,
    noinline key: ((index: Int, item: T) -> Any)? = null,
    crossinline contentType: (index: Int, item: T) -> Any? = { _, _ -> null },
    crossinline itemContent: @Composable LazyItemScope.(index: Int, item: T, position: ItemPosition) -> Unit,
) = itemsIndexed(
    items = items,
    key = key,
    contentType = contentType,
) { index, item ->
    val position = ItemPosition.fromIndexedItem(items.size, index)
    itemContent(index, item, position)
}
