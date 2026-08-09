# Task Overview

## Problems:
- Can't handle negative numbers in static array (grammar error)
- Matrix not supported in marsik code, only internally
- Datetime not supported in marsik code, only internally
- Error: Multiple definition of "compare" in module "math"

## Discussion and Ideas:
- enabling compilation in CLI
- Matrix: fill method like 
```
 Matrix matrix = new Matrix(2, 2) 
 matrix.fill(4,6,3,7)
```

## Open:
- Fix compile and runtime problems in "list" module
- Add Pseudo-OOP support in compiler
- Implement support of trees in datastructures (At least Binary- and B-Trees)
- Implement GapBuffer, SplayArray in datastructures
- babyInt support
- no datetime objects, only strings in datetime format

## In Progress:
- Fix weird Error: Multiple definition of "compare" in module "math"
- Advanced Random number generator in module "math"

## Complete:
- Fix string issues (used cpp strings), strings normally printable
- Support including variables in scan statement, same as in print statement
- printLine statement
- Bump allocator
- hash function for hashmaps and strings
- getting day of week function in module "datetime"