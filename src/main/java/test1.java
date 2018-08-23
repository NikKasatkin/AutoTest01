import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.eclipse.sisu.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

@Epic("Авто Тест GMAIL")
@Feature("Gmail на CHROME ")
public class test1 {
    @Test (description = "Тестовое задание на вакансию" +
            "Разработчик в тестировании")
    @io.qameta.allure.Description("Необходимо:\n\n" +
            "        1) Использовать Python/Java/C#, подключить библиотеку Selenium Webdriver;\n\n" +
            "        2) С помощью Selenium открыть браузер, открыть gmail.com, авторизоваться, зайти на почту;\n\n" +
            "        3) В списке писем найти письма от Филинина Ильи (использовать поиск,предусмотренный самой почтой);\n" +
            "        4) с помощью Selenium определить, сколько нашлось писем;\n\n" +
            "        5) С помощью Selenium и интерфейса почты автоматически написать и отправить письмо Филинину Илье,\n\n" +
            "        в тексте которого указать найденное в шаге 4 количество писем. Указать тему")

    public void login() throws InterruptedException, MalformedURLException {


        mailru_page mailru_page1 =  new mailru_page();
        mailru_page1.logging_in("i.human.new@gmail.com","1gctugfags", "i_human@list.ru" ); //i_lead_master@list.ru : i_human@list.ru



    }
}

