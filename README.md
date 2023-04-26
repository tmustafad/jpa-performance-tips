# Spring Boot JPA Performance Benchmark

This is a small Spring Boot application that benchmarks the performance of different ways of saving entities using JPA.

## Purpose

The purpose of this application is to demonstrate the performance differences between different ways of saving entities using JPA in Spring Boot. The application contains a simple `Customer` entity and a `CustomerRepository` interface that extends the `JpaRepository` interface provided by Spring Data JPA.

The `CustomerRepositoryTest` class contains tests that measure the performance of the `save`, `saveAll`, and custom `saveCustomers` methods defined in the `CustomerRepository` and `CustomerRepositoryImpl` classes. The `save` method saves a single entity, the `saveAll` method saves multiple entities at once, and the `saveCustomers` method uses batch processing to improve performance when saving multiple entities.

The purpose of the tests is to measure the time it takes to save a large number of entities using each method, and to compare the performance of each method to determine which one is the most efficient.

## Technologies Used

- Java 17
- Spring Boot 2.5.0
- Spring Data JPA
- H2 in-memory database
- JUnit 5

## How to Run

1. Clone the repository to your local machine.
2. Open a terminal and navigate to the project directory.
3. Run the following command to build the project: `./mvnw clean package`
4Run the `CustomerRepositoryTest` class to execute the performance tests.

## Results

The results of the performance tests are displayed in the console output when the `CustomerRepositoryTest` class is run. The tests measure the time it takes to save 1000 `Customer` entities using each method, and compare the performance of each method.

The results show that the `saveAll` method is more efficient than the `save` method, as it reduces the number of SQL statements that need to be executed. However, the custom `saveCustomers` method is even more efficient, as it uses batch processing to further reduce the number of SQL statements and the overhead of starting and committing transactions.

## Conclusion

In conclusion, the custom `saveCustomers` method provides the best performance when saving a large number of entities using JPA in Spring Boot. This method uses batch processing to reduce the number of SQL statements and the overhead of starting and committing transactions, resulting in the fastest performance.
