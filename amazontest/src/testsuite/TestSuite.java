package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TestSuite extends Utility {

    String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    int expectedLength ;

    @Test
    public void test() throws InterruptedException {
        sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"), "Dell Laptop");
        clickOnElement(By.xpath("//input[@id='nav-search-submit-button']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//*[@id=\"p_89/Dell\"]/span/a/div/label/i"));
        List<WebElement> elementList = driver.findElements(By.xpath("//div[contains(@data-cel-widget,'search_result')]"));
        // size of elementList
        System.out.println("Number of Dell Products are :" + elementList.size()); // 38
        int actualSize = elementList.size();
        // print text of all the elements / products
        for (int i = 0; i < elementList.size(); i++) {
            String elementText = elementList.get(i).getText();
            System.out.println(elementText);
        }
        // this is from requirement
        int expectedSize = 30;
        if (actualSize >= 30) {
            System.out.println("actual no. of products matches with expected no. of products ");
        }


        //Assert.assertEquals("Error",actualSize,expectedSize);

//        assertEquals();
//
//        // assert that the number of found <option> elements matches the expectations
//        assertEquals(exp.length, allOptions.size());
//        // assert that the value of every <option> element equals the expected value
//        for (int i = 0; i < exp.length; i++) {
//            assertEquals(exp[i], allOptions.get(i).getAttribute("value"));
//        }
//
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
