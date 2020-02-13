package tomerAutomation;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;
public class SeleniumInterview {
	private static WebDriver driver;
	
	@BeforeClass
	public static void startSession() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SQtest\\Downloads\\tomer\\chromedriver_win32\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@AfterClass
	public static void endSession() {
		if(driver!=null) {
			driver.quit();
		}
	}
	@Before
	public void beforeMethod() {
		driver.get("https://www.google.co.il/?hl=iw");
		
	}
	   @Test
	   public void q1() {
		     
	    try {
	    	driver.findElement(By.name("q")).sendKeys("selenium");
	    	
	  	   WebDriverWait wait=new WebDriverWait(driver,15);
	  	   By by=By.cssSelector("#tsf > div:nth-child(2) > div.A8SBwf.emcav > div.UUbT9 > div.aajZCb > div.tfB0Bf > center > input.gNO89b");
	  	   wait.until(ExpectedConditions.elementToBeClickable(by)).click();
			for(WebElement link : driver.findElements(By.tagName("a"))) {
				System.out.println(link.getText());
			}	
	    }
	    catch (Exception e) {
	    	System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	    
	   }
	   @Test
	   public void q2() {
		     
	    try {
	    
		    driver.findElement(By.name("q")).sendKeys("selenium g");
			for(WebElement option : driver.findElements(By.cssSelector("#tsf > div:nth-child(2) > div.A8SBwf.emcav > div.UUbT9 > div.aajZCb > ul > li"))) {
				System.out.println(option.getText());
				if(option.getText().toLowerCase().equals("selenium github")) {
					option.click();
					break;
				}
			}	
			//
			String locator="#rso > div:nth-child(1) > div > div > div > div > div.r > a";
			assertEquals("It's not git hub","https://github.com/SeleniumHQ/selenium", driver.findElement(By.cssSelector(locator)).getAttribute("href"));
			driver.findElement(By.cssSelector(locator)).click();
			locator="#js-repo-pjax-container > div.pagehead.repohead.readability-menu.bg-gray-light.pb-0.pt-3.pb-0 > div > div > h1";
			assertEquals("Repository is not seleniumHQ","SeleniumHQ\r\n" + 
					"/\r\n" + 
					"selenium", driver.findElement(By.cssSelector(locator)).getText());
			WebDriverWait wait=new WebDriverWait(driver,15);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#js-repo-pjax-container > div.container-lg.clearfix.new-discussion-timeline.px-3 > div > div.file-navigation.in-mid-page.d-flex.flex-items-start > details.get-repo-select-menu.js-get-repo-select-menu.position-relative.details-overlay.details-reset > summary"))).click();
			System.out.println(driver.findElement(By.cssSelector("#js-repo-pjax-container > div.container-lg.clearfix.new-discussion-timeline.px-3 > div > div.file-navigation.in-mid-page.d-flex.flex-items-start > details.get-repo-select-menu.js-get-repo-select-menu.position-relative.details-overlay.details-reset > div > div > div.get-repo-modal-options > div.clone-options.https-clone-options > div > input")).getAttribute("value"));
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#js-repo-pjax-container > div.pagehead.repohead.readability-menu.bg-gray-light.pb-0.pt-3.pb-0 > nav > span:nth-child(2) > a"))).click();
			driver.findElement(By.id("js-issues-search")).sendKeys("Zooming browsers using short cut keys such as \"CMD+\" does not work");
			driver.findElement(By.id("js-issues-search")).sendKeys(Keys.ENTER);
			System.out.println(driver.findElement(By.cssSelector("#issue_7793 > div > div.flex-auto.min-width-0.lh-condensed.p-2.pr-3.pr-md-2 > div > span.opened-by > relative-time")).getText());
	    }
	    catch (Exception e) {
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	    catch (AssertionError ex) {
	    	System.out.println(ex.getMessage());
	    	fail(ex.getMessage());
		}


	   }
}
