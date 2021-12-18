package krenol.merge.parsers

import krenol.merge.data.Range
import krenol.merge.data.RangeList

class RangeListParser<T : Comparable<T>> {
    fun parseInputListToRangeObjectList(rangeList: RangeList<T>) : MutableList<Range<T>> {
        var list = mutableListOf<Range<T>>()
        rangeList.list.forEach { list.add(Range(it[0], it[1])) }
        return list
    }
}