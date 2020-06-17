import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TrelloQA {
    WebDriver driver;
    public static final String BOARD_TITLE = "QA Haifa56";
    public static final String LOGIN = "yantashikan@gmail.com";
    public static final String PASSWORD = "ACSd47pifP36QZV";
    public static final int SHORT_PAUSE = 5000;
    public static final int MID_PAUSE = 10000;
    public static final int LONG_PAUSE = 20000;



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

    public void loginProcedure() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();
        Thread.sleep(MID_PAUSE);
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys(LOGIN);
        Thread.sleep(SHORT_PAUSE);
        driver.findElement(By.xpath("//input[@id='login']")).click();
        Thread.sleep(SHORT_PAUSE);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(PASSWORD);
        Thread.sleep(MID_PAUSE);
        driver.findElement(By.xpath("//button[@id='login-submit']")).click();
        Thread.sleep(LONG_PAUSE);
        int keyElement=driver.findElements(By.xpath("//h3[@class='boards-page-board-section-header-name']")).size();
        if(keyElement>0){
            System.out.println("Boards list detected. Login - OK");
        }else{
            System.out.println("Boards list not found. Login - failed");
            Assert.fail();
        }
        Thread.sleep(SHORT_PAUSE);
    }

}
