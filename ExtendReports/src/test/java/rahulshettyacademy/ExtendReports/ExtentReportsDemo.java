package rahulshettyacademy.ExtendReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {

	ExtentReports extent;
	
	@BeforeTest
	public void config() {
		
		//ExtendReports , ExtentSparkReporter
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		//line 16 will create html file and do some configuration
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");//this will show "Web Automation Results" this name on website(button)
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rishabh Khade");
		
	}
	
	@Test
	public void initialDemo() {

		ExtentTest test = extent.createTest("Initial Demo");//this is test name
		System.setProperty("webDriver.chrome.driver", "C:\\Users\\HP\\Desktop\\chromedriver_win32.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com");
		
		System.out.println(driver.getTitle());
		driver.close();
//		test.fail("Result do not match");
		
		extent.flush();
		//test case written flush() method is mandatory.After this only reports will generated.
	}
}
