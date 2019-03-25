package system;


import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;


public class Utils {
	public static void logPrint(String strLog) {
		ExtentTest extentTest = TestRule.getExtenteTest();
		try {
			String base64 = efetuarPrintTela() ;
			extentTest.log(Status.INFO, strLog, MediaEntityBuilder
					.createScreenCaptureFromBase64String(base64).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String efetuarPrintTela() {
		String strFile = ((TakesScreenshot) TestRule.getDriver()).getScreenshotAs(OutputType.BASE64);
		return strFile;	
	}
	
	//Wait para aguardar que elemento esteja visivel e clicavel.
	public static WebElement waitElementClicavel(WebElement element) {
		WebDriverWait wait = new WebDriverWait(TestRule.getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;	
	}
	
	public static void logPass(String strMensagem) {
		ExtentTest extentTest = TestRule.getExtenteTest();
		extentTest.log(Status.PASS, strMensagem);
	}
	
	public static void logFail(String strMensagem) {
		ExtentTest extentTest = TestRule.getExtenteTest();
		extentTest.log(Status.FAIL, strMensagem);
	}
}

