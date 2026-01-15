# Multi-Language Demo Project

A collection of simple web applications demonstrating different programming languages and their respective package managers.

## 📁 Project Structure

```
multi-lang-demo/
├── nodejs-npm/          # Node.js with NPM
├── nodejs-yarn/         # Node.js with Yarn
├── java-maven/          # Java with Maven
├── java-gradle/         # Java with Gradle
├── python-pip/          # Python with Pip
└── golang/              # Go with Go Modules
```

## 🚀 Quick Start

Each subdirectory contains a standalone project with its own README. Navigate to any project and follow the instructions.

### Node.js NPM (Port 3000)
```bash
cd nodejs-npm
npm install
npm start
```
Visit: http://localhost:3000

### Node.js Yarn (Port 3001)
```bash
cd nodejs-yarn
yarn install
yarn start
```
Visit: http://localhost:3001

### Java Maven (Port 8080)
```bash
cd java-maven
mvn clean install
mvn exec:java
```
Visit: http://localhost:8080

### Java Gradle (Port 8081)
```bash
cd java-gradle
./gradlew build
./gradlew run
```
Visit: http://localhost:8081

### Python Pip (Port 5000)
```bash
cd python-pip
pip install -r requirements.txt
python app.py
```
Visit: http://localhost:5000

### Golang (Port 9000)
```bash
cd golang
go mod download
go run main.go
```
Visit: http://localhost:9000

## 🎨 Features

- Each project serves a unique HTML page with a beautiful gradient design
- Different color schemes for easy identification
- Shows technology stack, package manager, and port information
- Minimal dependencies for quick setup
- Ready to use for testing SBOM generation and vulnerability scanning

## 📋 Port Summary

| Technology | Port |
|------------|------|
| Node.js NPM | 3000 |
| Node.js Yarn | 3001 |
| Java Maven | 8080 |
| Java Gradle | 8081 |
| Python Pip | 5000 |
| Golang | 9000 |

## 🛠️ Prerequisites

- **Node.js**: v14+ (for nodejs-npm and nodejs-yarn)
- **Java**: JDK 11+ (for java-maven and java-gradle)
- **Python**: 3.7+ (for python)
- **Go**: 1.21+ (for golang)
- **Maven**: 3.6+ (for java-maven)
- **Gradle**: 7.0+ (for java-gradle, or use wrapper)

## 📝 Use Cases

- Testing SBOM generation tools
- Vulnerability scanning demonstrations
- Package manager comparison
- Multi-language CI/CD pipeline testing
- Dependency analysis across ecosystems

## 🔧 Customization

Each project is intentionally kept simple. Feel free to:
- Add more dependencies to test vulnerability detection
- Modify HTML pages for branding
- Add API endpoints for testing
- Integrate with CI/CD pipelines

## 📄 License

MIT License - Feel free to use for any purpose.
