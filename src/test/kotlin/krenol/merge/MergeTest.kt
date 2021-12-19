package krenol.merge

import krenol.merge.parsers.RangeListToStringParser
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.Exception
import kotlin.test.assertFailsWith

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

    @Test
    fun testMergeWithReadmeInput() {
        val inputString = "[25,30] [2,19] [14,23] [4,8]"
        val list = merge.mergeListOfRanges(inputString)
        val result = stringParser.createRangeListString(list)
        assertTrue("[2,23] [25,30]" == result)
    }

    @Test
    fun testMergeWithWrongRangeOrderInput() {
        val inputString = "[30,25] [2,19] [14,23] [4,8]"
        val list = merge.mergeListOfRanges(inputString)
        val result = stringParser.createRangeListString(list)
        assertTrue("[2,23] [25,30]" == result)
    }

    @Test
    fun testMergeWithWhitespaceInput() {
        val inputString = "[25,   30]    [2,19  ] [14  ,23]   [   4,8]"
        val list = merge.mergeListOfRanges(inputString)
        val result = stringParser.createRangeListString(list)
        assertTrue("[2,23] [25,30]" == result)
    }

    @Test
    fun testMergeWithDoubleInput() {
        val inputString = "[25,30.9] [2,19]"
        assertFailsWith<Exception> (
            message = "Invalid input detected! Input must be of form [1,2] [2,4] and must only contain Integers",
            block = {
                merge.mergeListOfRanges(inputString)
            }
        )
    }

    @Test
    fun testMergeWithStringInput() {
        val inputString = "[25,\"a\"] [2,19]"
        assertFailsWith<Exception> (
            message = "Invalid input detected! Input must be of form [1,2] [2,4] and must only contain Integers",
            block = {
                merge.mergeListOfRanges(inputString)
            }
        )
    }

    @Test
    fun testMergeThreeEntryRangeInput() {
        val inputString = "[25,3,5] [2,19]"
        assertFailsWith<Exception> (
            message = "Invalid input detected! Input must be of form [1,2] [2,4] and must only contain Integers",
            block = {
                merge.mergeListOfRanges(inputString)
            }
        )
    }

    @Test
    fun testMergeOneEntryRangeInput() {
        val inputString = "[25] [2,19]"
        assertFailsWith<Exception> (
            message = "Invalid input detected! Input must be of form [1,2] [2,4] and must only contain Integers",
            block = {
                merge.mergeListOfRanges(inputString)
            }
        )
    }

    @Test
    fun testMergeEmptyRangeInput() {
        val inputString = "[] [2,19]"
        assertFailsWith<Exception> (
            message = "Invalid input detected! Input must be of form [1,2] [2,4] and must only contain Integers",
            block = {
                merge.mergeListOfRanges(inputString)
            }
        )
    }

    @Test
    fun testMergeInvalidRangeSeparatorInput() {
        val inputString = "[2;4] [2,19]"
        assertFailsWith<Exception> (
            message = "Invalid input detected! Input must be of form [1,2] [2,4] and must only contain Integers",
            block = {
                merge.mergeListOfRanges(inputString)
            }
        )
    }
}