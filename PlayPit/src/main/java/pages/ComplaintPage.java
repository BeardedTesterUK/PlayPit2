package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComplaintPage extends BasePage {

    private final By titleBox = By.id("Application_Honorific");
    private final By firstNameField = By.id("Application_FirstName");
    private final By surnameField = By.id("Application_Surname");
    private final By emailField = By.id("Application_Email");
    private final By confirmEmailField = By.id("Application_ConfirmEmail");
    private final By houseNumberField = By.id("Application_Gazetteer_HouseNumber");
    private final By streetField = By.id("Application_Gazetteer_Street");
    private final By cityField = By.id("Application_Gazetteer_CityOrTown");
    private final By postcodeField = By.id("Application_Gazetteer_Postcode");
    private final By sexRadioButton = By.xpath("//label[contains(@for,'Application_Sex')]");
    private final By ageBox = By.id("Application_Age");
    private final By disabilityRadioButton = By.xpath("//label[contains(@for,'Application_rblDisabled')]");
    private final By ethnicOriginBox = By.id("Application_EthnicOrigin");
    private final By commentField = By.id("Application_Comments");
    private final By responseRadioButton = By.xpath("//label[contains(@for,'Application_Reply')]");
    private final By subEthnicOriginBox = By.id("Application_SubEthnicOrigin");


    public ComplaintPage(WebDriver driver) {
        super(driver);
    }

    public void fillPartForm(String firstName, String Surname){
        type(firstName, firstNameField);
        type(Surname, surnameField);
    }

    public void fillForm(String title, String firstName, String Surname, String email, String houseNumber,
                         String street, String city, String postcode, String sex, String age, String choice, String ethnicity,
                         String subEthnicity, String comment, String response){
        selectFromDropDown(titleBox, title);
        type(firstName, firstNameField);
        type(Surname, surnameField);
        type(email, emailField);
        type(email, confirmEmailField);
        type(houseNumber, houseNumberField);
        type(street, streetField);
        type(city, cityField);
        type(postcode, postcodeField);
        selectRadioButtonOption(sexRadioButton, sex);
        selectFromDropDown(ageBox, age);
        selectRadioButtonOption(disabilityRadioButton, choice);
        selectFromDropDown(ethnicOriginBox, ethnicity);
        waitForElementToBeClickable(subEthnicOriginBox);
        selectFromDropDown(subEthnicOriginBox, subEthnicity);
        type(comment, commentField);
        selectRadioButtonOption(responseRadioButton, response);
    }
}
