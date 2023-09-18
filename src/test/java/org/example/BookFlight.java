package org.example;

import org.apache.commons.io.FileCleaningTracker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BookFlight {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

//Flights Section
        //choose the country
        driver.findElement(By.id("autosuggest")).sendKeys("eg");
        Thread.sleep(2000);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("Egypt")) {
                option.click();
                break;
            }
        }

        //chose the cities and the data
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@value='GOI']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[@value='AMD'])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[1]/a[1]")).click();
        driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[1]/a[1]")).click();

        // chose currency type
        WebElement staticdrop = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Thread.sleep(1000);
        Select dropD = new Select(staticdrop);
        dropD.selectByIndex(2);
        Thread.sleep(1000);
        dropD.selectByVisibleText("USD");
        Thread.sleep(1000);
        dropD.selectByVisibleText("AED");
        Thread.sleep(1000);
        dropD.selectByVisibleText("USD");
        Thread.sleep(1000);

        //select the passengers' number
        String adult = "hrefIncAdt";
        Thread.sleep(1000);
        String child = "hrefIncChd";
        Thread.sleep(1000);
        String infant = "hrefIncInf";
        Thread.sleep(1000);
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000);
        for (int i = 1; i < 4; i ++) {
            driver.findElement(By.id(adult)).click();
            Thread.sleep(500);
        }
        driver.findElement(By.id(child)).click();
        Thread.sleep(1000);
        driver.findElement(By.id(child)).click();
        Thread.sleep(1000);
        driver.findElement(By.id(infant)).click();

        //print the info
        System.out.println(driver.findElement(By.id(adult)).getText());
        driver.findElement(By.id("btnclosepaxoption")).click(); //click on done
        driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).click(); // click on check box
        driver.findElement(By.xpath("//a[@onclick=\"return ShowModal('SpecialAssistancePopup');\"]")).click(); //click on special assistance
        driver.findElement(By.id("SpecialAssistanceWindow")).click(); //exit

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,+350)", "");
        js.executeScript("window.scrollBy(0,-350)", "");


// Hotels Section
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Hotels']")).click();
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_txtOriginStation1_MST']")).sendKeys("cairo");
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@class='mySpiceTrip']//div[4]//button[1]")).click(); //check-in date
        driver.findElement(By.xpath("//div[@id='ReturnDate_MST']//button[@type='button']")).click(); //check-out date
        Thread.sleep(500);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td[6]/a[1]")).click(); //day

        //Adult drop down
        Thread.sleep(500);
        driver.findElement(By.xpath("//select[@id='ddl_Adult_MST']")).click();
        Thread.sleep(500);
        WebElement AdultDrop = driver.findElement(By.xpath("//select[@id='ddl_Adult_MST']"));
        Select dropAdult = new Select(AdultDrop);
        dropAdult.selectByIndex(3);

        //Child drop down
        Thread.sleep(500);
        driver.findElement(By.xpath("//select[@id='ddl_Child_MST']")).click();
        Thread.sleep(500);
        WebElement ChildDrop = driver.findElement(By.xpath("//select[@id='ddl_Child_MST']"));
        Select dropChild = new Select(ChildDrop);
        dropChild.selectByIndex(2);


        ////Infant drop down
        Thread.sleep(500);
        driver.findElement(By.xpath("//select[@id='ddl_Infant_MST']")).click();
        Thread.sleep(500);
        WebElement InfantDrop = driver.findElement(By.xpath("//select[@id='ddl_Infant_MST']"));
        Thread.sleep(500);
        Select dropInfant = new Select(InfantDrop);
        dropInfant.selectByIndex(2);


        driver.findElement(By.xpath("//span[normalize-space()='Holiday Packages']")).click();
        //chose the cities and the data
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_HolidayPackages_DropDownListPackage_CTXT']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@value='887']")).click(); //first city (DESTINATION)
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_HolidayPackages_DropDownListFrom_CTXT']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[4]/div[2]/div[1]/div[5]/div[2]/div[2]/div[2]/div[8]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/" +
                "table[1]/tbody[1]/tr[2]/td[2]/div[3]/div[1]/div[1]/ul[2]/li[1]/a[1]")).click(); //second city (DEPARTURE)

        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_HolidayPackages_DropDownListTo_CTXT']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[4]/div[2]/div[1]/div[5]/div[2]/div[2]/div[2]/div[8]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/" +
                "td[3]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[3]/div[1]/div[1]/ul[1]/li[1]/a[1]")).click(); //return city

        //date
        driver.findElement(By.xpath("//button[normalize-space()='...']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-hover']")).click();
        driver.quit();

    }

}
