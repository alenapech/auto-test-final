package org.alenapech;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UITest extends AbstractUITest {

    @Test
    void testGBNotEmailLogin() {
        loginPage.login("login", "password");
        assertEquals("Введите адрес электронной почты.", loginPage.getEmailTypeValidationMessage());
    }

    @Test
    void testGBWithoutPassword() {
        loginPage.typeEmailInField("login@login.ru");
        loginPage.clickLoginButton();
        assertEquals("Обязательное поле.", loginPage.getPasswordMandatoryValidationMessage());
    }

}
