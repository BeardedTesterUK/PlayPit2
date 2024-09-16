package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By payItButton = By.id("hometoptasks_item0_tab");
    private final By councilTaxPaymentTab = By.xpath("//span[normalize-space()='Council Tax']");
    private final By glasgowCC = By.linkText("MyGlasgowCC");
    private final By councilTaxLink = By.linkText("Council Tax/Benefits");

    public void selectPaymentButton() {
        waitForElementToBeClickable(payItButton);
        click(payItButton);
    }

    public void selectCouncilTaxPaymentLink(){
        selectLink(councilTaxPaymentTab, "Glasgow City Council - Data Entry");
    }

    public void selectMyGlasgowLink(){
        selectLink(glasgowCC, "MyGlasgowCC - Glasgow City Council");
    }

    //NEW TEST METHODS

    public void selectCouncilTaxBenefitsLink(){
        selectLink(councilTaxLink, "Council Tax/Benefits - Glasgow City Council");
    }
}
