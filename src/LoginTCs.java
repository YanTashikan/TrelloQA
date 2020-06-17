import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTCs extends TrelloQA {

    @Test
    public void positiveLoginByAtlassian() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys(LOGIN);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='login']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(PASSWORD);
        Thread.sleep(10000);
        driver.findElement(By.xpath("//button[@id='login-submit']")).click();
        Thread.sleep(20000);
        int keyElement=driver.findElements(By.xpath("//h3[@class='boards-page-board-section-header-name']")).size();
        if(keyElement>0){
            System.out.println("Boards list detected. Login - OK");
        }else{
            System.out.println("Boards list not found. ");
            Assert.fail();
        }
        Thread.sleep(5000);
    }

    @Test
    public void negativeLoginByWrongMail() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("abyrvalg@aburval.com");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(PASSWORD);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='login']")).click();
        int keyElement=driver.findElements(By.xpath("//*[contains(text(),\"There isn't an account for this email\")]")).size();
        Thread.sleep(5000);
        if(keyElement>0){
            System.out.println("Wrong mail detected - Wrong mail test passed");
        }else{
            System.out.println("Error message not found - Wrong mail test error");
            Assert.fail();
        }
        Thread.sleep(5000);
    }

    @Test
    public void negativeLoginByWrongMailAndWrongPswd() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("abyrvalg@aburval.com");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("wrongpassword");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='login']")).click();
        int keyElement=driver.findElements(By.xpath("//*[@class='error-message']")).size();
        Thread.sleep(5000);
        if(keyElement>0){
            System.out.println("Login error detected - Wrong mail and password test passed");
        }else{
            System.out.println("Error message not found - Wrong mail and password test error");
            Assert.fail();
        }
        Thread.sleep(5000);
    }

    @Test
    public void positiveLoginByAtlassianAndWrongPswd() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys(LOGIN);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='login']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(PASSWORD);
        Thread.sleep(10000);
        driver.findElement(By.xpath("//button[@id='login-submit']")).click();
        Thread.sleep(20000);
        int keyElement=driver.findElements(By.xpath("//*[@id='login-error']")).size();
        if(keyElement>0){
            if (driver.findElement(By.xpath("//*[@id='login-error']")).isDisplayed()){
                System.out.println("Login with Atlassian and wrong password test: Passed");
            }
        }else{
            System.out.println("Login with Atlassian and wrong password test: Error");
            Assert.fail();
        }
        Thread.sleep(5000);
    }

}
