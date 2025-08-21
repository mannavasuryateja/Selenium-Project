# Selenium Automated Login Tester

This project automates login functionality testing using **Java + Selenium WebDriver + TestNG**.

## Features
- Positive & Negative login test cases
- Automated browser testing
- TestNG integration with reporting
- Easy to run via Maven

## Setup
1. Install Java (JDK 11+), Maven.
2. Download ChromeDriver for your Chrome version from https://chromedriver.chromium.org/downloads
   and place it in the project root or add it to your PATH. On Linux/macOS the binary name is usually `chromedriver`,
   on Windows `chromedriver.exe`. Update the path in `LoginTest.java` if needed.
3. Clone repo:
   ```bash
   git clone https://github.com/yourusername/Selenium-Login-Tester.git
   cd Selenium-Login-Tester
   ```
4. Run tests:
   ```bash
   mvn test
   ```

## Demo Site Used
[Herokuapp Login Page](https://the-internet.herokuapp.com/login)

## Author
Suryateja Mannava
