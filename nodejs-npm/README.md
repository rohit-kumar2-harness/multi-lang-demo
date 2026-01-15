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

| Package | Version | CVEs | Test Scenario |
|---------|---------|------|---------------|
| `lodash` | 4.17.15 | 3 | **Partial remediation path**: 4.17.15 (3 CVEs) → 4.17.21 (0 CVEs) |
| `tar` | 6.1.0 | 6 | **Multiple vulnerabilities**: High CVE count, tests bulk vulnerability listing & pagination |
| `axios` | 0.21.1 | 4 | **Multiple CVEs**: SSRF, ReDoS vulnerabilities |
| `minimist` | 1.2.5 | 1 | **Prototype pollution**: Common transitive dependency vulnerability |
| `jsonwebtoken` | 8.5.1 | 3 | **Auth library CVEs**: Security-sensitive package with multiple CVEs |
| `moment` | 2.29.1 | 2 | **Deprecated package**: Tests handling of unmaintained packages with CVEs |
| `express` | 4.17.1 | 2 | **Framework CVEs**: Tests vulnerabilities in core framework |
| `uuid` | 13.0.0 | 0 | **Clean baseline (latest)**: No CVEs, tests ALREADY_LATEST_VERSION validation |
| `@angular/core` | 14.0.0 | 1 | **Scoped package PURL**: Tests `pkg:npm/%40angular/core@14.0.0` URL encoding |
| `@babel/core` | 7.12.0 | 0 | **Scoped package (clean)**: Tests `pkg:npm/%40babel/core@7.12.0` URL encoding |
| `lodash.merge` | 4.6.1 | 1 | **Dotted package name**: Tests `pkg:npm/lodash.merge@4.6.1` PURL parsing |
| `node-forge` | 1.2.1 | 6 | **Hyphenated name + high CVEs**: Tests PURL with hyphens & pagination |
| `qs` | 6.5.2 | 2 | **Short package name**: Tests minimal PURL `pkg:npm/qs@6.5.2` |
| `request` | 2.85.0 | 1 | **Deprecated/Unmaintained**: Tests UNMAINTAINED_VULNERABLE validation |
| `core-js` | 3.27.0 | 0 | **Outdated version**: Tests OUTDATED_NON_VULNERABLE validation (latest is 3.47.0) |
| `chokidar` | 5.0.0 | 0 | **Latest version**: Tests ALREADY_LATEST_VERSION validation |
| `angular` | 1.8.3 | 9 | **EOL with CVEs**: AngularJS EOL Dec 2021, tests EOL_VULNERABLE validation |
| `tslint` | 6.1.3 | 0 | **EOL without CVEs**: TSLint deprecated 2019, tests EOL_NON_VULNERABLE validation |

### Remediation Test Cases

1. **Simple fix available**: `minimist` 1.2.5 → 1.2.6 fixes the CVE
2. **Partial fix path**: `lodash` requires multiple upgrades to fully remediate
3. **Multiple CVEs single package**: `tar` 6.1.0 has 6 CVEs with different fix versions
4. **Deprecated with no fix**: `moment` is deprecated, alternative package recommended
5. **Clean component**: `uuid` has no vulnerabilities for baseline testing

### API Validation Test Cases

| Test Case | Package | PURL Format |
|-----------|---------|-------------|
| **Scoped package (URL encoded)** | `@angular/core` | `pkg:npm/%40angular/core@14.0.0` |
| **Scoped package (URL encoded)** | `@babel/core` | `pkg:npm/%40babel/core@7.12.0` |
| **Dotted package name** | `lodash.merge` | `pkg:npm/lodash.merge@4.6.1` |
| **Hyphenated package name** | `node-forge` | `pkg:npm/node-forge@1.2.1` |
| **Short package name** | `qs` | `pkg:npm/qs@6.5.2` |
| **Standard package** | `express` | `pkg:npm/express@4.17.1` |

### Pagination Test Cases

- `tar` (6 CVEs) and `node-forge` (6 CVEs) - Test pagination with `limit=2, page=0,1,2`
- `lodash` (3 CVEs) - Test pagination boundary with `limit=2, page=0,1`
- `uuid` (0 CVEs) - Test empty results pagination

### Remediation Validation Test Cases

Based on `RemediationValidationServiceImpl.java` validation scenarios:

| Validation Type | Package | Scenario |
|-----------------|---------|----------|
| **CAN_REMEDIATE** | `lodash@4.17.15` | Has 3 CVEs, not latest, can upgrade to 4.17.21 |
| **ALREADY_LATEST_VERSION** | `chokidar@5.0.0`, `uuid@13.0.0` | Latest versions, no upgrade needed |
| **OUTDATED_VULNERABLE** | `tar@6.1.0` | Outdated with 6 CVEs, can remediate with warning |
| **OUTDATED_NON_VULNERABLE** | `core-js@3.27.0` | Outdated (3.27.0 vs 3.47.0), no CVEs, info message |
| **UNMAINTAINED_VULNERABLE** | `moment@2.29.1`, `request@2.85.0` | Deprecated with CVEs, cannot remediate |
| **EOL_VULNERABLE** | `angular@1.8.3` | AngularJS EOL Dec 2021, 9 CVEs, no fixes coming |
| **EOL_NON_VULNERABLE** | `tslint@6.1.3` | TSLint deprecated 2019, 0 CVEs, no fixes coming |
| **TRANSITIVE_DEPENDENCY** | (via `express`) | Transitive deps like `qs` pulled by express |
| **TARGET_VERSION_NOT_FOUND** | Any package | Test with non-existent version like `99.99.99` |
| **UNKNOWN_DEPENDENCY_TYPE** | - | Depends on SBOM generation marking dependency type |

### Edge Case: Newer Version Introduces Vulnerability

**Note:** After extensive search on deps.dev, no npm package was found where a newer version within the same major series introduces a new vulnerability that didn't exist in an earlier version. The npm ecosystem typically shows:
- Vulnerabilities discovered retroactively (affecting a range of versions)
- Monotonic decrease pattern (CVEs fixed in newer versions)

This test case may need to be:
1. Simulated with mock data
2. Found in other ecosystems (Maven, PyPI, Go)
3. Tested when such a package is discovered in the future
