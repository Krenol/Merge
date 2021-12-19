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

# Possible Improvements
## Serialization
Currently, the serialization is not directly creating the list of range objects. This is done is a separate loop, thus increasing the runtime of the code
## Generic
Allow user to specify what kind of values are inside the ranges (double, int,...) and create generic merger based upon input
- For each new type a new regex must be added as well and thus a generic `InputValidaator.kt` is needed

# Runtime
Assuming that the Kotlin `list.sortyBy` has a complexity of n*log(n), we can assume the following complexity
- Serialization of Json: `n`
- Parsing to list of ranges: `n`
- Sorting the list: `n*log(n)`
- Merging ranges: `n`

## Storage
As all input items are stored as object in the RAM, storage increases per array. 
As an integer in Kotlin takes up 8 bytes, at least 16 bytes per new range are required (without object overhead).
Thus, storage consumption increases linearly with the amount of input ranges.