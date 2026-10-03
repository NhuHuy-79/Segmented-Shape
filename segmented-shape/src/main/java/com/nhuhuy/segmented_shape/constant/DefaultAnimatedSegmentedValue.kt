package com.nhuhuy.segmented_shape.constant

import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.spring
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.nhuhuy.segmented_shape.animation.CornerValue

object DefaultAnimatedSegmentedValue {
    val largeValue: Dp = 16.dp
    val smallValue: Dp = 8.dp
    val cornerValue: CornerValue = CornerValue(
        topStart = 16.dp,
        topEnd = 16.dp,
        bottomStart = 16.dp,
        bottomEnd = 16.dp
    )
    val dpSpringAnimation = spring(visibilityThreshold = Dp.Companion.VisibilityThreshold)
}