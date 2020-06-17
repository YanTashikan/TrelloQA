import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TrelloQA {
    WebDriver driver;
    public static final String BOARD_TITLE = "QA Haifa56";
    public static final String LOGIN = "yantashikan@gmail.com";
    public static final String PASSWORD = "ACSd47pifP36QZV";



    @BeforeMethod
    public void initTestsSuit() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://trello.com/");
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
