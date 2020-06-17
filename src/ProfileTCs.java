import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileTCs extends TrelloQA{

    @Test
    public void checkProfileLogos() throws InterruptedException {
        loginProcedure();
        driver.findElement(By.xpath("//*[@data-test-id='header-member-menu-button']")).click();
        Thread.sleep(SHORT_PAUSE);
        driver.findElement(By.xpath("//*[@data-test-id='header-member-menu-profile']")).click();
        Thread.sleep(SHORT_PAUSE);
        String profileMenuLogoText = driver.findElement(By.xpath("//*[@data-test-id='header-member-menu-button']//span[1]")).getText();
        String profileLogoText = driver.findElement(By.xpath("//*[@class='tabbed-pane-header-wrapper u-clearfix js-header-wrapper']//span[1]")).getText();
        if (profileLogoText.equals(profileMenuLogoText)){
            System.out.println("Profile logos test passed");
        }else{
            System.out.println("Profile logos test failed");
            Assert.fail();
        }


    }

    @Test
    public void checkProfileUsername() throws InterruptedException {
        loginProcedure();
        driver.findElement(By.xpath("//*[@data-test-id='header-member-menu-button']")).click();
        Thread.sleep(SHORT_PAUSE);
        driver.findElement(By.xpath("//*[@data-test-id='header-member-menu-profile']")).click();
        Thread.sleep(SHORT_PAUSE);
        String profileUsernameTitle= driver.findElement(By.xpath("//*[@class='tabbed-pane-header-wrapper u-clearfix js-header-wrapper']//span[2]")).getText();
        String profileUsernameField = '@'+driver.findElement(By.xpath("//input[@name='username']")).getAttribute("value");
        System.out.println(profileUsernameTitle);
        System.out.println(profileUsernameField);
        if(profileUsernameField.equals(profileUsernameTitle)){
            System.out.println("Profile username test passed");
        }else{
            System.out.println("Profile username test failed");
            Assert.fail();
        }


    }





}
