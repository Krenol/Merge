package krenol.merge.parsers

import krenol.merge.data.Range
import krenol.merge.data.MergeInputList

class ListOfRangesParser<T : Comparable<T>> {
    fun parseMergeInputListToListOfRanges(mergeInputList: MergeInputList<T>) : MutableList<Range<T>> {
        var list = mutableListOf<Range<T>>()
        mergeInputList.list.forEach { list.add(Range(it[0], it[1])) }
        return list
    }
}