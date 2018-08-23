import com.fasterxml.jackson.databind.annotation.JsonAppend;
import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.eclipse.sisu.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import sun.print.DialogOnTop;
//import ru.yandex.qatools.allure.*;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


@Story("Используем CHROME для автотеста")
public class mailru_page  {

    public String  URL = "http://192.168.0.82:4444/wd/hub";

@Step
@Story("Вход в Gmail")

    public mailru_page logging_in ( String user, String password, String searching_name) throws InterruptedException, MalformedURLException {

        //настройка GRIT
        //java -jar selenium-server-standalone-3.14.0.jar -role hub                                                -hub
        //java -jar selenium-server-standalone-3.14.0.jar -role node  -hub http://localhost:4444/grid/register     -local
        //java -jar selenium-server-standalone-3.14.0.jar -role node  -hub http://192.168.0.82:4444/grid/register  -web


        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setPlatform(Platform.WINDOWS);
        URL url = new URL(URL); // http://localhost:4444/wd/hub

        WebDriver driver = new RemoteWebDriver(url,cap);

        try {  // for helpful

            //login
            driver.get("https://accounts.google.com/");
            driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(user);
            driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();

            //pass
            WebDriverWait wait = new WebDriverWait(driver, 100);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password']")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
            WebElement elementpwd = driver.findElement(By.xpath("//input[@type='password']"));
            elementpwd.sendKeys(password);
            driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span")).click();

            //add gmail in menu
            WebDriverWait wait1 = new WebDriverWait(driver, 100);
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"gbwa\"]")));
            driver.findElement(By.xpath("//*[@id=\"gbwa\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"gb23\"]")).click();

            //selection menu
            WebDriverWait waitGmail = new WebDriverWait(driver, 100);
            waitGmail.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"aso_search_form_anchor\"]/button[2]")));
            driver.findElement(By.xpath("//*[@id=\"aso_search_form_anchor\"]/button[2]")).click();
            waitGmail.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"ZH nr aQa\"]")));
            driver.findElement(By.xpath("//*[@class=\"ZH nr aQa\"]")).sendKeys(searching_name);
            driver.findElement(By.xpath("//*[@data-tooltip=\"Поиск почты\"]")).click();

            //take a count letters
            List<WebElement> rows_table = driver.findElement(By.xpath("//*[@class=\"F cf zt\"]/tbody")).findElements(By.xpath("//*[@email=\""+searching_name+"\"]"));
            int rows_count = rows_table.size();
            long result = rows_count / 2; // on row we have a two email , that we are / 2

            //message on window
            final JDialog dialog = new JDialog();
            dialog.setAlwaysOnTop(true);// on top window
            if (result != 0) {
                driver.findElement(By.xpath("//*[@class=\"z0\"]/div")).click();
                waitGmail.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"vO\"]")));
                driver.findElement(By.xpath("//*[@class=\"vO\"]")).sendKeys(searching_name);
                driver.findElement(By.xpath("//*[@name=\"subjectbox\"]")).sendKeys("Тестовое задание от Касаткина Николая");
                driver.findElement(By.xpath("//*[@class=\"Am Al editable LW-avf\"]")).sendKeys("колличество писем = "+result);
                driver.findElement(By.xpath("//*[@class=\"J-J5-Ji btA\"]")).click();
                JOptionPane.showMessageDialog(dialog, "Писем от  " + searching_name + "  " + result + " шт.");
            }
            driver.quit();

        }catch (Exception e) {

            //exeption logic
            final JDialog dialog = new JDialog();
            dialog.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(dialog, "ошибка логики  необходимо освободить node");
            driver.quit();
        }



        //clean nodes on hub
        //driver.quit();
        return null;
        }



    }




