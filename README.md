# Here is my Selenium WebDriver Automation Code in Java

# 📘 RecruitBPM Selenium Automation Suite
This is a Selenium-based automation framework developed to test various workflows and actions within the RecruitBPM application. It leverages Java, Maven, TestNG, and Selenium WebDriver for robust end-to-end testing.

# 📂 Project Structure

FinalRecruit-master/
├── src/
│   └── test/
│       └── java/
│           ├── Appointment_Inner_Action_list/
│           ├── Campaigns_Action_List/
│           ├── Candidate_Action_List/
│           └── ...
├── pom.xml
├── .classpath / .project / .settings/
├── .vscode/
└── README.md

# 🧰 Tech Stack
- Java 11+

- Selenium WebDriver 4.10.0

- Maven (Dependency Management)

- TestNG (Test execution & reporting)

- Tess4J (Optical Character Recognition)

- Apache Commons CSV (CSV file handling)

# ✅ Features Automated
- Appointment workflows (Attach Documents, New Reminder, etc.)

- Campaign actions (Add Notes, Assign Tags, Manage Tags)

- Candidate management (Upload docs, Notes, Tagging)

- OCR-based validation with Tess4J

- Data-driven tests using CSV input

# 🚀 Getting Started
# 1. Clone the Repository

git clone https://github.com/yourusername/FinalRecruit.git
cd FinalRecruit

# 2. Import into IDE
- Open with Eclipse or IntelliJ

- As a Maven project (auto-import dependencies)

# 3. Run Tests

mvn clean test

# ⚙️ Prerequisites
- Java JDK 11+

- Maven 3.6+

- ChromeDriver or GeckoDriver in system PATH

- Chrome/Firefox browser installed

# 📸 Screenshots or Logs
The framework may generate logs (like replay_pid*.log, hs_err_pid*.log) for test execution and debugging.

# 🤖 OCR Support
The project uses Tess4J to extract and validate textual content from images/screenshots when needed.

# 📄 License
This project is licensed under the MIT License.

