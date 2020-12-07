package Bai_1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Component {
	// khai báo biến driver

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		// Khởi tạo
		driver = new FirefoxDriver();
		// Phóng to browser lên
		driver.manage().window().maximize();
		// Chờ cho element được stable trước khi thao tác trong vòng 30ms
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://live.demoguru99.com/index.php/customer/account/login/");

	}

	@Test // testcase
	public void TC_01_ID() throws InterruptedException {
		// tương tác với element
		driver.findElement(By.id("email")).sendKeys("tranminhtruc@gmail.com");
		// 1ms=1000s
		Thread.sleep(2000);
		// xóa dữ liệu trong các element có thể nhập được: Textbox/textare/dropdown/...
		driver.findElement(By.id("email")).clear();
	}

	@Test
	public void TC_02_Class() throws InterruptedException {
		driver.findElement(By.className("input-text required-entry validate-password")).sendKeys("Bin@2020");
		Thread.sleep(2000);
		driver.findElement(By.className("input-text required-entry validate-password")).clear();
	}

	@Test
	public void TC_03_Name() throws InterruptedException {
		driver.findElement(By.name("login[username]")).sendKeys("id@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.name("login[username]")).clear();
	}

	@Test
	public void TC_04_Tagname() throws InterruptedException {
		int linknumber = driver.findElements(By.tagName("a")).size();
		System.out.println("Sum link= " + linknumber);
		Thread.sleep(2000);
	}

	@Test //Nó chỉ work với đường link với text cố định (tuyệt đối) XPATH
	public void TC_05_ID() throws InterruptedException {
		//Click vào SITE MAP link
				driver.findElement(By.linkText("SITE MAP")).click();
		Thread.sleep(2000);
	}
	@Test //Nó chỉ work với đường link với text cố định (tương đối) XPATH
	public void TC_06_ID() throws InterruptedException {
		driver.findElement(By.partialLinkText("ADVANDED")).click();
		Thread.sleep(2000);
	}
	@Test //Nó chỉ work với đường link với text cố định (tương đối) XPATH
	public void TC_07_Css() throws InterruptedException {
		//ID
		driver.findElement(By.cssSelector("#name")).sendKeys("LCD");
		//Class
		driver.findElement(By.cssSelector(".advanced-search")).isDisplayed();
		//Name
		driver.findElement(By.cssSelector("input[name='short_description']")).sendKeys("Samsung LCD");
		//Link text
		driver.findElement(By.cssSelector("a[href='http://live.demoguru99.com/index.php/catalog/seo_sitemap/category/']")).click();
		//partial link
		driver.findElement(By.cssSelector("a[href*='http://live.demoguru99.com/index.php/tv.html']")).click();
		//Tag name
		int linkSize= driver.findElements(By.cssSelector("a")).size();
		System.out.println("Css tagname= "+ linkSize);
		Thread.sleep(2000);
	}
	//@test
	//public void TC_8_Xpath() throws InterruptedException {
	//	driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
	//	Thread.sleep(2000);
	//	//id
	//	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("xpath");
	//	driver.findElement(By.xpath("//input[@id='email']")).clear();
	//	Thread.sleep(2000);
		//class
	//	driver.findElement(By.xpath("//input[@class='input-text required-entry validate-password']")).sendKeys("xpath_class@gmail.com");
		//name
	//	driver.findElement(By.xpath("//input[@name='email']")).sendKeys("xpath_name@gmail,com");
	//	//link test
	//	driver.findElement(By.xpath("//a[text()='About Us']")).click();
	//	//partail link
	
		//tagname
		//css
	//}
	@AfterClass // post-condition
	public void afterClass() {
		driver.quit();
	}

}
