package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AlphabetPage extends BasePage {

    private By listOddElement = By.xpath("//div[@id='list']//li[contains(@class,'odd')]");
    private By listEvenElement = By.xpath("//div[@id='list']//li[contains(@class,'even')]");

    public AlphabetPage(WebDriver driver) {
        super(driver);
    }

    public int getListSize() {
        List<WebElement> allEvenLinks = (driver.findElements(listEvenElement));
        List<WebElement> allOddLinks = (driver.findElements(listOddElement));
        return allEvenLinks.size() + allOddLinks.size();
    }
}
