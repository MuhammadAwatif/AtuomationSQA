# **SauceDemo Test Automation**

## A test automation framework for SauceDemo using Java, Selenium, Cucumber, and Allure.

### Table of Contents

* Description
* Prerequisites
* Test Cases Covered
* Setup
* Running Tests
* Reporting

### Description

This framework is designed to automate end-to-end tests for the SauceDemo online shopping platform. The tests cover user authentication, product operations, cart functionalities, and checkout processes.

### Prerequisites

Java 11 or later.
Maven
Allure (for reporting)
Chrome Web Browser

### Test Cases Covered
1. Login Scenarios - Positive and Negative
2. Product Screen
   1. Filter Products
   2. Add and Remove Products
   3. Logout
3. Cart Screen Scenarios
4. Checkout - Positive and Negative

All the test cases are designed and developed with proper **logging** of each step and **Error Handling**.

### Setup

##### Clone the repository:

`git clone https://github.com/MuhammadAwatif/AtuomationSQA`

##### Navigate to the project directory

##### Install the dependencies:
`mvn clean`

`mvn install`

##### Running Tests

To run the tests, simply use the following Maven command:

`mvn test`

This will execute all the feature files and step definitions, running the tests on the default web browser.

##### Reporting

This project uses Allure for test reporting. After a test run, you can generate and view the Allure report using:

`allure serve allure-results`

This will display an interactive report in your default web browser.