import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class mailru_page  {


    public mailru_page logging_in ( String user, String password, String searching_name) throws InterruptedException, MalformedURLException {
        
        //java -jar selenium-server-standalone-3.14.0.jar -role hub
        //java -jar selenium-server-standalone-3.14.0.jar -role node  -hub http://localhost:4444/grid/register
        //java -jar selenium-server-standalone-3.14.0.jar -role node  -hub http://192.168.0.82:4444/grid/register

        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setPlatform(Platform.WINDOWS);
        URL url = new URL("http://192.168.0.82:4444/wd/hub");

        WebDriver driver = new RemoteWebDriver(url,cap);

        try {

            driver.get("https://accounts.google.com/");
            driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(user);
            driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();


            WebDriverWait wait = new WebDriverWait(driver, 100);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password']")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
            WebElement elementpwd = driver.findElement(By.xpath("//input[@type='password']"));
            elementpwd.sendKeys(password);

            driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span")).click();
            WebDriverWait wait1 = new WebDriverWait(driver, 100);
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"gbwa\"]")));
            driver.findElement(By.xpath("//*[@id=\"gbwa\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"gb23\"]")).click();

            WebDriverWait waitGmail = new WebDriverWait(driver, 100);
            waitGmail.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"gbqfq\"]")));
            driver.findElement(By.xpath("//*[@id=\"gbqfq\"]")).sendKeys(searching_name);
            driver.findElement(By.xpath("//*[@id=\"gbqfb\"]")).click();


//            #\3a 2 > div > div:nth-child(2) > div.ae4.UI.UJ > div.Cp > div  #\3a 6k > tbody  #\3a 6l
//            #\3a 6k  #\3a 2 > div > div:nth-child(2) > div.ae4.UI.UJ        #\3a 2 > div > div:nth-child(2) > div.ae4.UI.UJ
//*[@id=":6k"]

            //int a = driver.findElements(By.id(":6K")).size();
            //int a = driver.findElements(By.name("nXDxbd")).size();
            int a = driver.findElements(By.xpath("//*[@id=\":93\"]/span/span[2]")).size();



            JOptionPane.showMessageDialog(null, a);
            driver.quit();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "освободить node");
            driver.quit();
        }
        driver.quit();
        return null;
        }


    }




