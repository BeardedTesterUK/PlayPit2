package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CouncilTaxPage extends BasePage {

    public CouncilTaxPage(WebDriver driver) {
        super(driver);
    }

    private By payCouncilTaxLink = By.linkText("Pay Council Tax");

    public PaymentPage selectPayCouncilTax () {
        waitForElementToBeClickable(payCouncilTaxLink);
        click(payCouncilTaxLink);
        waitForPage("Pay It - Glasgow City Council");
        return new PaymentPage(driver);
    }
}
