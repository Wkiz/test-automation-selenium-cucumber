# UI Test Automation with Java, Selenium, and Cucumber

![CI](https://img.shields.io/badge/CI-GitHub%20Actions-blue)
![Java](https://img.shields.io/badge/Java-17-orange)
![Selenium](https://img.shields.io/badge/Selenium-4.10-green)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-yellow)

This project is a polished example of a UI test automation framework built with Java, Selenium WebDriver, Cucumber, and JUnit. It demonstrates how to structure readable, maintainable, and behavior-driven automated tests for a real browser flow.

## Why this project stands out
- Shows solid automation testing fundamentals.
- Implements Behavior-Driven Development with Gherkin.
- Uses the Page Object Model to keep the code maintainable.
- Includes a clean structure suitable for portfolio and learning purposes.
- Is ready to be extended with CI, reporting, and richer scenarios.

## Tech stack
- Java 17
- Maven
- Selenium WebDriver
- Cucumber
- JUnit 5
- WebDriverManager

## Project structure
```text
src/
  main/
    java/
      Definitions/
      Pages/
      Utils/
  test/
    java/
      runners/
      Utils/
    resources/
      features/
      drivers/
```

## Getting started
1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/test-automation-selenium-cucumber.git
   ```
2. Install dependencies:
   ```bash
   mvn clean install
   ```
3. Run the tests:
   ```bash
   mvn test
   ```

## Example test flow
The current scenario automates a Google search journey:
- opens the homepage,
- enters a search term,
- validates suggestions,
- selects one suggestion,
- verifies the search results page.

## CAPTCHA handling
This project includes a **basic CAPTCHA handling** mechanism for demonstration purposes.

- When the standard **"I'm not a robot"** checkbox is displayed, the automation attempts to interact with it by simply clicking the checkbox.
- If Google determines that additional verification is required and presents the **advanced image or challenge CAPTCHA**, the automation cannot solve it automatically.

This limitation is expected, as advanced CAPTCHA challenges are specifically designed to prevent automated interaction. Therefore, tests requiring manual CAPTCHA resolution should be completed manually before continuing.

## Continuous Integration
A GitHub Actions workflow is included to run the suite automatically on push and pull requests. The workflow is defined in [.github/workflows/ci.yml](.github/workflows/ci.yml).

## Screenshots and evidence
A dedicated folder for visual evidence and execution captures is included in [docs/screenshots/README.md](docs/screenshots/README.md).

## What this project demonstrates
- Clean separation between test logic and UI interactions.
- Real-world usage of BDD with Cucumber.
- Practical Selenium automation patterns.
- A solid base for scaling into a larger automation framework.

## Portfolio-ready summary
> A BDD-based UI automation framework built in Java with Selenium and Cucumber, designed to demonstrate clean test architecture, maintainable page objects, and real browser automation flows.
