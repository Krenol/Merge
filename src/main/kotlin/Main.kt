import krenol.merge.Merge

fun main(args: Array<String>) {
    println("Input your range list in the form of [1,2] [2,4]")
    val rangeList = readLine()
    println("Read: ${rangeList}")
    val merge = Merge(rangeList)
    merge.mergeListOfRanges()
    merge.printMergeResult()
}
