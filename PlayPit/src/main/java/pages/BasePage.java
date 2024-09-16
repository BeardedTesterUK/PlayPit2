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

    private final By homeButton = By.id("gccLogoTop");
    private final By accessibilityPageLink = By.linkText("Accessibility");
    private final By aToZPageLink = By.linkText("A to Z");
    private final By contactUsPageLink = By.linkText("Contact Us");
    private final By cookiesPageLink = By.linkText("Cookies");
    private final By privacyPageLink = By.linkText("Privacy");
    private final By vacanciesPageLink = By.linkText("Vacancies");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //BASIC FUNCTIONS

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

    public void selectRadioButtonOption(By radioElement, String option){
        List<WebElement> radioButtons = driver.findElements(radioElement);
        for (WebElement radioButton : radioButtons) {
            if (radioButton.getText().equalsIgnoreCase(option)) {
                radioButton.click();
                break;
            }
        }
    }

    public void selectLink(By locator, String expectedTitle){
        waitForElementToBeClickable(locator);
        click(locator);
        confirmTitle(expectedTitle);
    }

    public void selectFromDropDown(By element, String option) {
        Select dropdown = new Select(driver.findElement(element));
        dropdown.selectByVisibleText(option);
    }

    //WAITS

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

    //GETS

    public int getListSize(By locator){
        List<WebElement> allElementList = findAll(locator);
        return allElementList.size();
    }

    public String getText(By element) {
        return driver.findElement(element).getText();
    }

    //HEADER & FOOTER METHODS

    public void clickReturnHomeButton() {
        waitForElementToBeClickable(homeButton);
        click(homeButton);
        if(driver.getTitle().contains("Page not found"))
            click(By.linkText("Glasgow home"));
        confirmTitle("Glasgow - Glasgow City Council");
        System.out.println("RETURNING HOME");
    }

    public void selectLetterSearch(String letter) {
        waitForElementToBeClickable(By.linkText(letter));
        click(By.linkText(letter));
        confirmTitle(letter + " - Glasgow City Council");
    }

    public void selectAlphaLink(){
        selectLink(aToZPageLink,"A to Z - Glasgow City Council");
    }

    public void selectContactsLink() {
        selectLink(contactUsPageLink,"Contact Us - Glasgow City Council");
    }

    //NAVIGATION

    public void navigateTo(String url, String title) {
        driver.navigate().to(url);
        driver.switchTo().activeElement();
        //waitForElementToBeClickable(cookies);
        //click(cookies);
        confirmTitle(title);
    }

    //ASSERTIONS

    public void confirmTitle(String title) {
        assertTrue(driver.getTitle().contains(title));
    }

}
