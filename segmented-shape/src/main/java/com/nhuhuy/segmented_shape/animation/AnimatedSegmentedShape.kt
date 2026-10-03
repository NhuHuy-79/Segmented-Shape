package com.nhuhuy.segmented_shape.animation

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.nhuhuy.segmented_shape.ItemPosition
import com.nhuhuy.segmented_shape.constant.SegmentedDirection
import com.nhuhuy.segmented_shape.constant.DefaultAnimatedSegmentedValue

/**
 * Creates and animates a [RoundedCornerShape] based on this [ItemPosition] and selection state.
 *
 * When [animatedToSelected] changes, the corners smoothly animate between their initial
 * segmented position shape and fully rounded values using the provided [animationSpec].
 *
 * @param direction The layout orientation ([SegmentedDirection.HORIZONTAL] or [SegmentedDirection.VERTICAL]).
 * Defaults to [SegmentedDirection.VERTICAL].
 * @param large Outer corner radius for exterior edges. Defaults to [DefaultAnimatedSegmentedValue.largeValue].
 * @param small Inner corner radius for interior edges. Defaults to [DefaultAnimatedSegmentedValue.smallValue].
 * @param animatedToSelected `true` if the item is selected/active, triggering the animation to fully rounded corners;
 * `false` to animate back to default segmented shape.
 * @param animationSpec The [AnimationSpec] used for animating corner radius values.
 * Defaults to [DefaultAnimatedSegmentedValue.dpSpringAnimation].
 * @return An animated [RoundedCornerShape] reflecting the current animation state.
 */
@Composable
fun ItemPosition.toAnimatedSegmentedShape(
    direction: SegmentedDirection = SegmentedDirection.VERTICAL,
    large: Dp = DefaultAnimatedSegmentedValue.largeValue,
    small: Dp = DefaultAnimatedSegmentedValue.smallValue,
    animatedToSelected: Boolean,
    animationSpec: AnimationSpec<Dp> = DefaultAnimatedSegmentedValue.dpSpringAnimation,
): RoundedCornerShape {

    val animatedCornerValues = when (direction) {
        SegmentedDirection.HORIZONTAL -> toHorizontalAnimationCorners(large, small)
        SegmentedDirection.VERTICAL -> toVerticalAnimationCorners(large, small)
    }

    return animatedRoundedCornerShape(
        triggerAnimation = animatedToSelected,
        initialValue = animatedCornerValues.initialValue,
        animatedValue = animatedCornerValues.animatedValue,
        animationSpec = animationSpec,
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
