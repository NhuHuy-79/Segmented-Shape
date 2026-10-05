package com.nhuhuy.segmented_shape.lazy_list

import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.nhuhuy.segmented_shape.ItemPosition

/**
 * Adds a list of items to the [LazyListScope] where each item receives its calculated [ItemPosition],
 * index, and item instance in [itemContent].
 *
 * @param T The type of items in the list.
 * @param items The list of items to display.
 * @param key A factory of stable and unique keys representing the item.
 * @param contentType A factory of the content type for the item.
 * @param itemContent The composable content for each item, providing its index, the item itself,
 * and its [ItemPosition] (e.g., [ItemPosition.FIRST], [ItemPosition.MIDDLE], [ItemPosition.LAST], [ItemPosition.SINGLE]).
 */
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

/**
 * Adds an array of items to the [LazyListScope] where each item receives its calculated [ItemPosition],
 * index, and item instance in [itemContent].
 *
 * @param T The type of items in the array.
 * @param items The array of items to display.
 * @param key A factory of stable and unique keys representing the item.
 * @param contentType A factory of the content type for the item.
 * @param itemContent The composable content for each item, providing its index, the item itself,
 * and its [ItemPosition] (e.g., [ItemPosition.FIRST], [ItemPosition.MIDDLE], [ItemPosition.LAST], [ItemPosition.SINGLE]).
 */
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

/**
 * Adds a list of items to the [LazyListScope] where each item receives its calculated [ItemPosition]
 * and item instance in [itemContent].
 *
 * @param T The type of items in the list.
 * @param items The list of items to display.
 * @param key A factory of stable and unique keys representing the item.
 * @param contentType A factory of the content type for the item.
 * @param itemContent The composable content for each item, providing the item itself and its
 * [ItemPosition] (e.g., [ItemPosition.FIRST], [ItemPosition.MIDDLE], [ItemPosition.LAST], [ItemPosition.SINGLE]).
 */
inline fun <T> LazyListScope.segmentedItems(
    items: List<T>,
    noinline key: ((index: Int, item: T) -> Any)? = null,
    crossinline contentType: (index: Int, item: T) -> Any? = { _, _ -> null },
    crossinline itemContent: @Composable LazyItemScope.(item: T, position: ItemPosition) -> Unit,
) = itemsIndexed(
    items = items,
    key = key,
    contentType = contentType,
) { index, item ->
    val position = ItemPosition.fromIndexedItem(items.size, index)
    itemContent(item, position)
}

/**
 * Adds an array of items to the [LazyListScope] where each item receives its calculated [ItemPosition]
 * and item instance in [itemContent].
 *
 * @param T The type of items in the array.
 * @param items The array of items to display.
 * @param key A factory of stable and unique keys representing the item.
 * @param contentType A factory of the content type for the item.
 * @param itemContent The composable content for each item, providing the item itself and its
 * [ItemPosition] (e.g., [ItemPosition.FIRST], [ItemPosition.MIDDLE], [ItemPosition.LAST], [ItemPosition.SINGLE]).
 */
inline fun <T> LazyListScope.segmentedItems(
    items: Array<T>,
    noinline key: ((index: Int, item: T) -> Any)? = null,
    crossinline contentType: (index: Int, item: T) -> Any? = { _, _ -> null },
    crossinline itemContent: @Composable LazyItemScope.(item: T, position: ItemPosition) -> Unit,
) = itemsIndexed(
    items = items,
    key = key,
    contentType = contentType,
) { index, item ->
    val position = ItemPosition.fromIndexedItem(items.size, index)
    itemContent(item, position)
}
