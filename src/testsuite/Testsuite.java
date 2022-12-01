package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class Testsuite extends Utility {
    String baseUrl = "https://www.amazon.co.uk/";


    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyDellLoptop() throws InterruptedException {
        sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"), "Dell Laptop");
        clickOnElement(By.xpath("//input[@id='nav-search-submit-button']"));
        Thread.sleep(7000);
        clickOnElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[3]/span/div[1]/div/div/div[1]/ul/li/span/a/div[1]/label/i"));
        Thread.sleep(7000);

        //Get X path for all the products
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']//span[@class='a-size-medium a-color-base a-text-normal']"));
        Thread.sleep(5000);
        System.out.println("Total products are: " + elements.size());
        for (WebElement e : elements) {
            System.out.println("_________________________________________________________________________________________");
            System.out.println(e.getText());//Print all individual products
            Thread.sleep(2000);
        }


    }

    @After
    public void TearDown() {
        closeBrowser();
    }
}
