# Node.js NPM Demo

A simple Node.js web application using NPM package manager.

## Setup

```bash
npm install
```

## Run

```bash
npm start
```

Visit: http://localhost:3000

## Test Dependencies for SSCA

This project includes specific dependency versions to test various SSCA (Software Supply Chain Assurance) scenarios:

### Remediation Test Cases

### 1. Dependency is Direct Dependency, Outdated and has known vulnerabilities
Package: `express@4.17.1`, `qs@6.7.0`    
1. Remediation section should show Target Versions dropdown with recommended version by default selected. 
2. AI Generated Summary should be visible
3. Vulnerabilities from the target versions should be visible. It should mention details about the vulnerabilities changes
   - No significant change in vulnerability severity(Select Target Version: 4.17.2)
   - Few vulnerabilities got fixed in this version(Select Target Version: 4.19.2)
   - No vulnerabilities detected in this version(Selct Recommended Version)
   - New vulnerabilities introduced in this version
   - Few vulnerabilities have been fixed, but some new got introduced
4. Top Impacted Dependencies should show 5 impacted dependencies with change type as **ADDED/MODIFIED/REMOVED** along with vulnerabilities count.


### 2. Dependency is Direct Dependency, Outdated and has no known vulnerabilities
Package: `core-js`
1. Remediation section should show Target Versions dropdown with recommended version by default selected. 
2. AI Generated Summary should be visible
3. Recommende version should also not be vulnerable.
4. Top Impacted Dependencies should show 5 impacted dependencies with change type as **ADDED/MODIFIED/REMOVED** along with vulnerabilities count.

### 3. Dependency is Transitive Dependency
Package: Single Parent: `body-parser@1.19.0`, Multiple Parent: `mime-types@2.1.35`

1. Remediation section should show warnings `Dependency body-parser is dependent on express@4.17.1. Kindly review and upgrade express@4.17.1` and should have review link which shall redirect to the express dependency remediation.
2. AI Generated Summary should be visible
3. Target versions dropdown should not be visible
4. Top Impacted Dependencies should not be visible

### 4. Dependency is Direct Dependency, End of Life(Definite/Derived)
Package: Derived: `moment@2.29.1`, Definite: `uuid@3.4.0`
1. Remediation section should show warnings `package@version has reached End of Life (EOL) and is no longer supported by the maintainer. Continued use may pose long-term maintenance and security risks.`
2. AI Generated Summary should be visible with possible alternatives if available and mention any significant changes required for migrating to the alternatives.
3. Target versions dropdown should not be visible
4. Top Impacted Dependencies should not be visible

### 5. Dependency is Direct Dependency, Close to End of Life
Package `follow-redirects@1.14.1`
1. Remediation section should show warnings `Component package@version is outdated and contains known security vulnerabilities. Upgrade to newer versions to remediate these issues.`
2. AI Generated Summary should be visible with vulnerabilities details and state of the component
3. Target versions dropdown should be visible with recommended version by default selected
4. Top Impacted Dependencies should show 5 impacted dependencies with change type as **ADDED/MODIFIED/REMOVED** along with vulnerabilities count.(If any dependencies are there for the packages)

### 6. Dependency is Unknown Dependency
Package `ansi-styles@3.2.1`
1. Remediation section should show warnings `We are unable to determine the dependency source for this component due to insufficient metadata. As a result, remediation guidance is not available.`
2. AI Generated Summary should be visible with vulnerabilities details and state of the component along with why component remediation is not available for this component.