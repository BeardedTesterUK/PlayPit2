package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AlphabetPage extends BasePage {

    private By listOddElement = By.xpath("//div[@id='list']//li[contains(@class,'odd')]");
    private By listEvenElement = By.xpath("//div[@id='list']//li[contains(@class,'even')]");
    private By newListElement = By.className("item__sublink--list");
    private By abandonedVehicleLink = By.linkText("Abandoned Vehicle");

    public AlphabetPage(WebDriver driver) {
        super(driver);
    }

    public int getListSize() {
        List<WebElement> allEvenLinks = findAll(listEvenElement);
        List<WebElement> allOddLinks = findAll(listOddElement);
        return allEvenLinks.size() + allOddLinks.size();
    }

    public int getAlphabetList(){
       return getListSize(newListElement);
    }

    public void openAbandonedVehiclePage () {
        click(abandonedVehicleLink);
        confirmTitle("Abandoned Vehicle - Glasgow City Council");
    }
}
