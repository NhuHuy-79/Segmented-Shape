package com.nhuhuy.segmented_shape.animation

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.Dp

@Immutable
data class AnimatedCornerValues(
    val initialValue: CornerValue,
    val animatedValue: CornerValue
)

@Immutable
data class CornerValue(
    val topStart: Dp,
    val topEnd: Dp,
    val bottomStart: Dp,
    val bottomEnd: Dp
)

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