package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePage {

    private By complaintFormLink = By.linkText("Make a comment or compliment");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public ComplaintPage selectMakeAComplaintOrCommentLink() {
        waitForElementToBeClickable(complaintFormLink);
        click(complaintFormLink);
        waitForPage("Comments and Compliments");
        return new ComplaintPage(driver);
    }
}
