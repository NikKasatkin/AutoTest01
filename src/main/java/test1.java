import com.codeborne.selenide.Selenide;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class test1 {
    @Test
    public void login() throws InterruptedException, MalformedURLException {


        mailru_page mailru_page1 =  new mailru_page();
        mailru_page1.logging_in("i.human.new@gmail.com","1gctugfags", "i_human@list.ru" );



    }
}

