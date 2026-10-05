package com.nhuhuy.segmented_shape

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.nhuhuy.segmented_shape.constant.DefaultSegmentedValue
import com.nhuhuy.segmented_shape.constant.SegmentedDirection

/**
 * Generates a Compose [RoundedCornerShape] with corner radii calculated according to this [ItemPosition]
 * and the specified layout [direction].
 *
 * @param direction The layout orientation ([com.nhuhuy.segmented_shape.constant.SegmentedDirection.HORIZONTAL] or [com.nhuhuy.segmented_shape.constant.SegmentedDirection.VERTICAL]).
 * Defaults to [com.nhuhuy.segmented_shape.constant.SegmentedDirection.VERTICAL].
 * @param large Outer corner radius applied to exterior edges. Defaults to [com.nhuhuy.segmented_shape.constant.DefaultSegmentedValue.large].
 * @param small Inner corner radius applied to adjacent interior edges. Defaults to [com.nhuhuy.segmented_shape.constant.DefaultSegmentedValue.small].
 * @return A [RoundedCornerShape] configured for the given position and orientation.
 */
fun ItemPosition.toSegmentedShape(
    direction: SegmentedDirection = SegmentedDirection.VERTICAL,
    large: Dp = DefaultSegmentedValue.large,
    small: Dp = DefaultSegmentedValue.small,
): RoundedCornerShape {
    return when (direction) {
        SegmentedDirection.HORIZONTAL -> toHorizontalSegmentedShape(
            large = large,
            small = small,
        )

        SegmentedDirection.VERTICAL -> toVerticalSegmentedShape(
            large = large,
            small = small,
        )
    }
}

internal fun ItemPosition.toHorizontalSegmentedShape(
    large: Dp = 16.dp,
    small: Dp = 8.dp,
): RoundedCornerShape {
    return when (this) {
        ItemPosition.FIRST -> horizontalRoundedCornerShape(start = large, end = small)
        ItemPosition.MIDDLE -> horizontalRoundedCornerShape(start = small, end = small)
        ItemPosition.SINGLE -> horizontalRoundedCornerShape(start = large, end = large)
        ItemPosition.LAST -> horizontalRoundedCornerShape(start = small, end = large)
    }
}

internal fun ItemPosition.toVerticalSegmentedShape(
    large: Dp = 16.dp,
    small: Dp = 8.dp,
): RoundedCornerShape {
    return when (this) {
        ItemPosition.FIRST -> verticalRoundedCornerShape(top = large, bottom = small)
        ItemPosition.MIDDLE -> RoundedCornerShape(small)
        ItemPosition.SINGLE -> RoundedCornerShape(large)
        ItemPosition.LAST -> verticalRoundedCornerShape(top = small, bottom = large)
    }
}

/**
 * Creates a [RoundedCornerShape] with symmetrical corner radii for horizontal layouts.
 *
 * The [start] radius is applied to both `topStart` and `bottomStart`, while the [end] radius
 * is applied to both `topEnd` and `bottomEnd`.
 *
 * @param start Radius for the start corners.
 * @param end Radius for the end corners.
 * @return A [RoundedCornerShape] configured for horizontal item layout.
 */
fun horizontalRoundedCornerShape(
    start: Dp,
    end: Dp,
) = RoundedCornerShape(
    topStart = start,
    bottomStart = start,
    topEnd = end,
    bottomEnd = end,
)

/**
 * Creates a [RoundedCornerShape] with symmetrical corner radii for vertical layouts.
 *
 * The [top] radius is applied to both `topStart` and `topEnd`, while the [bottom] radius
 * is applied to both `bottomStart` and `bottomEnd`.
 *
 * @param top Radius for the top corners.
 * @param bottom Radius for the bottom corners.
 * @return A [RoundedCornerShape] configured for vertical item layout.
 */
fun verticalRoundedCornerShape(
    top: Dp,
    bottom: Dp,
) = RoundedCornerShape(
    topStart = top,
    topEnd = top,
    bottomEnd = bottom,
    bottomStart = bottom,
)
