# WebGoat Legacy

[![DepShield Badge](https://depshield.sonatype.org/badges/WebGoat/WebGoat-Legacy/depshield.svg)](https://depshield.github.io)

## Overview

WebGoat Legacy is an educational platform designed to demonstrate common server-side application vulnerabilities. It provides a hands-on environment for learning application penetration testing techniques. This version is based on WebGoat 5 with an updated user interface.

**WARNING:** This application is intentionally vulnerable. Do not run it on a production system or a machine connected to the internet.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Easy Run Instructions](#easy-run-instructions)
  - [Standard Run Instructions](#standard-run-instructions)
- [Development](#development)
- [Documentation](#documentation)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Features

- Demonstrates common server-side vulnerabilities.
- Hands-on exercises for penetration testing.
- Educational resources for security professionals and developers.
- Multi-language support for labels and instructions.

## Getting Started

### Easy Run Instructions (For Non-Developers)

**Prerequisites:**
- Java VM >= 1.6 (JDK 1.7 recommended)

1. Download the executable JAR file:
   [WebGoat-6.0.1-war-exec.jar](https://webgoat.atlassian.net/builds/browse/WEB-WGM/latestSuccessful/artifact/shared/WebGoat-Embedded-Tomcat/WebGoat-6.0.1-war-exec.jar)

2. Run the application:
   ```bash
   java -jar WebGoat-6.0-exec-war.jar
   ```

3. Open your browser and navigate to:
   [http://localhost:8080/WebGoat](http://localhost:8080/WebGoat)

4. To customize the port or other options, use:
   ```bash
   java -jar WebGoat-6.0-exec-war.jar --help
   ```

### Standard Run Instructions (For Developers)

**Prerequisites:**
- Java >= 1.6 (JDK 1.7 recommended)
- Maven > 2.0.9
- Git
- IDE with Maven support (e.g., NetBeans, IntelliJ, Eclipse)

1. Clone the repository:
   ```bash
   git clone https://github.com/WebGoat/WebGoat-Legacy.git
   ```

2. Build the project:
   ```bash
   cd WebGoat-Legacy
   mvn clean package
   ```

3. Run the application:
   ```bash
   mvn tomcat:run-war
   ```

4. Access the application at:
   [http://localhost:8080/WebGoat](http://localhost:8080/WebGoat)

## Development

The project structure includes:

- **`src/main/java`**: Java source code for the application.
- **`src/main/resources`**: Configuration files and multi-language support.
- **`src/main/webapp`**: Frontend resources (HTML, CSS, JS).
- **`test/java`**: Unit tests.

### Key Files

- `pom.xml`: Maven configuration.
- `Dockerfile`: Docker setup for containerized deployment.
- `README.md`: Project documentation.

## Documentation

Additional resources are available in the `doc/` directory:

- **Solving the WebGoat Labs.doc**: Step-by-step solutions for exercises.
- **WebGoat Users Guide.doc**: User manual for the application.

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a feature branch:
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Description of changes"
   ```
4. Push to your fork:
   ```bash
   git push origin feature-name
   ```
5. Submit a pull request.

## License

This project is licensed under the [OWASP License](https://owasp.org).

## Contact

- **Project Lead**: Bruce Mayhew ([webgoat@owasp.org](mailto:webgoat@owasp.org))
- **Mailing List**: [owasp-webgoat@lists.owasp.org](mailto:owasp-webgoat@lists.owasp.org)

For more information, visit the [WebGoat GitHub Page](https://github.com/WebGoat/).
