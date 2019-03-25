package system;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestRule {
	  private static WebDriver driver;
	  private static ExtentHtmlReporter htmlReporter;
	  private static ExtentReports extentReport;
	  private static ExtentTest extentTest;
	
      @Before
      public void beforeCenario(Scenario cenario) {
    	  if(extentReport == null) {
    		  extentReport = new ExtentReports();
    		  htmlReporter = new ExtentHtmlReporter("src//test//resources//htmlReporter.html");
    		  extentReport.attachReporter(htmlReporter);
    	  }
    	  extentTest = extentReport.createTest(cenario.getId());
    	  
    	  System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
    	  driver = new ChromeDriver();
    	  driver.manage().window().maximize();
    	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	  driver.get("http://automationpractice.com/index.php");
      }
      
      @After
      public void afterCenario(Scenario cenario) {
    	  if(cenario.isFailed()) {
    	  extentTest.log(Status.FAIL, "Cenario "+cenario.getName()+ " executado com falhas!");
    	  extentReport.flush(); 
    	  }else {
    		  extentTest.log(Status.PASS, "Cenario "+cenario.getName()+ " executado com sucesso!");
        	  extentReport.flush(); 
    	  }
    	  driver.close(); 
      }
      
      public static WebDriver getDriver() {
    	  return driver;  	  
      }
      public static ExtentTest getExtenteTest() {
    	  return extentTest;
      }
}

