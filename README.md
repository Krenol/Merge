# Merge Project
This project aims at implementing a merge function for a list of ranges. 
The goal is that all overlapping ranges are merged into one range. 

## Example
The list of array `[25,30] [2,19] [14, 23] [4,8]` is merged into `[2,23] [25,30]`

# Algorithm
1. Serialize the list of arrays to a list of objects
2. Sort the objects from lowest to highest according to their lower value
3. Merge overlapping arrays by checking if the lower value from the next item in the list is smaller than the highest value in the current list

# Known limitations
Currently, recursive generic bounds are not yet supported in Kotlin.
Once this is the case, the class `Merge.kt` and `InputStringParser.kt` can be made generic.
Current error message if that is done:
```
Non-reified type parameters with recursive bounds are not supported yet: T
```