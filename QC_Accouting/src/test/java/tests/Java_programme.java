package tests;
import org.testng.annotations.Test;

import com.mongodb.MapReduceCommand.OutputType;
import com.mongodb.connection.Connection;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Java_programme {
	
	public static ExtentReports reports;
	public static ExtentTest test;
   // test case CharAt()
	//@Test(priority = 1, groups = { "Jyothi7" })
 
   public void testCase1() {
	   String str="Selenium";
	   char char1=str.charAt(3);
      System.out.println(char1);
      
      
   }

   // test case SubString
 //@Test(priority = 2, groups = { "Jyothi7" })
 
   public void testCase2() {
	   String sub="Selenium is based on java";
	   int beginindex = 0;
	   int endindex;
	   
	   String substr= sub.substring(beginindex);
	   
      System.out.println(substr);
   }
 //@Test(priority = 3, groups = { "Jyothi7" })
 // @Test Replace
  public void testCase3() {
	   String str="India is a world's one of the largest country and population is very high high high";
	   String Rep= str.replaceFirst("high", "Small");
	   
     System.out.println(Rep);
  }
 //@Test(priority = 4, groups = { "Jyothi7" })
 // @Test ReplaceAll
  public void testCase4() {
	   String str="India is a world's one high of the largest country and population is very high";
	   String Rep= str.replaceAll("h","l");
	   
     System.out.println(Rep);
     
  }

//@Test(priority = 5, groups = { "Jyothi7" })
// @Test Replace
 public void testCase5() {
	   String str="India is a world's one of the largest country and population is very high largest largest";
	   String Rep= str.replace("largest","smallest");
	   
    System.out.println(Rep);
 }
 
 //@Test(priority = 6, groups = { "Jyothi7" })
//@Test 
public void testCase6() {
	   String str="India is a world's one of the largest country and population is very high";
	   String Rep= str.replace("o","e");
	   
  System.out.println(Rep);
}
//Selenium Programs

//@Test(priority = 7, groups = { "Jyothi7" })
//@Test 
public void testCase7() throws InterruptedException {
	   String url="https://www.google.com";
	   
	   ChromeDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, 40000);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   Thread.sleep(3000);
		driver.get(url);
	

		System.out.println(url);
}

  //Locators: By ID
//@Test(priority = 8, groups = { "Jyothi7" })
//@Test 
public void testCase8() throws InterruptedException {
	   String url="https://www.google.com";
	   
	   ChromeDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, 40000);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   Thread.sleep(3000);
		driver.get(url);
		driver.findElement(By.id("gb_70")).click();
		System.out.println("click on signin");
		
	

		//System.out.println(url);
}


//Locators: By Name
//@Test(priority = 9, groups = { "Jyothi7" })
//@Test 
public void testCase9() throws InterruptedException {
	   String url="https://www.google.com";
	   
	   ChromeDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, 40000);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   Thread.sleep(3000);
		driver.get(url);
		driver.findElement(By.id("gb_70")).click();
		System.out.println("click on signin");
		driver.findElement(By.name("identifier")).sendKeys("jyothivadla73@gmail.com");

		 System.out.println("entered the email");
		 
}


//@Test(priority = 10, groups = { "Jyothi7" })
//Locators: By Xpath
public void testCase10() throws InterruptedException {
	   String url="https://www.google.com";
	   
	   ChromeDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, 40000);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   Thread.sleep(3000);
		driver.get(url);
		driver.findElement(By.id("gb_70")).click();
		System.out.println("click on signin");
		driver.findElement(By.name("identifier")).sendKeys("jyothivadla73@gmail.com");
        System.out.println("entered the email");
        Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='identifierNext']/span/span")).click();	
		System.out.println("Click on the next button");
        driver.findElement(By.name("password")).sendKeys("Muraripa@3");
        System.out.println("entered the Password");
        Thread.sleep(300);
		driver.findElement(By.xpath("//*[@id='passwordNext']/span/span")).click();
		System.out.println("Click on the next button");
		Thread.sleep(300);
		driver.findElement(By.partialLinkText("Done")).click();
		System.out.println("Click on the button Done");
		 
		
}

//@Test(priority = 11, groups = { "Jyothi7" })
//Locators: ByPartialLinkText
public void testCase11() throws InterruptedException {
	   String url="https://www.google.com";
	   
	   ChromeDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, 40000);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   Thread.sleep(3000);
		driver.get(url);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div/div[1]/div/div[1]/input")).sendKeys("Selenium topics");
        System.out.println("entered the text");
        Thread.sleep(300);
        
        driver.findElement(By.name("btnK")).click();
        System.out.println("entered the required search");
        
        driver.findElementByPartialLinkText("Selenium Tutorial for Beginners: Learn WebDriver in 7 Days - Guru99").click();
        System.out.println("entered on the Guru99");
	
}
//@Test(priority = 12, groups = { "Jyothi7" })
//Locators: Clear
public void testCase12() throws InterruptedException {
	   String url="https://www.google.com";
	   
	   ChromeDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, 40000);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    Thread.sleep(3000);
		driver.get(url);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div/div[1]/div/div[1]/input")).sendKeys("Selenium topics");
        System.out.println("entered the text");
        Thread.sleep(300);
      
      driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div/div[1]/div/div[1]/input")).clear();
      System.out.println("Clear the text");
      
      
      driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div/div[1]/div/div[1]/input")).sendKeys("webdriver methods");
      System.out.println("entered the text");
      
      driver.findElement(By.name("btnK")).click();
      System.out.println("entered the required search");
      
      driver.findElementByPartialLinkText("Selenium Tutorial for Beginners: Learn WebDriver in 7 Days - Guru99").click();
      System.out.println("entered on the Guru99");
	  
     //Reporter.log("clicked on the Guru99");
     driver.quit();

}

