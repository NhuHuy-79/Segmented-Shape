package com.nhuhuy.segmented_shape.constant

import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.spring
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.nhuhuy.segmented_shape.animation.CornerValue

/**
 * Contains default constants and animation specifications for animated segmented shapes.
 */
object DefaultAnimatedSegmentedValue {
    /**
     * Default large corner radius ([16.dp]).
     */
    val largeValue: Dp = 16.dp

    /**
     * Default small corner radius ([8.dp]).
     */
    val smallValue: Dp = 8.dp

    /**
     * Default fully rounded [CornerValue] set to [16.dp] for all four corners.
     */
    val cornerValue: CornerValue = CornerValue(
        topStart = 16.dp,
        topEnd = 16.dp,
        bottomStart = 16.dp,
        bottomEnd = 16.dp,
    )

    /**
     * Default spring animation specification used for animating corner radius transitions.
     */
    val dpSpringAnimation: SpringSpec<Dp> = spring(visibilityThreshold = Dp.VisibilityThreshold)
}
