package tests;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.*;

import static org.junit.Assert.assertEquals;
@RunWith(JUnitParamsRunner.class)

public class GlasgowCityCouncilTests extends BaseTest {

    PaymentPage payment;
    CouncilTaxPaymentPage councilTaxPayment;
    HousingBenefitsPage housing;
    RentPaymentPage rent;
    AlphabetPage alphabet;
    ContactPage contact;
    ComplaintPage complaint;
    CouncilTaxPage councilTax;

    @Test
    public void payACouncilTaxBill() {
        homepage.selectPaymentLink();
        payment = new PaymentPage(driver);
        payment.selectCouncilTax();
        councilTaxPayment = new CouncilTaxPaymentPage(driver);
        councilTaxPayment.completePaymentForm();
        councilTaxPayment.clickReturnHomeButton();
    }

    @Test
    public void payCouncilTaxBillFromCouncilTaxPage(){
        homepage.selectCouncilTaxLink();
        councilTax = new CouncilTaxPage(driver);
        councilTax.selectPayIt();
        payment = new PaymentPage(driver);
        payment.selectCouncilTax();
        councilTaxPayment = new CouncilTaxPaymentPage(driver);
        councilTaxPayment.completePaymentForm();
        councilTaxPayment.clickReturnHomeButton();
    }

    @Test
    public void payAHousingBenefitBill() {
        homepage.selectPaymentLink();
        payment = new PaymentPage(driver);
        payment.selectHousingBenefits();
        housing = new HousingBenefitsPage(driver);
        housing.completePaymentForm();
        housing.clickReturnHomeButton();
    }

    @Test
    public void payRentBill() {
        homepage.selectPaymentLink();
        payment = new PaymentPage(driver);
        payment.selectHomelessRent();
        rent = new RentPaymentPage(driver);
        rent.completePaymentForm("12345678",
                "John Smith",
                "1 Address Street",
                "AB1 2CD",
                "10",
                "50");
        rent.confirmPayment();
        rent.clickReturnHomeButton();
    }

    @Test
    public void mandatoryFieldErrorMessage() {
        homepage.selectPaymentLink();
        payment = new PaymentPage(driver);
        payment.selectHomelessRent();
        rent = new RentPaymentPage(driver);
        rent.confirmErrorMessages("Please enter a valid reference number",
                "This must not be left blank",
                "Please enter your house name or number and street name",
                "Please enter a valid postcode",
                "Please enter an amount");
        rent.clickReturnHomeButton();
    }

    @Test
    public void selectFromLetterSearchOptions() {
        homepage.selectLetterSearch("A");
        alphabet = new AlphabetPage(driver);
    }

    @Test
    public void checkContentsOfAlphabetPage() {
        homepage.selectLetterSearch("A");
        alphabet = new AlphabetPage(driver);
        int totalSize = alphabet.getListSize();
        assertEquals("List does not contain all elements", 19, totalSize);
    }

    @Test
    @FileParameters("src/test/resources/glasgowTest.csv")
    public void sendAComplaintForm(String title, String firstName, String surname, String email, String houseNumber, String street,
                                   String city, String postcode, String sex, String age, String choice, String ethnicity,
                                   String subEthnicity, String comment, String response) {
        homepage.selectContactsLink();
        contact = new ContactPage(driver);
        contact.selectMakeAComplaintOrCommentLink();
        complaint = new ComplaintPage(driver);
        complaint.fillForm(title, firstName, surname, email, houseNumber,
                street, city, postcode, sex, age, choice, ethnicity, subEthnicity, comment, response);
    }

    @Test
    @FileParameters("src/test/resources/test1.csv")
    public void testChecker(String firstName, String surname) {
        homepage.selectContactsLink();
        contact = new ContactPage(driver);
        contact.selectMakeAComplaintOrCommentLink();
        complaint = new ComplaintPage(driver);
        complaint.fillPartForm(firstName, surname);
        System.out.println(firstName + " " + surname);
    }
}
