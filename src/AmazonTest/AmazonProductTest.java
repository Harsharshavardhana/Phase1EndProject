package AmazonTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonProductTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chromedriver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		WebElement searchbut = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		searchbut.sendKeys("samsung mobile");
		WebElement clickbut = driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
		clickbut.click();

		List<WebElement> peoductele = driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-whole']"));
		List<WebElement> symbol = driver.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-symbol']"));
		// String SelectProduct ="Samsung Galaxy A14";
		for (int i = 0; i < peoductele.size(); i++) {
			System.out.println("product name: " + peoductele.get(i).getText() + "  " + "product Price:"
					+ symbol.get(i).getText() + price.get(i).getText());
		}
		TakesScreenshot tsobj = (TakesScreenshot) driver;
		File Fobj = tsobj.getScreenshotAs(OutputType.FILE);
		File scr = new File("img.jpg");
		FileUtils.copyFile(Fobj, scr);

		driver.quit();
	}

}
