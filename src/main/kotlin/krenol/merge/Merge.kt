package krenol.merge

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import krenol.merge.data.Range
import krenol.merge.data.RangeList
import krenol.merge.parsers.RangeListParser
import krenol.merge.validators.InputValidator

class Merge(rangeStr: String?) {
    private val listOfRanges: MutableList<Range<Int>>
    private lateinit var mergedListOfRanges: List<Range<Int>>

    init {
        validateInput(rangeStr)
        listOfRanges = parseListOfRanges(rangeStr)
        sortListOfRanges()
    }

    private fun validateInput(rangeStr: String?) {
        val inputValidator = InputValidator()
        val valid = inputValidator.isValidInputString(rangeStr)
        if(valid != true) {
            throw Exception("Invalid input detected! Input must be of form [1,2] [2,4]")
        }
    }

    private fun parseListOfRanges(rangeStr: String?) : MutableList<Range<Int>> {
        val rangeListParser = RangeListParser<Int>()
        val jsonStr = parseInputStringToJsonString(rangeStr)
        val arrayList = Json.decodeFromString<RangeList<Int>>(jsonStr)
        return rangeListParser.parseInputListToRangeObjectList(arrayList)
    }

    private fun parseInputStringToJsonString(rangeStr: String?): String {
        return "{\"list\": [${rangeStr?.replace(' ', ',')}]}"
    }

    private fun sortListOfRanges() {
        listOfRanges.sortBy { it.minValue }
    }

    fun mergeListOfRanges() {
        val rangeListMerger = RangeListMerger<Int>()
        mergedListOfRanges = rangeListMerger.mergeListOfRanges(listOfRanges)
    }

    fun printMergeResult() {
        var listString = mergedListOfRanges.toString()
        listString = listString.replace("],", "]")
        listString = listString.drop(1)
        listString = listString.dropLast(1)
        println(listString)
    }
}