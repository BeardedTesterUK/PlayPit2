package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage{
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    private By councilTaxPaymentButton = By.xpath("//button[text()='Council Tax']");
    private By housingBenefitsPaymentButton = By.xpath("//button[text()='Housing Benefit Overpayment']");
    private By rentPaymentButton = By.xpath("//button[text()='Homeless Temporary Accommodation']");

    public CouncilTaxPaymentPage selectCouncilTax() throws InterruptedException {
        waitForElementToBeClickable(councilTaxPaymentButton);
        click(councilTaxPaymentButton);
        confirmTitle("Glasgow City Council - Data Entry");
        Thread.sleep(5000);
        return new CouncilTaxPaymentPage(driver);
    }

    public HousingBenefitsPage selectHousingBenefits(){
        waitForElementToBeClickable(housingBenefitsPaymentButton);
        click(housingBenefitsPaymentButton);
        confirmTitle("Glasgow City Council - Account Search");
        return new HousingBenefitsPage(driver);
    }

    public RentPaymentPage selectHomelessRent() {
        waitForElementToBeClickable(rentPaymentButton);
        click(rentPaymentButton);
        confirmTitle("Glasgow City Council - Data Entry");
        return new RentPaymentPage(driver);
    }
}
