# Web Automation Framework

A Playwright-based test automation framework for web application testing, featuring Page Object Model design pattern and organized test suites.

## Overview

This framework is designed to automate testing of web applications using Playwright. It includes smoke and regression test suites, with a focus on maintainable and scalable test automation.

## Features

- **Playwright Test Framework**: Modern, reliable end-to-end testing
- **Page Object Model**: Clean separation of test logic and page interactions
- **Test Data Management**: Centralized test data handling
- **Multiple Test Suites**: Organized smoke and regression tests
- **Cross-browser Support**: Configurable browser testing
- **Rich Reporting**: HTML reports with screenshots and videos on failure

## Prerequisites

- Node.js (v16 or higher)
- npm or yarn

## Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd web-automation
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

## Project Structure

```
web-automation/
├── pages/                 # Page Object Model classes
│   └── LoginPage.ts      # Login page interactions
├── tests/                 # Test suites
│   ├── smoke/            # Smoke tests
│   │   ├── login.spec.ts
│   │   └── login-negative.spec.ts
│   └── regression/       # Regression tests
├── test-data/            # Test data files
│   └── users.ts          # User credentials and data
├── utils/                # Utility functions
├── fixtures/             # Test fixtures
├── playwright.config.ts  # Playwright configuration
└── package.json          # Project dependencies and scripts
```

## Configuration

The framework is configured via `playwright.config.ts`:

- **Base URL**: https://www.saucedemo.com (demo e-commerce site)
- **Browser**: Chromium (Desktop Chrome)
- **Parallel Execution**: 2 workers
- **Retries**: 1 retry on failure
- **Timeouts**: 30s test timeout, 5s expect timeout
- **Reporting**: HTML reports with traces, screenshots, and videos on failure

## Running Tests

### Run All Tests
```bash
npm test
```

### Run Tests with UI Mode
```bash
npm run test:ui
```

### Run Tests in Headed Mode (visible browser)
```bash
npm run test:headed
```

### View Test Reports
```bash
npm run report
```

### Run Specific Test Suites

#### Smoke Tests
```bash
npx playwright test tests/smoke/
```

#### Regression Tests
```bash
npx playwright test tests/regression/
```

#### Specific Test File
```bash
npx playwright test tests/smoke/login.spec.ts
```

## Writing Tests

### Using Page Objects

Tests use the Page Object Model for clean, maintainable code:

```typescript
import { test } from '@playwright/test';
import { LoginPage } from '../pages/LoginPage';
import { users } from '../test-data/users';

test('valid user can login', async ({ page }) => {
  const loginPage = new LoginPage(page);
  await loginPage.goto();
  await loginPage.login(users.standard.username, users.standard.password);
  await loginPage.verifyLoginSuccess();
});
```

### Test Data

Test data is centralized in `test-data/` directory:

```typescript
export const users = {
  standard: {
    username: 'standard_user',
    password: 'secret_sauce',
  },
  locked: {
    username: 'locked_out_user',
    password: 'secret_sauce',
  },
};
```

## Test Results

- **HTML Report**: Generated in `playwright-report/` directory
- **Screenshots**: Captured on test failures
- **Videos**: Recorded on test failures
- **Traces**: Available for debugging failed tests

## Best Practices

1. **Page Objects**: Keep page interactions in dedicated page classes
2. **Test Data**: Use centralized test data files
3. **Selectors**: Prefer semantic selectors (roles, labels) over CSS/XPath
4. **Assertions**: Use Playwright's expect assertions
5. **Parallel Execution**: Tests run in parallel for faster execution
6. **Retries**: Automatic retries on flaky tests

## Contributing

1. Follow the existing code structure and naming conventions
2. Add new page objects for new pages/features
3. Update test data files for new test scenarios
4. Ensure tests pass before submitting changes
5. Add appropriate comments and documentation

## Troubleshooting

- **Browser Installation**: Run `npx playwright install` if browsers are missing
- **Test Timeouts**: Increase timeout values in config for slow environments
- **Flaky Tests**: Use retries or add wait conditions
- **Debugging**: Use `--debug` flag or UI mode for step-through debugging