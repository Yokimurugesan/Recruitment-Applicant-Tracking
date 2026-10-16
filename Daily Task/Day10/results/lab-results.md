# Day 10 - Memory Management Lab

**Task tag:** `day-10: memory-management`

## Experiment Results

| No. | Experiment | Command / Configuration | Observation |
|---|---|---|---|
| 1 | Stack overflow | Default, `-Xss256k`, `-Xss1m` | Record the recursive call count for each stack size. |
| 2 | Heap exhaustion | `-Xms16m -Xmx64m` | Record the approximate MB retained when OutOfMemoryError occurs. |
| 3 | String performance | 20,000 iterations | Record the measured times for String += and StringBuilder. |
| 4 | Garbage collection | `-Xlog:gc` | Record the GC events printed by the JVM. |
| 5 | Integer cache | `==` and `equals()` | 127 comparison: true; 128 comparison: usually false; equals(): true. |

## What I Learned

1. Stack memory stores method-call frames and local variables. Deep recursion can cause StackOverflowError.
2. Heap memory stores objects. Retaining too many objects can cause OutOfMemoryError.
3. String objects are immutable. StringBuilder is generally more efficient for repeated string construction.
4. Garbage collection reclaims memory from unreachable objects. Calling System.gc() is only a request.
5. The Integer cache can make == appear to work for some boxed values. equals() compares wrapper values.

## Notes

- Record actual output from each experiment instead of estimating results.
- Timing results depend on the machine, JVM, warm-up, and other running processes.
- Garbage collection timing is controlled by the JVM.