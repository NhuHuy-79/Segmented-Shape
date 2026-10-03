package com.nhuhuy.segmented_shape.animation

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.nhuhuy.segmented_shape.ItemPosition
import com.nhuhuy.segmented_shape.constant.SegmentedDirection
import com.nhuhuy.segmented_shape.constant.DefaultAnimatedSegmentedValue

@Composable
fun ItemPosition.toAnimatedSegmentedShape(
    direction: SegmentedDirection = SegmentedDirection.VERTICAL,
    large: Dp = DefaultAnimatedSegmentedValue.largeValue,
    small: Dp = DefaultAnimatedSegmentedValue.smallValue,
    animatedToSelected: Boolean,
    animationSpec: AnimationSpec<Dp> = DefaultAnimatedSegmentedValue.dpSpringAnimation,
) : RoundedCornerShape {

    val animatedCornerValues = when (direction) {
        SegmentedDirection.HORIZONTAL -> toHorizontalAnimationCorners(large, small)
        SegmentedDirection.VERTICAL -> toVerticalAnimationCorners(large, small)
    }

    return animatedRoundedCornerShape(
        triggerAnimation = animatedToSelected,
        initialValue = animatedCornerValues.initialValue,
        animatedValue = animatedCornerValues.animatedValue,
        animationSpec = animationSpec
    )
}

internal fun ItemPosition.toVerticalAnimationCorners(
    large: Dp, small: Dp
): AnimatedCornerValues {
    val animated = CornerValue(
        topStart = large,
        topEnd = large,
        bottomStart = large,
        bottomEnd = large
    )

    val initial = when (this) {
        ItemPosition.FIRST -> CornerValue(
            topStart = large,
            topEnd = large,
            bottomStart = small,
            bottomEnd = small
        )

        ItemPosition.MIDDLE -> CornerValue(
            topStart = small,
            topEnd = small,
            bottomStart = small,
            bottomEnd = small
        )

        ItemPosition.SINGLE -> CornerValue(
            topStart = large,
            topEnd = large,
            bottomStart = large,
            bottomEnd = large
        )

        ItemPosition.LAST -> CornerValue(
            topStart = small,
            topEnd = small,
            bottomStart = large,
            bottomEnd = large
        )
    }

    return AnimatedCornerValues(initialValue = initial, animatedValue = animated)
}

internal fun ItemPosition.toHorizontalAnimationCorners(
    large: Dp,
    small: Dp
): AnimatedCornerValues {
    val animated = CornerValue(
        topStart = large,
        topEnd = large,
        bottomStart = large,
        bottomEnd = large
    )

    val initial = when (this) {
        ItemPosition.FIRST -> CornerValue(
            topStart = large,
            topEnd = small,
            bottomStart = large,
            bottomEnd = small
        )

        ItemPosition.MIDDLE -> CornerValue(
            topStart = small,
            topEnd = small,
            bottomStart = small,
            bottomEnd = small
        )

        ItemPosition.SINGLE -> CornerValue(
            topStart = large,
            topEnd = large,
            bottomStart = large,
            bottomEnd = large
        )

        ItemPosition.LAST -> CornerValue(
            topStart = small,
            topEnd = large,
            bottomStart = small,
            bottomEnd = large
        )
    }

    return AnimatedCornerValues(
        initialValue = initial,
        animatedValue = animated
    )
}