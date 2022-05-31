import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FromCardToCard {

    @Test
    public void checkP2pFunction(){

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.get("https://next.privat24.ua/money-transfer/card");

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

    }
}
