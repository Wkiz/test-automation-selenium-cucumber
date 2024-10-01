# Test Automation Framework with Java, Selenium, and Cucumber

This repository provides a basic setup for automating web application testing using **Java**, **Selenium WebDriver**, and **Cucumber** with **Gherkin** for writing test cases in a human-readable format. It serves as a starting point for anyone looking to build a test automation framework for UI testing.

## Features:
- **Selenium WebDriver** for interacting with web browsers.
- **Cucumber** for behavior-driven development (BDD), enabling writing test cases in plain English using **Gherkin** syntax.
- **JUnit** integration for running the tests.
- Pre-configured **Maven** project for dependency management and easy project build.
- Basic folder structure for organizing test cases, step definitions, and feature files.

## Project Structure:
	test-automation-selenium-cucumber/
	├── .settings
	├── src
	│   ├── main
	│   │   ├── java
	│   │   │   ├── Definitions        
	│   │   │   ├── Pages             
	│   │   │   └── Utils             
	│   └── test
	│       ├── java
	│       │   └── runners           
	│       └── resources
	│           ├── drivers           
	│           └── features          

## Tools & Technologies:
- **Java**: Programming language used for the test framework.
- **Selenium WebDriver**: Browser automation tool.
- **Cucumber**: Framework for BDD-style test cases.
- **JUnit**: Test runner framework.
- **Maven**: Dependency and build management tool.

## How to Get Started:

1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/test-automation-selenium-cucumber.git

2. Install the dependencies using Maven:
    ```bash
    mvn clean install

3. Run the tests:
    ```bash
    mvn test

4. To add or modify test scenarios, navigate to the src/test/resources/features/ directory and edit the .feature files. You can create new step definitions in the src/test/java/steps/ directory.

## Prerequisites:

- JDK 8 or higher installed.
- Maven installed.
- ChromeDriver or any WebDriver executable in your system's PATH.

## Contributing:
Feel free to fork this repository and contribute by adding more test cases, improving existing ones