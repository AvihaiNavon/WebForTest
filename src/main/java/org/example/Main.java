package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;
// מבצע פעולות על אתר חלק ראשון
public class Main {
    public static void main(String[] args) {
        //WebGet webGet=new WebGet();
        //WebGet2 webGet2=new WebGet2();
        CurrencyConverterApp currencyConverterApp=new CurrencyConverterApp();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter text to search in one web :");
        String text=scanner.nextLine();

        //נדרש להוריד גרייבר כרום מתאים
        //https://chromedriver.storage.googleapis.com/index.html?path=114.0.5735.90/
        // להוסיף חבילה רלוונטית
//        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
//<dependency>
//    <groupId>org.seleniumhq.selenium</groupId>
//    <artifactId>selenium-java</artifactId>
//    <version>4.10.0</version>
//</dependency>
      //  System.setProperties("webdriver.openqa.driver","C:\Users\אביחי\Downloads\chromedriver_win32\chromedriver.exe");
        ChromeDriver driver= new ChromeDriver();// יצירת משתנה כרום
        driver.get("https://www.one.co.il/");// פתיחת קישור אתר
        driver.manage().window().maximize();//מגדיל חלון מסך
        WebElement webElement=driver.findElement(By.id("one-search"));//שומר את האלמנט של החיפוש ע"פ כתובת id
        if(webElement!=null){ //בודק אם הטקסט חיפוש ריק
            webElement.sendKeys(text);// הכנסת טקסט לחיפוש
           WebElement searchButton=driver.findElement(By.xpath("/html/body/form/div[2]/div[2]/div[2]/div[2]/div/input[1]"));//הכנסת אלמנט לפי ערך xpath
           if(searchButton!=null){
               searchButton.click();// לבצע לחיצה על האלמנט של החיפוש
               try {
                   Thread.sleep(5000); // כדאי לשים סליפ כדי למנוע כפל על אלמנטים
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }

               WebElement firstArticle=driver.findElement(By.id("_ctl0_ContentHolder_Body_rpResults__ctl0_ucPlainArticle_oneArticleTitle"));
               firstArticle.click(); // לוחץ על האלמנט הבא שהגדרנו לאחר החיפוש
           }

        }


    }
    private static void waitUntilElementAppears(ChromeDriver driver,String id){ // לחכות עד שהערך יוזן
        while (true){
            try {
            WebElement webElement=driver.findElement(By.id(id));
            if(webElement!=null){
                break;
            }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}