@'
# Day 6 - AI-Assisted Stack Trace Debugging

## Stack Trace 1: Invalid Quantity

### Test Input
- Menu choice: 1
- Product: KeyBoard
- Quantity: 0

### Stack Trace
exception.InvalidQuantityException: Quantity must be greater than zero.
    at service.OrderProcessor.processOrder(OrderProcessor.java:15)
    at app.OrderProcessorApp.main(OrderProcessorApp.java:34)

### Explanation
- Exception type: InvalidQuantityException.
- Category: Unchecked exception because it extends RuntimeException.
- Origin: OrderProcessor.java, line 15.
- Call sequence: OrderProcessorApp.main() calls OrderProcessor.processOrder().
- Reason: The quantity is zero, but the business rule requires a positive quantity.
- Recovery: The exception is caught and the menu continues.
- Finally: The audit message is printed.

### Copilot Explanation
Exception type: exception.InvalidQuantityException
Checked or unchecked: Unchecked — InvalidQuantityException.java extends RuntimeException.
Where it was thrown: OrderProcessor.java:15. The code throws it when the quantity is zero or less.
Call path: OrderProcessorApp.java:34 calls processOrder; the exception occurs there and appears in the trace first.
In simple terms, the program received an invalid quantity, so it rejected the order. processOrder rethrows this exception, and its finally block prints the audit message. The app catches the exception, prints an order-failed message and the stack trace, then continues its menu loop. It doesn’t retry the order automatically—the user can choose another action or place a new order.

### Verification
- Correct: The exception type, invalid quantity, and call sequence match the code.
- Correct: The menu continues after the exception.
- To verify: Check that Copilot identifies line 15 as the throw location.
- Incorrect claims: Record any claims that do not match the source code.

## Stack Trace 2: Insufficient Stock

### Test Input
- Menu choice: 1
- Product: KeyBoard
- Quantity: 20
- Initial stock: 10

### Stack Trace
exception.InsufficientStockException: Unable to process order for KeyBoard
    at service.OrderProcessor.processOrder(OrderProcessor.java:35)
    at app.OrderProcessorApp.main(OrderProcessorApp.java:34)
Caused by: exception.InsufficientStockException: Insufficient stock. Available: 10, requested: 20
    at service.OrderProcessor.processOrder(OrderProcessor.java:20)
    ... 1 more

### Explanation
- Exception type: InsufficientStockException.
- Category: Checked exception because it extends Exception.
- Reason: The requested quantity exceeds the available stock.
- Chaining: The outer exception adds product context and preserves the original exception as its cause.
- Origin of original error: OrderProcessor.java, line 20.
- Recovery: The exception is caught and the menu continues.
- Finally: The audit message is printed.

### Copilot Explanation
Exception type: exception.InsufficientStockException
Checked or unchecked: Checked — InsufficientStockException.java extends Exception.
Why it occurred: The processor starts with 10 items in stock, but the order requested 20.
Where it was thrown: The original exception is thrown at OrderProcessor.java:20. The processor catches it and throws a new exception with the product name at OrderProcessor.java:35.
What Caused by means: The first message adds context—“Unable to process order for KeyBoard.” The Caused by section shows the original stock-check e

### Verification
- Correct: The available stock is 10 and the requested quantity is 20.
- Correct: The "Caused by" section preserves the original error.
- Correct: The outer exception adds product-specific context.
- To verify: Check that Copilot distinguishes the wrapping exception from the original cause.
- Incorrect claims: Record any claims that do not match the source code.
'@ | Set-Content "Daily Task\Day 6\AI-Stack-Trace-Notes.md"