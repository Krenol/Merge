package krenol.merge.data

import kotlinx.serialization.Serializable

@Serializable
data class MergeInputList<T : Comparable<T>>(val list : List<List<T>>) {
}