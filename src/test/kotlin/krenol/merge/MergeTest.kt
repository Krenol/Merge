package krenol.merge

import krenol.merge.parsers.RangeListToStringParser
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MergeTest {
    private val merge = Merge()
    private val stringParser = RangeListToStringParser<Int>()

    @Test
    fun testMergeWithSingleRange() {
        val inputString = "[1,2]"
        val list = merge.mergeListOfRanges(inputString)
        val result = stringParser.createRangeListString(list)
        assertTrue(inputString == result)
    }

    @Test
    fun testMergeWithTwoNonOverlappingRanges() {
        val inputString = "[1,2] [3,4]"
        val list = merge.mergeListOfRanges(inputString)
        val result = stringParser.createRangeListString(list)
        assertTrue(inputString == result)
    }
}