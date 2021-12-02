package pages;

import org.openqa.selenium.WebDriver;

public class CouncilTaxPaymentPage extends BasePage {
    public CouncilTaxPaymentPage(WebDriver driver) {
        super(driver);
    }

    public void completePaymentForm() {
        System.out.println("Council Tax Payment Made");
    }
}
