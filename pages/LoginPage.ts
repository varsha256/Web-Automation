import { Page, expect } from '@playwright/test';

export class LoginPage {
  constructor(private page: Page) {}

  async goto() {
    await this.page.goto('/');
  }

  async login(username: string, password: string) {
    await this.page.getByPlaceholder('Username').fill(username);
    await this.page.getByPlaceholder('Password').fill(password);
    await this.page.getByRole('button', { name: 'Login' }).click();
  }

  async verifyLoginSuccess() {
    await expect(this.page.locator('.inventory_list')).toBeVisible();
  }
  
  async verifyErrorMessage(expectedMessage: string) {
  const error = this.page.locator('[data-test="error"]');
  await expect(error).toBeVisible();
  await expect(error).toHaveText(expectedMessage);
}
  async verifyHomePageLoaded() {
    await expect(this.page.locator('.inventory_list')).toBeVisible();
  }
}