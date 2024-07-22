package MainPaige;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final WebDriver driver;
    private static final String URL = "https://stellarburgers.nomoreparties.site/";
    private final By stellarBurgers = By.xpath(".//div[@class ='AppHeader_header__logo__2D0X2'])");
    private final By OrdersLent = By.xpath(".//a[@class ='AppHeader_header__link__3D_hX AppHeader_header__link_active__1IkJo']"); /*Лента заказов*/
    private final By personalAccount = By.xpath(".//p[text()='Личный Кабинет']"); /*Личный кабинет*/
    private final By constructor = By.xpath(".//p[text()='Конструктор']"); /*Конструктор*/
    private final By LogInMain = By.xpath(".//Button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']"); /*Кнопка войти в аккаунт на главной*/
    private final By Buns = By.xpath(".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']"); /*Булки*/
    private final By Sauces = By.xpath(".//div[@class = 'tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']"); /*Соусы*/
    private final By Fillings = By.xpath(".//div[@class = 'tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']"); /*Начинки*/
    private final By LogInPersonalAccount = By.xpath(".//Button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']"); /*Кнопка войти в аккаунт в личном кабинете*/
    private final By LogInRegistration = By.xpath(".//a[@class = 'Auth_link__1fOlj']"); /*Кнопка войти на странице регистрации*/
    private final By Registration = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']"); /*Кнопка зарегестрироваться*/


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(URL);
    }

    public void clickStellarBurgers(){
        driver.findElement(stellarBurgers).click();
    }
    public void clickOrdersLent(){
        driver.findElement(OrdersLent).click();
    }

    public void personalAccount(){
        driver.findElement(personalAccount).click();
    }

    public void constructor(){
        driver.findElement(constructor).click();
    }
    public void Buns(){
        driver.findElement(Buns).click();
    }
    public void Sauces(){
        driver.findElement(Sauces).click();
    }
    public void Fillings(){
        driver.findElement(Fillings).click();
    }
    public void LogInPersonalAccount(){
        driver.findElement(LogInPersonalAccount).click();
    }
    public void LogInRegistration(){
        driver.findElement(LogInRegistration).click();
    }
    public void Registration(){
        driver.findElement(Registration).click();
    }



    public void SkrollToAboutImportantThings(){
        WebElement QuestionsAboutImportantThings = driver.findElement(By.xpath(".//div[text()='Вопросы о важном']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",QuestionsAboutImportantThings);
    }


    public void clickMkad(){
        driver.findElement(MKAD).click();
        String text = driver.findElement(By.id("accordion__panel-7")).getText();
    }
}