//@Test(priority = 13, groups = { "Jyothi7" })
//Locators: getText()
public void testCase13() throws InterruptedException {
	   String url="https://www.google.com";
	   
	   ChromeDriver driver = new ChromeDriver();
	   WebDriverWait wait = new WebDriverWait(driver, 40000);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    Thread.sleep(3000);
		driver.get(url);
		Thread.sleep(3000);
		String Text= driver.findElement(By.xpath("//*[@id='gbw']/div/div/div[1]/div[1]/a")).getText();
		//System.out.println(Text);
	
		Reporter.log(Text);
		driver.quit();
		 
}

//@Test(priority = 14, groups = { "Jyothi7" })
//Locators: ()
public void testCase14() throws InterruptedException {
	   String url="https://www.google.com";
	   
	   ChromeDriver driver = new ChromeDriver();
	   WebDriverWait wait = new WebDriverWait(driver, 40000);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    Thread.sleep(3000);
	    driver.get(url);
	    driver.findElementByXPath("//*[@id='gb']/div[2]/div[3]/div[1]/div/div[1]/a").getAttribute("Gmail");
	    System.out.println("captured the attribute");
}

//@Test(priority = 15, groups = { "Jyothi7" })
//Locators: ()
public void testCase15() throws InterruptedException {
	    String url="https://www.google.com";
	   
	    ChromeDriver driver = new ChromeDriver();
	    WebDriverWait wait = new WebDriverWait(driver, 40000);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    Thread.sleep(3000);
		driver.get(url);
		Thread.sleep(3000);
		
  /*      
        for(i=1; i<=5; i++)
        { 	
        List= driver.findElements(By.)
        		System.out.println(List);
        }*/
}

//@Test(priority = 16, groups = { "Jyothi7" })
//DateFormat()
public static void main(String[] args) {

	//Create object of SimpleDateFormat class and decide the format
	DateFormat dateFormat= new SimpleDateFormat("MM/dd/yyyy");

	//get current date time with Date()
	Date date= new Date();

	//Now format the date
	String date1=dateFormat.format(date);

	//Print the Date
	System.out.println(date1);
	
	
	}
	
//@Test(priority = 17, groups = { "Jyothi7" })
//code for data connection
  public void Connection() throws InterruptedException, ClassNotFoundException {
	java.sql.Connection conn= null;
	Statement stmt= null;
	Result resultset=null;
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	System.out.println("before conn");
	// Open a connection
	try {

		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QCHPROD_QTP_03122019",
				"QCHPROD_QTP_03122019");

	} catch (SQLException e1) {

		System.out.println("Connection Failed! Check output console" + e1);
		
		e1.printStackTrace();
	}
		
}
  
  
//@Test(priority = 18, groups = { "Jyothi7" })
//String Concat("to combine the two words")
  public void testCase18() throws InterruptedException {
	  String firstword="javaprogramme";
	  String secondword="Selenium";
	  
	  String total= firstword.concat(secondword);
	  //System.out.println(total);
	  Reporter.log(total);
  }
  
 // @Test(priority = 19, groups = { "Jyothi7" })
 //String Compare
 public void testCase19() throws InterruptedException {
 String first="addition";
 String second="substraction";
 
//System.out.println(first.compareTo(second));

Reporter.log(second, first.compareTo(second));

  }
  
 @Test(priority = 20, groups = { "Jyothi7" })
 //String Compare
 public void testCase20() throws InterruptedException {
 String first="addition";
 String second="substraction";
 
//System.out.println(first.compareTo(second));

Reporter.log(second, first.compareTo(second));

  }
   
  


  
  
  
  
  
  
  
  
  
  
  
    @BeforeMethod
    public void beforeMethod() {
       System.out.println("in beforeMethod");
    }

   @AfterMethod
   public void afterMethod() {
      System.out.println("in afterMethod");
   }

   @BeforeClass
   public void beforeClass() {
      System.out.println("in beforeClass");
   }

   @AfterClass
   public void afterClass() {
      System.out.println("in afterClass");
   }

   @BeforeTest
   public void beforeTest() {
      System.out.println("in beforeTest");
   }

   @AfterTest
   public void afterTest() {
      System.out.println("in afterTest");
   }

   @BeforeSuite
   public void beforeSuite() {
      System.out.println("in beforeSuite");
   }

   @AfterSuite
   public void afterSuite() {
      System.out.println("in afterSuite");
   }

}