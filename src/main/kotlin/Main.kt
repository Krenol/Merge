import krenol.merge.Merge
import krenol.merge.parsers.RangeListToStringParser

fun main(args: Array<String>) {
    val merge = Merge()
    val stringParser = RangeListToStringParser<Int>()
    println("Input your range list in the form of [1,2] [2,4]")
    val inputString = readLine()
    val mergedRanges = merge.mergeListOfRanges(inputString)
    val outputString = stringParser.createRangeListString(mergedRanges)
    println("Result: $outputString")
}
