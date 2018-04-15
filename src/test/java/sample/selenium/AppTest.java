package sample.selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testUpload() {
		System.out.println("Upload");
		uploadFile();
		assertTrue(true);

	}

	public void testDownload() {
		System.out.println("Download");
		downloadFile();
		assertTrue(true);
	}
 
	private void downloadFile() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		String baseUrl = "http://demo.guru99.com/test/yahoo.html";
		WebDriver driver = new ChromeDriver();
		driver.get(baseUrl);
		WebElement downloadButton = driver.findElement(By.id("messenger-download"));
		String sourceLocation = downloadButton.getAttribute("href");
		String wget_command = "cmd /c Wget\\wget.exe -P / --no-check-certificate " + sourceLocation;

		try {
			Process exec = Runtime.getRuntime().exec(wget_command);
			int exitVal = exec.waitFor();
			System.out.println("Exit value: " + exitVal);
		} catch (InterruptedException | IOException ex) {
			System.out.println(ex.toString());
		}
		driver.close();
	}

	private void uploadFile() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		String baseUrl = "http://demo.guru99.com/test/upload/";
		WebDriver driver = new ChromeDriver();
		driver.get(baseUrl);
		WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
		uploadElement.sendKeys("C:\\new.txt");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.name("send")).click();
	}

}