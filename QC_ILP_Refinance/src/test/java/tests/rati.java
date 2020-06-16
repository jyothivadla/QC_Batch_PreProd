package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
public class rati {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String URL = "http://www.google.com";
        WebDriver driver = (WebDriver) new ChromeDriver();
        driver.get(URL);

	}

}
