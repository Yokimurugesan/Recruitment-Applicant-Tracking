# Day 10 - Day 9 Project Review

## Memory Pitfalls and Good Practices

### 1. Resource management
ProductCsvReader uses try-with-resources for its BufferedReader. This closes the reader automatically, including when an exception occurs.

### 2. Growing collections
InMemoryRepository stores products in an instance ArrayList. This is appropriate for a small in-memory project, but the list can keep growing while the repository retains its products.

### 3. Copying collections
If findAll() returns a new ArrayList copy, it creates additional objects and uses extra heap memory. This can matter for very large collections.

### 4. Reading CSV data
ProductCsvReader collects parsed products into a list. For very large CSV files, processing records incrementally may reduce peak memory usage.

### 5. String construction
Avoid repeated String += inside large loops. Use StringBuilder when repeatedly building a string.

### 6. Static collections
Avoid static collections that retain objects indefinitely unless application-wide storage is required. The Day 9 design described here uses an instance collection instead.

### 7. Custom resources
CustomResource implements AutoCloseable and is used with try-with-resources. Multiple resources are closed in reverse order of declaration.

## Stack and Heap Diagram

Example: InMemoryRepository.save(product)

    STACK                         HEAP
    +-------------------+         +----------------------+
    | save() stack frame| ------> | Product object       |
    | product reference |         | fields and values    |
    +-------------------+         +----------------------+
    | caller frame      |         | InMemoryRepository   |
    | repository ref    | ------> | products ArrayList   |
    +-------------------+         +----------------------+
                                             |
                                             v
                                    Stored Product reference

The stack frame exists while the method executes. The Product and repository objects live on the heap. The repository list retains the Product after save() returns, assuming the method stores that reference.

## Conclusion

The main memory risks to monitor are unbounded collection growth, unnecessary collection copies, and loading large files entirely into memory. Use try-with-resources for resource safety and StringBuilder for repeated string construction.