package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PayItPage extends BasePage{
    public PayItPage(WebDriver driver) {
        super(driver);
    }

    private final By councilTaxPaymentButton = By.xpath("//button[text()='Council Tax']");
    private final By housingBenefitsPaymentButton = By.xpath("//button[text()='Housing Benefit Overpayment']");
    private final By rentPaymentButton = By.xpath("//button[text()='Homeless Temporary Accommodation']");

    public void selectCouncilTax() {
        selectLink(councilTaxPaymentButton, "Glasgow City Council - Data Entry");
    }

    public void selectHousingBenefits(){
       selectLink(housingBenefitsPaymentButton, "Glasgow City Council - Account Search");
    }

    public void selectHomelessRent() {
        selectLink(rentPaymentButton, "Glasgow City Council - Data Entry");
    }
}
