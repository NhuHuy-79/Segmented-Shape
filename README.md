# Segmented Shape

A lightweight, modern Jetpack Compose library for creating static and animated segmented shapes for buttons, lists, cards, and custom controls.

[![](https://jitpack.io/v/NhuHuy-79/SegmentedShape.svg)](https://jitpack.io/#NhuHuy-79/SegmentedShape)
![Android](https://img.shields.io/badge/Platform-Android-3DDC84?style=flat-square&logo=android)
![API](https://img.shields.io/badge/API-29%2B-brightgreen?style=flat-square)
![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-7F52FF?style=flat-square&logo=kotlin)
![Compose](https://img.shields.io/badge/Jetpack%20Compose-Ready-4285F4?style=flat-square&logo=jetpackcompose)
![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg?style=flat-square)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](https://github.com/NhuHuy79/SegmentedShape/pulls)

---

## ✨ Features

- 📐 **Static Segmented Shapes**: Easily generate rounded corner shapes for items based on their position (`FIRST`, `MIDDLE`, `LAST`, `SINGLE`).
- 🎬 **Animated Segmented Shapes**: Smooth corner animation when items transition between default and selected states.
- 🔄 **Multi-directional Support**: Works seamlessly in both `HORIZONTAL` and `VERTICAL` orientations.
- 🎯 **Automatic Position Helper**: Calculate item position effortlessly with `ItemPosition.fromIndexedItem(count, index)`.
- 🎨 **Fully Customizable**: Adjust outer (`large`) and inner (`small`) radii, as well as animation specifications (`AnimationSpec`).

---

## 📦 Installation

### 1. Add JitPack Repository

Add JitPack to your `settings.gradle.kts` file:

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

### 2. Add Dependency

Add the library dependency to your module's `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.github.NhuHuy79:SegmentedShape:1.0.0")
}
```

---

## 🚀 Quick Start & Usage

### 1. Static Segmented Shape

Use `toSegmentedShape()` to generate a `RoundedCornerShape` suited for the item's position in a group.

```kotlin
import com.nhuhuy.segmented_shape.ItemPosition
import com.nhuhuy.segmented_shape.constant.SegmentedDirection
import com.nhuhuy.segmented_shape.toSegmentedShape

@Composable
fun StaticSegmentedRow(items: List<String>) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        itemsIndexed(items) { index, item ->
            val position = ItemPosition.fromIndexedItem(
                count = items.size,
                index = index
            )

            Box(
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = position.toSegmentedShape(
                            direction = SegmentedDirection.HORIZONTAL,
                            large = 16.dp,
                            small = 4.dp
                        )
                    )
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(text = item, color = MaterialTheme.colorScheme.onPrimary)
            }
        }
    }
}
```

### 2. Animated Segmented Buttons

Use `toAnimatedSegmentedShape()` to create buttons that smoothly animate their corners when selected.

```kotlin
import com.nhuhuy.segmented_shape.ItemPosition
import com.nhuhuy.segmented_shape.animation.toAnimatedSegmentedShape
import com.nhuhuy.segmented_shape.constant.SegmentedDirection

@Composable
fun AnimatedSegmentedGroup(
    items: List<String>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        items.forEachIndexed { index, label ->
            val position = ItemPosition.fromIndexedItem(
                count = items.size,
                index = index
            )

            Button(
                onClick = { onItemSelected(index) },
                shape = position.toAnimatedSegmentedShape(
                    direction = SegmentedDirection.HORIZONTAL,
                    animatedToSelected = selectedIndex == index,
                    large = 24.dp
                )
            ) {
                Text(text = label)
            }
        }
    }
}
```

### 3. Vertical Segmented Shapes

Simply set `direction = SegmentedDirection.VERTICAL` to apply shapes in vertical lists or button groups.

```kotlin
val position = ItemPosition.fromIndexedItem(count = items.size, index = index)

Box(
    modifier = Modifier.background(
        color = MaterialTheme.colorScheme.secondary,
        shape = position.toSegmentedShape(
            direction = SegmentedDirection.VERTICAL,
            large = 16.dp,
            small = 4.dp
        )
    )
)
```

---

## 🛠 API Reference

### `ItemPosition`
Enum representing the position of an item:
- `FIRST`: Top or Start item.
- `MIDDLE`: Intermediate item.
- `LAST`: Bottom or End item.
- `SINGLE`: Sole item in a single-element list.

Helper method:
`ItemPosition.fromIndexedItem(count: Int, index: Int): ItemPosition`

### `ItemPosition.toSegmentedShape(...)`
| Parameter | Type | Default | Description |
|---|---|---|---|
| `direction` | `SegmentedDirection` | `VERTICAL` | `HORIZONTAL` or `VERTICAL` |
| `large` | `Dp` | `16.dp` | Radius for outer/exterior corners |
| `small` | `Dp` | `8.dp` | Radius for inner/adjacent corners |

### `ItemPosition.toAnimatedSegmentedShape(...)`
| Parameter | Type | Default | Description |
|---|---|---|---|
| `direction` | `SegmentedDirection` | `VERTICAL` | `HORIZONTAL` or `VERTICAL` |
| `large` | `Dp` | `16.dp` | Radius for outer corners |
| `small` | `Dp` | `8.dp` | Radius for inner corners |
| `animatedToSelected` | `Boolean` | Required | `true` if item is selected (animates to fully rounded) |
| `animationSpec` | `AnimationSpec<Dp>` | `tween(180, FastOutSlowIn)` | Custom animation specification |

---

## 📄 License

```text
Copyright 2026 NhuHuy79

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
