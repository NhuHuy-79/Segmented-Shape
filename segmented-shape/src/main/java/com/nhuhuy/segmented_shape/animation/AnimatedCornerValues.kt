package com.nhuhuy.segmented_shape.animation

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.Dp

/**
 * Holds the pair of [CornerValue] configurations representing the initial (unselected)
 * and target animated (selected) states for shape transitions.
 *
 * @property initialValue Corner values applied when unselected or in normal state.
 * @property animatedValue Corner values applied when selected or in animated state.
 */
@Immutable
data class AnimatedCornerValues(
    val initialValue: CornerValue,
    val animatedValue: CornerValue
)

/**
 * Encapsulates corner radius values for all four corners of a shape.
 *
 * @property topStart Radius for the top-start corner.
 * @property topEnd Radius for the top-end corner.
 * @property bottomStart Radius for the bottom-start corner.
 * @property bottomEnd Radius for the bottom-end corner.
 */
@Immutable
data class CornerValue(
    val topStart: Dp,
    val topEnd: Dp,
    val bottomStart: Dp,
    val bottomEnd: Dp
)

/**
 * Internal composable function that animates corner radii using [animateDpAsState].
 */
@Composable
internal fun animatedRoundedCornerShape(
    triggerAnimation: Boolean,
    initialValue: CornerValue,
    animatedValue: CornerValue,
    animationSpec: AnimationSpec<Dp>,
): RoundedCornerShape {
    val animatedTopStart by animateDpAsState(
        targetValue = if (triggerAnimation) animatedValue.topStart else initialValue.topStart,
        animationSpec = animationSpec
    )
    val animatedTopEnd by animateDpAsState(
        targetValue = if (triggerAnimation) animatedValue.topEnd else initialValue.topEnd,
        animationSpec = animationSpec
    )
    val animatedBottomStart by animateDpAsState(
        targetValue = if (triggerAnimation) animatedValue.bottomStart else initialValue.bottomStart,
        animationSpec = animationSpec
    )
    val animatedBottomEnd by animateDpAsState(
        targetValue = if (triggerAnimation) animatedValue.bottomEnd else initialValue.bottomEnd,
        animationSpec = animationSpec
    )

    return RoundedCornerShape(
        topStart = animatedTopStart,
        topEnd = animatedTopEnd,
        bottomStart = animatedBottomStart,
        bottomEnd = animatedBottomEnd
    )
}
