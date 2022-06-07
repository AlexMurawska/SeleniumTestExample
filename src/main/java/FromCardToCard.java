import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FromCardToCard {

    @Test
    public void checkP2pFunction(){

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //А не появился ли элемент, если да то выполнится действие
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        //Приоритетное, гораздо более высокая сокрость
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));



        driver.get("https://next.privat24.ua/money-transfer/card");

        // Лучше использовать фулскрин
        driver.manage().window().fullscreen();
        //  driver.manage().window().maximize();

        By fromCardNumber = By.xpath("//input[@data-qa-node='numberdebitSource']");
        By fromExpDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
        By fromCvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
        By firstName = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
        By lastName = By.xpath("//input[@data-qa-node='lastNamedebitSource']");

        By numberReceiver = By.xpath("//input[@data-qa-node='numberreceiver']");
        By nameReceiver = By.xpath("//input[@data-qa-node='firstNamereceiver']");
        By lastNameReceiver = By.xpath("//input[@data-qa-node='lastNamereceiver']");
        By amount = By.xpath("//input[@data-qa-node='amount']");
        By spanComment = By.xpath("//span[@data-qa-node='toggle-comment']");
        By textareaComment = By.xpath("//div/div/div/div/div/div/textarea");
        By submitButton = By.xpath("//button[@class='sc-VigVT hcHAAV']");
        By submitButton2 = By.xpath("//div[@class='sc-fjdhpX lgAFJC']");



        driver.findElement(fromCardNumber).sendKeys("4006 8956 8904 8337");
        driver.findElement(fromExpDate).sendKeys("1128");
        driver.findElement(fromCvv).sendKeys("111");
        driver.findElement(firstName).sendKeys("Barak");
        driver.findElement(lastName).sendKeys("Obama");

        driver.findElement(numberReceiver).sendKeys("4558 0328 5584 1715");
        driver.findElement(nameReceiver).sendKeys("Petro");
        driver.findElement(lastNameReceiver).sendKeys("Poroshenko");
        driver.findElement(amount).sendKeys("500");
        driver.findElement(spanComment).click();
        driver.findElement(textareaComment).sendKeys("Glory to Ukraine!");
        driver.findElement(submitButton).submit();
        driver.findElement(submitButton2).submit();

        System.out.println("TEXT: " + driver.findElement(By.xpath("//div[@data-qa-node='details']")).getText());

//        Как более короткий вариант
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@data-qa-node='details']"),
//        "Переказ власних коштів. Glory to Ukraine!"));


        Assertions.assertEquals("Переказ власних коштів. Glory to Ukraine!", driver.findElement(By.xpath("//div[@data-qa-node='details']")).getText());
        Assertions.assertEquals("4006 **** **** 8337", driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div[2]/div[1]/table/tbody/tr/td[3]")).getText());
        Assertions.assertEquals("4558 **** **** 1715", driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div[2]/div[1]/table/tbody/tr/td[4]/span")).getText());
        Assertions.assertEquals("500 UAH", driver.findElement(By.xpath("//div[@data-qa-node='amount']")).getText());


      //  System.out.println(driver.findElement(By.xpath("//div[@data-qa-node='amount']")).getText());

//        By linkTerms = By.xpath("//a[@href='https://privatbank.ua/terms']");
//        driver.findElement(linkTerms).click();
//        driver.switchTo().window(String.valueOf(driver.getWindowHandles().toArray()[1]));
//        driver.switchTo().window();


        // получить текущий адрес страницы
        // System.out.println(driver.getCurrentUrl());

        //куки
        //System.out.println("All cookies" + driver.manage().getCookies());

        /**
         * Команды Selenium:
         * 1. get() - переход на URL
         * 2. to() - переход на URL
         * 3. sendKeys() - ввод текста
         * 4. click() - нажатие на элемент
         * 5. submit - подтверждение формы
         * 6. findElement() - поиск элемента по определенной стратегии
         * 7. close() - закрыть окно браузера и если оно последнее, то и весь браузер
         * 8. quick() - закрыть драйвер и браузер.
         * 9. implicitlyWait() - яснове ожидание элемента определенное время
         * 10. manage.fullScreen() - полный размер экрана
         * 11. manage.maximize() - полный размер экрана но не как опция fullscreen в Chrome. Растянутое окно
         * 12. forward, backward, refresh - базовые три команды в браузере с окном
         * 13. switchTo().window(String.valueOf(driver.getWindowHandles().toArray()[1])); - переключени по индексу окна
         * */

    }
}
