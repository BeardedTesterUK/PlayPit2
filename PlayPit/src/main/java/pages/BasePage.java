package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.*;


public class BasePage {

    protected WebDriver driver;

    private By homeButton = By.id("gccLogoTop");
    private By accessibilityPageLink = By.linkText("Accessibility");
    private By aToZPageLink = By.linkText("A to Z");
    private By contactUsPageLink = By.linkText("Contact Us");
    private By cookiesPageLink = By.linkText("Cookies");
    private By privacyPageLink = By.linkText("Privacy");
    private By vacanciesPageLink = By.linkText("Vacancies");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }

    protected void type(String text, By locator) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    public int getListSize(By locator){
        List<WebElement> allElementList = findAll(locator);
        return allElementList.size();
    }

    protected void waitForPage(String title) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains(title));
    }

    protected void waitForElementToBeVisible(By target) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(target));
    }

    protected void waitForElementToBeClickable(By target) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(target));
    }

    public HomePage navigateTo(String url, String title) {
        driver.navigate().to(url);
        driver.switchTo().activeElement();
        //waitForElementToBeClickable(cookies);
        //click(cookies);
        assertTrue(driver.getTitle().contains(title));
        return new HomePage(driver);
    }

    public void confirmTitle(String title) {
        assertTrue(driver.getTitle().contains(title));
    }

    public HomePage clickReturnHomeButton() {
        waitForElementToBeClickable(homeButton);
        click(homeButton);
            if(driver.getTitle().contains("Page not found"))
                click(By.linkText("Glasgow home"));
        confirmTitle("Glasgow - Glasgow City Council");
        System.out.println("RETURNING HOME");
        return new HomePage(driver);
    }


    public String getText(By element) {
        return driver.findElement(element).getText();
    }

    public AlphabetPage selectLetterSearch(String letter) {
        waitForElementToBeClickable(By.linkText(letter));
        click(By.linkText(letter));
        confirmTitle(letter + " - Glasgow City Council");
        return new AlphabetPage(driver);
    }

    public AlphabetPage selectAlphaLink(){
        waitForElementToBeClickable(aToZPageLink);
        click(aToZPageLink);
        confirmTitle("A to Z - Glasgow City Council");
        return new AlphabetPage(driver);
    }

    public ContactPage selectContactsLink() {
        waitForElementToBeClickable(contactUsPageLink);
        click(contactUsPageLink);
        waitForPage("Contact Us - Glasgow City Council");
        return new ContactPage(driver);
    }

    public void selectFromDropDown(By element, String option) {
        Select dropdown = new Select(driver.findElement(element));
        dropdown.selectByVisibleText(option);
    }

    public void selectRadioButtonOption(By radioElement, String option){
        List<WebElement> radioButtons = driver.findElements(radioElement);
        for (WebElement radioButton : radioButtons) {
            if (radioButton.getText().equalsIgnoreCase(option)) {
                radioButton.click();
                break;
            }
        }
    }
}
