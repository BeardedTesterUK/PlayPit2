package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePage {

    private final By complaintFormLink = By.linkText("Make a comment or compliment");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void selectMakeAComplaintOrCommentLink() {
        selectLink(complaintFormLink,"Comments and Compliments");
    }
}
