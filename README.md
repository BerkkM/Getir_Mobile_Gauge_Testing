### Project Overview:
This project focuses on automating test scenarios for the Getir mobile application. Getir is a delivery application, and the automation framework is built using Java, Appium, and Gauge.

### Project Structure:
1. **BaseTest:**
    - Sets up the Appium driver before scenarios and tears it down after scenarios.
    - Differentiates between local Android testing and iOS testing.

2. **Methods:**
    - Contains reusable methods for interacting with mobile elements.
    - Uses FluentWait for waiting conditions.
    - Provides methods for clicking, typing, handling alerts, and more.
    - Highlights elements for better visualization during execution.

3. **StepImplementation:**
    - Implements the actual steps for the scenarios using Gauge annotations.
    - Interacts with the Methods class to perform actions on the mobile application.
    - Includes steps for opening the application, clicking buttons, changing language, adding addresses, etc.

4. **Constants:**
    - Stores constant values such as device information, package names, XPaths, and IDs.

5. **Example Spec:**
    - Provides a sample Gauge specification with scenarios related to the login process, language change, and address addition.

6. **Concept Files:**
    - Separates scenarios into concept files like "ChangeLang.cpt" and "addAddress.cpt" for better organization.

### Key Features:
- **Reusability:** The project emphasizes code reusability through the Methods class, where common interactions are defined.
- **Maintainability:** Constants are stored separately, making it easy to update application details and locators.
- **Readability:** Gauge annotations in StepImplementation provide clear, readable steps for each scenario.
- **Concept Files:** The use of concept files organizes scenarios by functionality.

### Execution:
- Gauge is used for test execution, and Maven is configured to run tests with the command `mvn test`.

### Note:
- The project encompasses the stages of logging into the Getir application, changing the language, adding an address, and checking for notifications at mandatory input points.