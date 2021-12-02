package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By payIt = By.linkText("Pay It");
    private By glasgowCC = By.linkText("MyGlasgowCC");
    private By councilTaxLink = By.linkText("Council Tax");

    public PaymentPage selectPaymentLink() {
        waitForElementToBeClickable(payIt);
        click(payIt);
        waitForPage("Pay It - Glasgow City Council");
        return new PaymentPage(driver);
    }

    public MyGlasgowPage selectMyGlasgowLink(){
        waitForElementToBeClickable(glasgowCC);
        click(glasgowCC);
        waitForPage("MyGlasgowCC - Glasgow City Council");
        return new MyGlasgowPage(driver);
    }

    public CouncilTaxPage selectCouncilTaxLink(){
        waitForElementToBeClickable(councilTaxLink);
        click(councilTaxLink);
        waitForPage("Council Tax - Glasgow City Council");
        return new CouncilTaxPage(driver);
    }
}
