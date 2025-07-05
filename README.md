# String Calculator TDD Kata

## Project Description
This project is an implementation of the **String Calculator TDD Kata**, an interview assignment designed to demonstrate proficiency in Test-Driven Development (TDD) using Java. The String Calculator is a simple utility that processes a string input containing numbers and returns their sum based on specific rules and requirements. The project follows a TDD approach, ensuring robust code through iterative test cases and refactoring.

The calculator supports various input formats, including comma-separated numbers, new-line separators, custom delimiters, and multiple delimiters of varying lengths. It also handles edge cases such as empty strings, negative numbers (which throw exceptions), and numbers greater than 1000 (which are ignored).

This repository showcases clean, maintainable code with comprehensive unit tests to validate functionality.

---

## Features
The String Calculator implements the following functionality:
1. **Basic Addition**:
   - Takes a string of up to two numbers separated by commas (e.g., `"1,2"`) and returns their sum (e.g., `3`).
   - Returns `0` for an empty string (`""`).
   - Supports a single number (e.g., `"1"` returns `1`).

2. **Unlimited Numbers**:
   - Handles an unknown number of numbers in the input string (e.g., `"1,2,3,4,5"` returns `15`).

3. **New Line Support**:
   - Accepts new lines (`\n`) as delimiters in addition to commas (e.g., `"1\n2,3"` returns `6`).
   - Invalid inputs like `"1,\n"` are not supported.

4. **Custom Delimiters**:
   - Supports custom delimiters specified at the start of the string (e.g., `"//;\n1;2"` returns `3`, using `;` as the delimiter).
   - All existing scenarios (comma and new-line delimiters) are still supported.

5. **Negative Numbers**:
   - Throws an exception with the message `"negative numbers not allowed"` followed by the negative numbers found (e.g., `"1,-1,2,-2"` throws `"negative numbers not allowed [-1, -2]"`).

6. **Ignore Large Numbers**:
   - Numbers greater than 1000 are ignored (e.g., `"2,1001,1"` returns `3`).

7. **Arbitrary-Length Delimiters**:
   - Supports delimiters of any length (e.g., `"//[***]\n1***2***3"` returns `6`).

8. **Multiple Delimiters**:
   - Handles multiple delimiters of any length (e.g., `"//[*][%]\n1*2%3"` returns `6` or `"//[**][%]\n1**2%3"` returns `6`).

---

## Input and Output Examples
Below are examples of inputs and their corresponding outputs:

| Input                     | Output | Description                                      |
|---------------------------|--------|--------------------------------------------------|
| `""`                      | `0`    | Empty string returns 0.                          |
| `"1"`                     | `1`    | Single number returns its value.                 |
| `"1,2"`                   | `3`    | Two numbers separated by a comma.                |
| `"1,2,3,4,5"`            | `15`   | Multiple numbers separated by commas.            |
| `"1\n2,3"`               | `6`    | Numbers separated by new lines and commas.       |
| `"//;\n1;2"`             | `3`    | Custom delimiter `;` specified.                  |
| `"1,-1,2,-2"`            | Throws | Exception: `"negative numbers not allowed [-1, -2]"` |
| `"2,1001,1"`             | `3`    | Numbers > 1000 are ignored.                      |
| `"//[***]\n1***2***3"`   | `6`    | Custom delimiter of arbitrary length.            |
| `"//[*][%]\n1*2%3"`      | `6`    | Multiple custom delimiters.                     |
| `"//[**][%]\n1**2%3"`    | `6`    | Multiple delimiters with length > 1.            |

---

## Technologies Used
- **Java**: The core programming language used to implement the String Calculator logic.
- **JUnit 5**: Used for writing and running unit tests to validate the functionality of the calculator.
- **Maven**: Used as the build tool to manage dependencies and run tests.

---

## Project Structure
```
Incubyte-String-Calculator-TDD-Kata/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/nisarg/
│   │           └── StringCalculator.java  # Main calculator implementation
│   ├── test/
│   │   └── java/
│   │       └── StringCalculatorValidator.java  # JUnit test cases
├── pom.xml  # Maven configuration file
├── README.md  # This file
```

---

## Setup and Installation
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Nisarg48/Incubyte-String-Calculator-TDD-Kata.git
   cd Incubyte-String-Calculator-TDD-Kata
   ```

2. **Install Dependencies**:
   Ensure you have Maven installed. Run the following command to download dependencies:
   ```bash
   mvn clean install
   ```

3. **Run Tests**:
   Execute the JUnit tests to verify the implementation:
   ```bash
   mvn test
   ```

---

## Running the Application
The project is a library with a single `StringCalculator` class. To use it, instantiate the `StringCalculator` class and call its methods (`add`, `DelimiterWithNumbers`, `DelimiterWithAnyLength`, or `addWithMultipleCustomDelimiter`) with appropriate input strings.

Example usage:
```java
StringCalculator calculator = new StringCalculator();
int result = calculator.add("1,2,3"); // Returns 6
System.out.println(result);
```

---

## Testing
The project includes a comprehensive test suite in `StringCalculatorValidator.java` that covers all requirements using JUnit 5. Tests validate:
- Empty string input
- Single and multiple number inputs
- New-line and comma-separated inputs
- Custom delimiters (single and multiple, including arbitrary lengths)
- Negative number handling (exception throwing)
- Ignoring numbers greater than 1000

To run the tests:
```bash
mvn test
```

---

## Development Approach
This project was developed using **Test-Driven Development (TDD)**:
1. Write a failing test for the simplest case (e.g., empty string).
2. Implement the minimal code to pass the test.
3. Refactor the code to improve clarity and maintainability.
4. Repeat for increasingly complex cases, ensuring all requirements are met.

Each test case was designed to force the implementation to handle new requirements incrementally, resulting in robust and well-tested code.

---

![image](https://github.com/user-attachments/assets/74811fab-a874-4e30-94dd-a13f72cfc7d7)
