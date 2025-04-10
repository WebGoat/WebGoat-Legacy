# WebGoat Legacy

[![DepShield Badge](https://depshield.sonatype.org/badges/WebGoat/WebGoat-Legacy/depshield.svg)](https://depshield.github.io)

## Overview

WebGoat Legacy is a demonstration of common server-side application flaws. It is designed to teach application penetration testing techniques through hands-on exercises. This version is based on WebGoat 5 with a new user interface.

**WARNING:** This program is for educational purposes only. Running it will make your machine vulnerable to attacks. Disconnect from the Internet while using it.

## Features

- Hands-on exercises to learn about application security vulnerabilities.
- Demonstrates common server-side application flaws.
- Includes a modernized user interface.
- Supports easy and standard run modes for both non-developers and developers.

## Prerequisites

- **Java VM**: Version >= 1.6 (JDK 1.7 recommended).
- **Maven**: Version > 2.0.9 (for developers).
- **IDE**: NetBeans, IntelliJ, or Eclipse with Maven support (for developers).
- **Git**: Required for source code management.

## Easy Run Instructions (For Non-Developers)

1. Download the executable jar file:
   [WebGoat-6.0.1-war-exec.jar](https://webgoat.atlassian.net/builds/browse/WEB-WGM/latestSuccessful/artifact/shared/WebGoat-Embedded-Tomcat/WebGoat-6.0.1-war-exec.jar)
2. Run it using Java:
   ```
   java -jar WebGoat-6.0-exec-war.jar
   ```
3. Open your browser and navigate to:
   [http://localhost:8080/WebGoat](http://localhost:8080/WebGoat)
4. To change the port or other options, use:
   ```
   java -jar WebGoat-6.0-exec-war.jar --help
   ```

## Standard Run Instructions (For Developers)

1. Clone the repository:
   ```
   git clone https://github.com/WebGoat/WebGoat-Legacy.git
   ```
2. Build the project using Maven:
   ```
   cd webgoat
   mvn clean package
   ```
3. Run the project in an embedded Tomcat server:
   ```
   mvn tomcat:run-war
   ```
4. Alternatively, run the executable jar file:
   ```
   cd target
   java -jar WebGoat-6.0-exec-war.jar
   ```

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes and push them to your fork.
4. Submit a pull request with a detailed description of your changes.

## License

This project is licensed under the [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0).

## Support

For questions or support, please use the following resources:

- [WebGoat Wiki](https://github.com/WebGoat/WebGoat-Legacy/wiki)
- [Mailing List](mailto:owasp-webgoat@lists.owasp.org)
- [Contact Bruce Mayhew](mailto:webgoat@owasp.org)

## Additional Resources

- [Home Page](http://webgoat.github.io)
- [OWASP Project Home Page](http://www.owasp.org/index.php/Category:OWASP_WebGoat_Project)
- [FAQ](http://code.google.com/p/webgoat/wiki/FAQ)

Thank you for using WebGoat Legacy!
