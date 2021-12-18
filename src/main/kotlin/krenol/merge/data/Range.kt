package krenol.merge.data


class Range<T : Comparable<T>>(private var firstValue: T, private var secondValue: T) {
    var minValue: T
    var maxValue: T

    init {
        if(firstValue > secondValue) {
            minValue = secondValue
            maxValue = firstValue
        } else {
            minValue = firstValue
            maxValue = secondValue
        }
    }

    fun valueIsInRange(value : T) : Boolean {
        return valueIsGreaterOrEqToMin(value) && valueIsLessOrEqToMax(value)
    }

    private fun valueIsGreaterOrEqToMin(value: T) : Boolean {
        return value >= minValue
    }

    private fun valueIsLessOrEqToMax(value: T) : Boolean {
        return value <= maxValue
    }

    fun mergeRange(rangeToMerge: Range<T>) {
        if(!valueIsInRange(rangeToMerge.minValue) && !valueIsInRange(rangeToMerge.maxValue)) {
            throw Exception("Cannot merge ranges with values ${this.toString()} and ${rangeToMerge.toString()}")
        }
        if(rangeToMerge.minValue < minValue) {
            minValue = rangeToMerge.minValue
        }
        if(rangeToMerge.maxValue > maxValue) {
            maxValue = rangeToMerge.maxValue
        }
    }

    override fun toString(): String {
        return "[$minValue,$maxValue]"
    }
}