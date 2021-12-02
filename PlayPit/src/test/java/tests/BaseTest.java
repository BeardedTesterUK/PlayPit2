package tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import static utils.DriverFactory.getChromeDriver;

public class BaseTest {

    public static  HomePage homepage;
    public static  WebDriver driver;

    @Before
    public void setUp(){
        driver = getChromeDriver();
        homepage = new HomePage(driver);
        homepage.navigateTo("https://www.glasgow.gov.uk/home", "Homepage of Glasgow City Council - Glasgow City Council");
    }

//    ONLY WORKS FOR TESTNG
//    @After
//   public void recordFailure(ITestResult result){
//        if(TestResult.FAILURE == result.getStatus())
//        {
//            var camera = (TakesScreenshot)driver;
//            File screenshot = camera.getScreenshotAs(OutputType.FILE);
//            try{
//                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
//            }catch(IOException e){
//                e.printStackTrace();
//            }
//        }
//    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
