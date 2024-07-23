import AllForUser.UserSteps;
import PageObject.MainPage;
import driver.WebDriverCreator;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static driver.Links.BASE_URL;
import static org.junit.Assert.assertTrue;

public class MainPageTest {

        private MainPage mainPage;
    private WebDriver driver;

        @Before
        public void setUp() {
            driver = WebDriverCreator.createWebDriver();
            mainPage = new MainPage(driver);
            driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
        }

        @Test
        @DisplayName("Bun tab should be selected")
        public void bunTabShouldBeSelected() {
            mainPage.open();
            mainPage.clickSauces();
            mainPage.clickBuns();
            assertTrue(mainPage.isBunsSelected());
        }

        @Test
        @DisplayName("Sauce tab should be selected")
        public void sauceTabShouldBeSelected() {
            mainPage.open();
            mainPage.clickFillings();
            mainPage.clickSauces();
            assertTrue(mainPage.isSaucesSelected());
        }

        @Test
        @DisplayName("Filling tab should be selected")
        public void fillingTabShouldBeSelected() {
            mainPage.open();
            mainPage.clickFillings();
            assertTrue(mainPage.isFillingsSelected());
        }
    public void tearDown() {
            driver.quit();
        }

    }

