package krenol.merge

import krenol.merge.data.Range

class RangeListMerger<T : Comparable<T>> {
    fun mergeListOfRanges(listOfRanges: List<Range<T>>) : List<Range<T>> {
        val mergedListOfRanges = mutableListOf<Range<T>>()
        var currentRange: Range<T> = listOfRanges[0]
        for (index in 1 until listOfRanges.size) {
            if(rangesCanBeMerged(currentRange, listOfRanges[index])) {
                currentRange.mergeRange(listOfRanges[index])
            } else {
                mergedListOfRanges.add(currentRange)
                currentRange = listOfRanges[index]
            }
        }
        mergedListOfRanges.add(currentRange)
        return mergedListOfRanges
    }

    private fun rangesCanBeMerged(currentRange: Range<T>, rangeToCheck: Range<T>) : Boolean {
        return currentRange.valueIsInRange(rangeToCheck.minValue)
    }
}