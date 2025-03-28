# Stepwise Selenium Test Automation Framework

This project is an advanced Selenium test automation framework for web applications. It provides a modular and maintainable test infrastructure using the Page Object Model (POM) design pattern.

## 🚀 Features

- **Page Object Model**: Prevents code duplication by separating test scenarios and page elements
- **Driver Management**: Customized driver management for Chrome, Firefox, and Edge
- **Test Data Generation**: Dynamic test data generation using JavaFaker library
- **Reporting**: Detailed test reports with ExtentReports
- **Configuration Management**: Environment-based configuration using properties files
- **Utility Classes**: Helper methods for common operations
- **Logging**: Comprehensive logging system with SLF4J
- **CI/CD Integration**: Automated testing with GitHub Actions

## 📁 Project Structure

```
src/
├── main/
│   └── java/
│       └── com/
│           └── stepwise/
│               ├── driver/           # WebDriver management
│               ├── pages/            # Page Object classes
│               ├── tests/            # Test scenarios
│               └── utilities/        # Helper classes
└── test/
    └── resources/
        └── config/                  # Configuration files
```

## 🛠️ Technologies

- Java 17
- Selenium WebDriver
- Cucumber
- Maven
- ExtentReports
- JavaFaker
- SLF4J
- GitHub Actions

## ⚙️ Installation

1. Clone the project:
```bash
git clone https://github.com/mr10er/stepwiseSelenium.git
```

2. Install Maven dependencies:
```bash
mvn clean install
```

3. Download and add WebDrivers to PATH:
   - ChromeDriver
   - GeckoDriver (Firefox)
   - EdgeDriver

## 📝 Usage

### Running Tests Locally

```bash
# Run all tests
mvn clean test

# Run a specific test class
mvn clean test -Dtest=ContactPageTest

# Run a specific test method
mvn clean test -Dtest=ContactPageTest#testContactForm
```

### Viewing Reports

Test reports are generated in the `test-output/ExtentReports` directory.

## 🔧 Configuration

Using properties files in `src/test/resources/config` directory, you can configure:
- Test environment
- Timeout values
- Test data
- Reporting settings

## 📚 Example Usage

```java
// Page Object usage
ContactPage contactPage = new ContactPage(driver);
contactPage.navigateToPage();
contactPage.fillPersonalInformation("John", "Doe", "john@example.com");
contactPage.clickSubmitButton();

// Test data generation
TestDataGenerator dataGenerator = TestDataGeneratorFactory.getGenerator();
String email = dataGenerator.generateEmail();
String name = dataGenerator.generateFullName();
```

## 🔄 CI/CD Pipeline

This project includes a GitHub Actions workflow that automatically runs tests on:
- Push to `main` and `develop` branches
- Pull requests to `main` and `develop` branches

### Pipeline Features

- **Automated Setup**:
  - JDK 11 installation
  - Browser installation (Chrome, Firefox, Edge)
  - WebDriver management
  - Maven build and test execution

- **Reporting**:
  - Test execution reports
  - ExtentReports generation
  - Automatic artifact uploads
  - Failure notifications

### Viewing CI/CD Results

1. Go to the "Actions" tab in your GitHub repository
2. Select the workflow run you want to view
3. Check the "Artifacts" section for test reports
4. Review the test results and logs

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'feat: Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📞 Contact

Project Owner - [@mr10er](https://github.com/mr10er)

Project Link: [https://github.com/mr10er/stepwiseSelenium](https://github.com/mr10er/stepwiseSelenium)

## 🙏 Acknowledgments

- Selenium WebDriver team
- Cucumber team
- JavaFaker contributors
- ExtentReports team 