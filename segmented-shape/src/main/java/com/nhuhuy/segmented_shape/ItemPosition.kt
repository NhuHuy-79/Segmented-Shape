package com.nhuhuy.segmented_shape

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class ItemPosition {
    FIRST, MIDDLE, SINGLE, LAST;

    companion object {
        fun fromIndexedItem(
            count: Int,
            index: Int
        ): ItemPosition {
            require(count > 0) {
                "Count must be greater than 0"
            }
            require(index in 0 until count) {
                "Index must be between 0 and $count"
            }

            return when {
                count == 1 -> SINGLE
                index == 0 -> FIRST
                index == count - 1 -> LAST
                else -> MIDDLE
            }
        }
    }
}

fun ItemPosition.toSegmentedShape(
    direction: SegmentedDirection = SegmentedDirection.VERTICAL,
    large: Dp = DefaultSegmentedValue.large,
    small: Dp = DefaultSegmentedValue.small,
): RoundedCornerShape {
    return when (direction) {
        SegmentedDirection.HORIZONTAL -> toHorizontalSegmentedShape(
            large = large, small = small
        )

        SegmentedDirection.VERTICAL -> toVerticalSegmentedShape(
            large = large, small = small
        )
    }
}

internal fun ItemPosition.toHorizontalSegmentedShape(
    large: Dp = 16.dp, small: Dp = 8.dp
): RoundedCornerShape {
    return when (this) {
        ItemPosition.FIRST -> horizontalRoundedCornerShape(start = large, end = small)
        ItemPosition.MIDDLE -> horizontalRoundedCornerShape(start = small, end = small)
        ItemPosition.SINGLE -> horizontalRoundedCornerShape(start = large, end = large)
        ItemPosition.LAST -> horizontalRoundedCornerShape(start = small, end = large)
    }
}


internal fun ItemPosition.toVerticalSegmentedShape(
    large: Dp = 16.dp, small: Dp = 8.dp
): RoundedCornerShape {
    return when (this) {
        ItemPosition.FIRST -> verticalRoundedCornerShape(top = large, bottom = small)
        ItemPosition.MIDDLE -> RoundedCornerShape(small)
        ItemPosition.SINGLE -> RoundedCornerShape(large)
        ItemPosition.LAST -> verticalRoundedCornerShape(top = small, bottom = large)
    }
}

internal fun horizontalRoundedCornerShape(
    start: Dp,
    end: Dp
) = RoundedCornerShape(
    topStart = start,
    bottomStart = start,
    topEnd = end,
    bottomEnd = end
)

internal fun verticalRoundedCornerShape(
    top: Dp,
    bottom: Dp
) = RoundedCornerShape(
    topStart = top,
    topEnd = top,
    bottomEnd = bottom,
    bottomStart = bottom
)
