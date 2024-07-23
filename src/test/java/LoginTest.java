import AllForUser.RegUser;
import AllForUser.User;
import AllForUser.UserSteps;
import PageObject.*;
import driver.WebDriverCreator;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


import static org.junit.Assert.assertEquals;

public class LoginTest {
    private WebDriver driver;
    private PersonalAccountPage personalAccountPage;
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private ForgotPasswordPage forgotPasswordPage;
    private static User userLogin;
    private static User userReg;
    private static UserSteps userSteps;
    private RegUser regUser;
    private boolean userCreated;


    @Before
    public void setUp() {
        driver = WebDriverCreator.createWebDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        userCreated = false;
        userLogin = new User("Reg@mail.ru", "Reg1233");
        userReg = new User("Reg@mail.ru", "Reg1233", "Reg");
        UserSteps.createUser(userReg, regUser);

    }

    @Test
    @DisplayName("Login user via loginAccountButton")
    public void loginUserViaLoginAccountButton() {
        mainPage.open();
        mainPage.clickLoginAccountButton();
        loginPage.loginUser(userLogin.getEmail(), userLogin.getPassword());
        loginPage.waitEnterButtonDisplayed();
        loginPage.clickEnterButton();
        mainPage.waitCreateOrderButton();
        String expected = "Оформить заказ";
        String actual = mainPage.getCreateOrderButtonText();
        assertEquals(expected, actual);
        userCreated = true;
    }

    @Test
    @DisplayName("Login user via accountProfileButton")
    public void loginUserViaAccountProfileButton() {
        mainPage.open();
        mainPage.clickAccountProfileButton();
        loginPage.loginUser(userLogin.getEmail(), userLogin.getPassword());
        loginPage.waitEnterButtonDisplayed();
        loginPage.clickEnterButton();
        mainPage.waitCreateOrderButton();
        String expected = "Оформить заказ";
        String actual = mainPage.getCreateOrderButtonText();
        assertEquals(expected, actual);
        userCreated = true;
    }

    @Test
    @DisplayName("Login user via RegistrationPage")
    public void loginUserViaRegistrationPage() {
        mainPage.open();
        mainPage.clickLoginAccountButton();
        loginPage.loginUser(userLogin.getEmail(), userLogin.getPassword());
        loginPage.waitEnterButtonDisplayed();
        loginPage.clickEnterButton();
        mainPage.waitCreateOrderButton();
        String expected = "Оформить заказ";
        String actual = mainPage.getCreateOrderButtonText();

        assertEquals(expected, actual);
        userCreated = true;
    }

    @Test
    @DisplayName("Login user via ForgotPasswordPage")
    public void loginViaForgotPasswordPage() {
        forgotPasswordPage.openForgotPasswordPage();
        forgotPasswordPage.clickLoginButton();
        loginPage.loginUser(userLogin.getEmail(), userLogin.getPassword());
        loginPage.waitEnterButtonDisplayed();
        loginPage.clickEnterButton();
        mainPage.waitCreateOrderButton();
        String expected = "Оформить заказ";
        String actual = mainPage.getCreateOrderButtonText();

        assertEquals(expected, actual);
        userCreated = true;
    }

    @After

    public void tearDown() {
        if (userCreated) {
            String accessToken = UserSteps.getAccessToken(userLogin);
            if (accessToken != null) UserSteps.deleteUser(userLogin, regUser, accessToken);
            driver.quit();
        }
    }
    }
