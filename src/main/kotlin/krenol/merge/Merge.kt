package krenol.merge

import krenol.merge.data.Range
import krenol.merge.parsers.InputStringParser
import krenol.merge.parsers.ListOfRangesParser
import krenol.merge.validators.InputValidator

class Merge {
    private val inputValidator = InputValidator()
    private val inputStringParser = InputStringParser()
    private val listOfRangesParser = ListOfRangesParser<Int>()
    private val rangeListMerger = RangeListMerger<Int>()

    fun mergeListOfRanges(rangeString: String?) : List<Range<Int>> {
        validateInput(rangeString)
        val listOfRanges = parseListOfRanges(rangeString)
        sortListOfRangesAscending(listOfRanges)
        return mergeRanges(listOfRanges)
    }

    private fun validateInput(rangeString: String?) {
        val valid = inputValidator.isValidInputString(rangeString)
        if(valid != true) {
            throw Exception("Invalid input detected! Input must be of form [1,2] [2,4] and must only contain Integers")
        }
    }

    private fun parseListOfRanges(rangeString: String?) : MutableList<Range<Int>> {
        val mergeInputList = inputStringParser.parseInputStringToMergeInputList(rangeString)
        return listOfRangesParser.parseMergeInputListToListOfRanges(mergeInputList)
    }

    private fun sortListOfRangesAscending(listOfRanges: MutableList<Range<Int>>) {
        listOfRanges.sortBy { it.minValue }
    }

    private fun mergeRanges(listOfRanges: MutableList<Range<Int>>): List<Range<Int>>{
        return rangeListMerger.mergeListOfRanges(listOfRanges)
    }
}