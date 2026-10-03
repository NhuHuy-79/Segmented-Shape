package com.nhuhuy.segmented_shape

/**
 * Represents the relative position of an item within a segmented collection.
 */
enum class ItemPosition {
    /**
     * The first item in a collection containing two or more items.
     */
    FIRST,

    /**
     * An intermediate item situated between the first and last items.
     */
    MIDDLE,

    /**
     * The sole item in a collection containing exactly one item.
     */
    SINGLE,

    /**
     * The final item in a collection containing two or more items.
     */
    LAST;

    companion object {
        /**
         * Evaluates and returns the appropriate [ItemPosition] given the total item count and zero-based index.
         *
         * @param count Total number of items in the collection. Must be greater than `0`.
         * @param index Zero-based index of the target item (`0 <= index < count`).
         * @return The calculated [ItemPosition].
         * @throws IllegalArgumentException if [count] is less than or equal to `0`, or if [index] is out of bounds.
         */
        fun fromIndexedItem(
            count: Int,
            index: Int,
        ): ItemPosition {
            require(count > 0) {
                "Count must be greater than 0"
            }
            require(index in (0 until count)) {
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