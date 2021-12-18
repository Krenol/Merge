package krenol.merge.parsers

import krenol.merge.data.Range

class RangeListToStringParser<T : Comparable<T>> {
    fun createRangeListString(mergedList: List<Range<Int>>) : String {
        var listString = mergedList.toString()
        listString = listString.replace("],", "]")
        listString = listString.drop(1)
        listString = listString.dropLast(1)
        return listString
    }
}