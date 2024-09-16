package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CouncilTaxBenefitsPage extends BasePage {

    public CouncilTaxBenefitsPage(WebDriver driver) {
        super(driver);
    }

    private By payIt = By.linkText("Pay It");
    private By councilTaxLink = By.linkText("Council Tax");

    public PaymentPage selectPayIt(){
        waitForElementToBeClickable(payIt);
        click(payIt);
        waitForPage("Pay It - Glasgow City Council");
        return new PaymentPage(driver);
    }

    public CouncilTaxPage selectCouncilTax (){
        waitForElementToBeClickable(councilTaxLink);
        click(councilTaxLink);
        waitForPage("Council Tax - Glasgow City Council");
        return new CouncilTaxPage(driver);
    }
}