package pages;

import org.openqa.selenium.WebDriver;

public class HousingBenefitsPage extends BasePage{

    public HousingBenefitsPage(WebDriver driver) {
        super(driver);
    }

    public void completePaymentForm() {
        System.out.println("Housing Payment Made");
    }
}
