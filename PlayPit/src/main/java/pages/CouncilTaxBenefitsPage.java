package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CouncilTaxBenefitsPage extends BasePage {

    public CouncilTaxBenefitsPage(WebDriver driver) {
        super(driver);
    }

    private final By councilTaxLink = By.linkText("Council Tax");

    public void selectCouncilTaxNew (){
        waitForElementToBeClickable(councilTaxLink);
        click(councilTaxLink);
        waitForPage("Council Tax - Glasgow City Council");
    }
}