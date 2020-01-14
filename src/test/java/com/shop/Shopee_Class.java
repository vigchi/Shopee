package com.shop;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class Shopee_Class {

	private static String getData(int rowNo, int cellno) throws Throwable {
		String v = null;
		File loc = new File("C:\\Users\\Vignesh Chinnappa\\eclipse-workspace\\Shopee\\Testdata\\Data.xlsx");
		FileInputStream stream = new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(stream);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(rowNo);
		Cell c = r.getCell(cellno);
		v = c.getStringCellValue();
		return v;
	}

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vignesh Chinnappa\\eclipse-workspace\\konga\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		driver.get("https://shopee.sg/");
		driver.manage().window().maximize();
		options.addArguments("-disable-notifications");
		// closing the popup
		WebElement close = driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div[2]/div"));
		close.click();

		//screenshot
		TakesScreenshot tk = (TakesScreenshot)driver;
		File s = tk.getScreenshotAs(OutputType.FILE);
		File d = new File("D:\\Project\\Img.png");
		FileUtils.copyFile(s, d);

		// Searching iphone 
		WebElement txtBox = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div/div[2]/div/div[1]/div[1]/div/form/input"));
		txtBox.sendKeys(getData(2,0));

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(5000);
		WebElement rclick = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div[1]/div/a/div/div[2]/div[1]/div"));
		Actions acc = new Actions(driver);
		acc.contextClick(rclick).perform();

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		Set<String> all = driver.getWindowHandles();
		List <String> li = new ArrayList();
		li.addAll(all);
		String sa = li.get(1);
		driver.switchTo().window(sa);

		//screenshot
		File s1 = tk.getScreenshotAs(OutputType.FILE);
		File d1 = new File("D:\\Project\\Img1.png");
		FileUtils.copyFile(s1, d1);

		WebElement addCart = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[2]/div[2]/div[3]/div/div[5]/div/div/button[1]"));
		addCart.click();
		Thread.sleep(5000);
		//Email
		WebElement txtemail = driver.findElement(By.xpath("//*[@id=\"modal\"]/aside/div[1]/div/div/div/div[2]/div[1]/div[2]/div/input"));
		txtemail.sendKeys(getData(2,1));

		//Pass
		WebElement txtpass = driver.findElement(By.xpath("//*[@id=\"modal\"]/aside/div[1]/div/div/div/div[2]/div[1]/div[3]/div[1]/input"));
		txtpass.sendKeys(getData(2,2));

		//screenshot
		File s2 = tk.getScreenshotAs(OutputType.FILE);
		File d2 = new File("D:\\Project\\Img2.png");
		FileUtils.copyFile(s2, d2);

		Thread.sleep(3000);
		WebElement addClick = driver.findElement(By.xpath("//*[@id=\"modal\"]/aside/div[1]/div/div/div/div[2]/div[2]/button[2]"));
		addClick.click();

		Thread.sleep(3000);
		WebElement addoption1 = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[2]/div[2]/div[3]/div/div[4]/div/div[2]/div/div[1]/div/button[1]"));
		addoption1.click();

		WebElement addoption2 = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[2]/div[2]/div[3]/div/div[4]/div/div[2]/div/div[2]/div/button[1]"));
		addoption2.click();

		WebElement addCart2 = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[2]/div[2]/div[3]/div/div[5]/div/div/button[1]"));
		addCart2.click();

		//screenshot
		File s3 = tk.getScreenshotAs(OutputType.FILE);
		File d3 = new File("D:\\Project\\Img3.png");
		FileUtils.copyFile(s3, d3);

		Thread.sleep(5000);
		WebElement showCart = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div/div[2]/div/div[2]/div/div/div/div"));
		showCart.click();

		//screenshot
		File s4 = tk.getScreenshotAs(OutputType.FILE);
		File d4 = new File("D:\\Project\\Img4.png");
		FileUtils.copyFile(s4, d4);
	}

}
