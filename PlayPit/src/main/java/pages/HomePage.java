package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By payIt = By.id("hometoptasks_item0_tab");
    private By councilTaxPaymentTab = By.xpath("//span[normalize-space()='Council Tax']");
    private By glasgowCC = By.linkText("MyGlasgowCC");
    private By councilTaxLink = By.linkText("Council Tax/Benefits");

    public void selectPaymentLink() {
        waitForElementToBeClickable(payIt);
        click(payIt);
        //waitForPage("Pay It - Glasgow City Council");
        //return new PaymentPage(driver);
    }

    public CouncilTaxBenefitsPage selectCouncilTaxTab(){
        waitForElementToBeClickable(councilTaxPaymentTab);
        click(councilTaxLink);
        waitForPage("Glasgow City Council - Data Entry");
        return new CouncilTaxBenefitsPage(driver);
    }

    public MyGlasgowPage selectMyGlasgowLink(){
        waitForElementToBeClickable(glasgowCC);
        click(glasgowCC);
        waitForPage("MyGlasgowCC - Glasgow City Council");
        return new MyGlasgowPage(driver);
    }

    public CouncilTaxBenefitsPage selectCouncilTaxLink(){
        waitForElementToBeClickable(councilTaxLink);
        click(councilTaxLink);
        waitForPage("Council Tax/Benefits - Glasgow City Council");
        return new CouncilTaxBenefitsPage(driver);
    }
}
