# Task Overview

## Problems:
- Can't handle negative numbers in static array (grammar error)
- Thread handling no supported

## Discussion and Ideas:
- BabyInt remove?
- enabling compilation in CLI
- Matrix: fill method like
```
 Matrix matrix = new Matrix(2, 2) 
 matrix.fill(4,6,3,7)
```

## Open:
- Fix: Key-Value insertion not supported by Compiler

## In Progress:
- Refactor: Compiler, Lookup and Utils
- Feat: Complete tests

## Complete
- Fix: Investigate and fix heavy errors in hashmap and perfectHashmap
- Feat: More methods for string
- Fix: Typos across the whole runtime (e.g. "culumn" instead column)
- Feat: Implement support of trees in datastructures (At least Binary- and AVL-Trees)
- Feat: Test and fix Matrix
- Fix: Add cast of allocation in Set, PerfectHashMap, HashMap
- Fix: Add rest of the runtime objects in lookup buildInObjectsDatastructures
- Fix: For compiler - adjust method "visit Object_stmt" to handle objects without type holder:
- BitSet, GenericList, Graph, Edge, GapBuffer
- Fix: Rename init method for SplayArray to "init_splayarray"
- Fix: remove all pointer types in params and pointer accessing
- Feat: Add Pseudo-OOP support in compiler
- Feat: Implement GapBuffer, SplayArray in datastructures
- Fix: Error - Multiple definition of "compare" in module "math"
- Feat: Support using strings for Datetime
- Fix: String issues (used cpp strings), strings normally printable
- Feat: Support including variables in scan statement, same as in print statement
- Feat: PrintLine statement
- Feat: Bump allocator
- Feat: Hash function for hashmaps and strings
- Feat: Getting day of week function in module "datetime"
- Feat: Random number generator in module "math"