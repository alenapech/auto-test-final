package org.alenapech.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriverWait wait;

    @FindBy(xpath="//form[@id='new_user']//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath="//form[@id='new_user']//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath="//form[@id='new_user']//input[@class='btn btn-block btn-success']")
    private WebElement loginButton;

    @FindBy(xpath = "//form[@id='new_user']//input[@type='email']/..//li[@class='parsley-type']")
    private WebElement emailTypeValidationMessage;

    @FindBy(xpath = "//form[@id='new_user']//input[@type='password']/..//li[@class='parsley-required']")
    private WebElement passwordMandatoryValidationMessage;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    public void login(String email, String password) {
        typeEmailInField(email);
        typePasswordInField(password);
        clickLoginButton();
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
    }

    public void typePasswordInField(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
    }

    public void typeEmailInField(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
    }

    public String getEmailTypeValidationMessage() {
        return wait.until(ExpectedConditions.visibilityOf(emailTypeValidationMessage)).getText();
    }

    public String getPasswordMandatoryValidationMessage() {
        return wait.until(ExpectedConditions.visibilityOf(passwordMandatoryValidationMessage)).getText();
    }
}
