package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CouncilTaxPage extends BasePage {

    public CouncilTaxPage(WebDriver driver) {
        super(driver);
    }

    private By payIt = By.linkText("Pay It");

    public PaymentPage selectPayIt(){
        waitForElementToBeClickable(payIt);
        click(payIt);
        waitForPage("Pay It - Glasgow City Council");
        return new PaymentPage(driver);
    }

}
