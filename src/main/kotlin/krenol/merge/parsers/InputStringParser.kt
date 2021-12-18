package krenol.merge.parsers

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import krenol.merge.data.MergeInputList

class InputStringParser {
    fun parseInputStringToMergeInputList(inputString: String?) : MergeInputList<Int> {
        val jsonStr = parseInputStringToJsonString(inputString)
        return Json.decodeFromString(jsonStr)
    }

    private fun parseInputStringToJsonString(inputString: String?): String {
        var preparedInputString = removeWhitespacesFromString(inputString)
        preparedInputString = addCommasBetweenBrackets(preparedInputString)
        return "{\"list\": [${preparedInputString}]}"
    }

    private fun removeWhitespacesFromString(inputString: String?) : String? {
        return inputString?.replace("\\s".toRegex(), "")
    }

    private fun addCommasBetweenBrackets(inputString: String?) : String? {
        return inputString?.replace("][", "],[")
    }
}