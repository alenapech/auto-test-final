package org.alenapech;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.alenapech.pom.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractUITest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected WebDriverWait wait;

    //the steps which should be followed for any case(est class)
    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://gb.ru/login");
        loginPage = new LoginPage(driver, wait);
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
