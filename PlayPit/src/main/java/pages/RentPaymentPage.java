package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RentPaymentPage extends BasePage {

    private final By referenceNumberField = By.id("FT_136");
    private final By nameField = By.id("FT_137");
    private final By firstAddressLineField = By.id("FT_138");
    private final By postcodeField = By.id("PCI_24");
    private final By amountFiledPounds = By.id("ATI_23");
    private final By amountFieldPence = By.id("ATIPence_23");
    private final By continueButton = By.id("continue");
    private final By referenceNumberError = By.cssSelector("div[class='aip_error_style aip_common_control_style'] label[for='FT_136']");
    private final By nameFieldError = By.id("FT_137_error");
    private final By addressFieldError = By.id("FT_138_error");
    private final By postcodeError = By.id("PCI_24_error");
    private final By amountError =  By.id("ATI_23_error");

    public RentPaymentPage(WebDriver driver) {
        super(driver);
    }

    public void completePaymentForm(String ref, String name, String address, String postcode, String pounds, String pence) {
        waitForElementToBeClickable(referenceNumberField);
        type(ref, referenceNumberField);
        type(name, nameField);
        type(address, firstAddressLineField);
        type(postcode, postcodeField);
        type(pounds, amountFiledPounds);
        type(pence, amountFieldPence);
    }

    public void confirmPayment(){
        System.out.println("CLICK CONTINUE PAYMENT");
    }

    public void confirmErrorMessages(String ref, String name, String address, String postcode, String amount) {
        waitForElementToBeClickable(continueButton);
        click(continueButton);
        assertEquals(" Reference Error Message does not match", ref, getText(referenceNumberError));
        assertTrue(" Name Error Message does not match", getText(nameFieldError).contains(name));
        assertTrue(" Address Error Message does not match", getText(addressFieldError).contains(address));
        assertTrue(" Postcode Error Message does not match", getText(postcodeError).contains(postcode));
        assertTrue(" Amount Error Message does not match", getText(amountError).contains(amount));
    }
}
