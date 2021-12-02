package tests;

/*Commented out code is to Parameterise using Hard Coded Values
Live Code is to allow CSV file for test Data*/

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.*;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)

public class GlasgowParamTests extends BaseTest {

    ContactPage contact;
    ComplaintPage complaint;


    private String firstName;
    private String surname;

//    public GlasgowParamTests(String firstName, String surname){
//        this.firstName = firstName;
//        this.surname = surname;
//    }

//    @Parameterized.Parameters(name = "This is a form for {0} {1}")
//    public static Collection names() {
//        return Arrays.asList(new Object[][]{
//                { "John", "Smith" },
//                { "Jane", "Doe" },
//                { "Cloud", "Strife"}
//        });
//    }

    @Test
    @FileParameters("src/test/resources/test1.csv")
    public void testChecker(String firstName, String surname) throws InterruptedException {
        homepage.selectContactsLink();
        contact = new ContactPage(driver);
        contact.selectMakeAComplaintOrCommentLink();
        complaint = new ComplaintPage(driver);
        complaint.fillPartForm(firstName, surname);
        Thread.sleep(5000);
        System.out.println(firstName + " " + surname);
    }

//    @Parameterized.Parameters
//    public static Collection<Object[]> versionCombos() {
//        List<Object[]> args = new ArrayList<>();
//        for(int getName=1; getName<=2; getName++)
//
//
//            return args;
//    }
}
