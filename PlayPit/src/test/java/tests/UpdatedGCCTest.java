package tests;

import org.junit.Test;
import pages.CouncilTaxBenefitsPage;
import pages.CouncilTaxPage;
import pages.CouncilTaxPaymentPage;
import pages.PayItPage;

public class UpdatedGCCTest extends BaseTest {

    CouncilTaxBenefitsPage council;
    PayItPage payIt;
    CouncilTaxPaymentPage cTax;
    CouncilTaxPage cTPage;

    @Test
    public void councilTaxPaymentNavigation() throws InterruptedException {
        homepage.selectCouncilTaxBenefitsLink();
        council = new CouncilTaxBenefitsPage(driver);
        council.selectCouncilTaxNew();
        cTPage = new CouncilTaxPage(driver);
        cTPage.selectPayCouncilTaxNew();
        payIt = new PayItPage(driver);
        payIt.selectCouncilTax();
        cTax = new CouncilTaxPaymentPage(driver);
        cTax.completePaymentFormMandatory();
    }
}