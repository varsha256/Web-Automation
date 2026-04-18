import { test } from '@playwright/test';
import { LoginPage } from '../../pages/LoginPage';
import { users } from '../../test-data/users';

test('locked user should not be able to login', async ({ page }) => {
  const loginPage = new LoginPage(page);

  await loginPage.goto();
  await loginPage.login(users.locked.username, users.locked.password);

  await loginPage.verifyErrorMessage(
    'Epic sadface: Sorry, this user has been locked out.'
  );
});