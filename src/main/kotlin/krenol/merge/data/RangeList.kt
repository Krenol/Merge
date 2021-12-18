package krenol.merge.data

import kotlinx.serialization.Serializable

@Serializable
data class RangeList<T : Comparable<T>>(val list : List<List<T>>) {
}