package akashdhembare2000;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo {

    ExtentReports extentReport;

    @BeforeTest
    public void config(){
       // ExtentReports
       // ExtentSparkReporter
        String path=System.getProperty("user.dir")+"//reports/index.html";
        ExtentSparkReporter reporter= new ExtentSparkReporter(path);

        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extentReport= new ExtentReports();
        extentReport.attachReporter(reporter);
        extentReport.setSystemInfo("Tester", "Akash Dhembare");
    }

    @Test
    public void initialDemo(){
        ExtentTest test = extentReport.createTest("Initial Demo");
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
      //  test.fail("Result do not match");
        extentReport.flush();
    }
}
