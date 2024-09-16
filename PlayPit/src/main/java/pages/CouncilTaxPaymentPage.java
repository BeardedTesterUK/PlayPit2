package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CouncilTaxPaymentPage extends BasePage {

    public CouncilTaxPaymentPage(WebDriver driver) {
        super(driver);
    }

    private final By refNumField = By.id("FT_183");
    private final By nameField = By.id("FT_184");
    private final By addFirstLineField = By.id("FT_185");
    private final By postCodeField = By.id("PCI_33");
    private final By amountPoundsField = By.id("ATI_54");
    private final By amountPenceField = By.id("ATIPence_54");

    public void completePaymentForm() {
        System.out.println("Council Tax Payment Made");
    }

    public void completePaymentFormMandatory() {
        type("A12345", refNumField);
        type("Robert", nameField);
        type("12 Address Street", addFirstLineField);
        type("AB1 2CD", postCodeField);
        type("500", amountPoundsField);
        type("00", amountPenceField);
        System.out.println("Council Tax Payment Made");
    }
}
