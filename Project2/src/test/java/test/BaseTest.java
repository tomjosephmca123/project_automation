package test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ElementUtil;

public class BaseTest {
	WebDriver driver;
	@Parameters({"browsername"})
	  @BeforeMethod(alwaysRun = true)
	  public void beforeMethod(@Optional ("chrome") String browsername) {
		  System.setProperty("webdriver.http.factory", "jdk-http-client");
			
			if(browsername.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			else if(browsername.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			driver.navigate().to(ElementUtil.getPropertyValue("baseUrl"));
	  }

	  @AfterMethod
	  
		  public void takeScreenShotOnFailure(ITestResult iTestResult) throws IOException {
				if (iTestResult.getStatus() == iTestResult.FAILURE) {
					takeScreenShotOnFailure(iTestResult.getName());

				}
				driver.quit();
			}

			public String takeScreenShotOnFailure(String name) throws IOException {
				String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm").format(new Date());


				File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				String destination =Constants.screenShot_path + name + dateName + ".png";

				File finalDestination = new File(destination);

				FileUtils.copyFile(source, finalDestination);
				return destination;
			}
	  


}
