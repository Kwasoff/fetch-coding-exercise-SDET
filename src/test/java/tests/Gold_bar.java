package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Gold_bar {
    @Test
    public void goldBarGame() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://sdetchallenge.fetch.com/");
        driver.manage().window().maximize();

        WebElement left_bowl_first_cell = driver.findElement(By.id("left_0"));
        left_bowl_first_cell.sendKeys("0");
        WebElement left_bowl_second_cell = driver.findElement(By.id("left_1"));
        left_bowl_second_cell.sendKeys("1");
        WebElement left_bowl_third_cell = driver.findElement(By.id("left_2"));
        left_bowl_third_cell.sendKeys("2");
        WebElement left_bowl_fourth_cell = driver.findElement(By.id("left_3"));
        left_bowl_fourth_cell.sendKeys("3");

        WebElement right_bowl_first_cell = driver.findElement(By.id("right_0"));
        right_bowl_first_cell.sendKeys("4");
        WebElement right_bowl_second_cell = driver.findElement(By.id("right_1"));
        right_bowl_second_cell.sendKeys("5");
        WebElement right_bowl_third_cell = driver.findElement(By.id("right_2"));
        right_bowl_third_cell.sendKeys("6");
        WebElement right_bowl_fourth_cell = driver.findElement(By.id("right_3"));
        right_bowl_fourth_cell.sendKeys("7");

        WebElement reset_button = driver.findElement(By.xpath("//*[.='Reset']"));
        WebElement weight_button = driver.findElement(By.xpath("//*[.='Weigh']"));
        weight_button.click();

        WebElement result_box = driver.findElement(By.xpath("(//button[@id='reset'])[1]"));
        Thread.sleep(2000);

        List<WebElement> coins = driver.findElements(By.xpath("//div[@class='coins']/button"));

        if (result_box.getText().equals("=")){
            coins.get(coins.size()-1).click();
        }
        else if (result_box.getText().equals("<")){
            reset_button.click();
            left_bowl_first_cell.sendKeys("0");
            left_bowl_second_cell.sendKeys("1");
            right_bowl_first_cell.sendKeys("2");
            right_bowl_second_cell.sendKeys("3");
            weight_button.click();
            Thread.sleep(2000);
            if (result_box.getText().equals("<")){
                reset_button.click();
                left_bowl_first_cell.sendKeys("0");
                right_bowl_first_cell.sendKeys("1");

                weight_button.click();
                Thread.sleep(2000);
                if (result_box.getText().equals("<")){
                    coins.get(0).click();
                }
                else {
                    coins.get(1).click();
                }
            }
            else {
                reset_button.click();
                left_bowl_first_cell.sendKeys("2");
                right_bowl_first_cell.sendKeys("3");

                weight_button.click();
                Thread.sleep(2000);
                if (result_box.getText().equals("<")){
                    coins.get(2).click();
                }
                else {
                    coins.get(3).click();
                }
            }
        }
        else if (result_box.getText().equals(">")){
            reset_button.click();
            left_bowl_first_cell.sendKeys("4");
            left_bowl_second_cell.sendKeys("5");
            right_bowl_first_cell.sendKeys("6");
            right_bowl_second_cell.sendKeys("7");
            weight_button.click();
            Thread.sleep(2000);
            if (result_box.getText().equals("<")){
                reset_button.click();
                left_bowl_first_cell.sendKeys("4");
                right_bowl_first_cell.sendKeys("5");

                weight_button.click();
                Thread.sleep(2000);
                if (result_box.getText().equals("<")){
                    coins.get(4).click();
                }
                else {
                    coins.get(5).click();
                }
            }
            else {
                reset_button.click();
                left_bowl_first_cell.sendKeys("6");
                right_bowl_first_cell.sendKeys("7");

                weight_button.click();
                Thread.sleep(2000);
                if (result_box.getText().equals("<")){
                    coins.get(6).click();
                }
                else {
                    coins.get(7).click();
                }
            }
        }
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String alert_text = alert.getText();
        Thread.sleep(2000);
        alert.accept();
        Assert.assertTrue("Try one more time!", alert_text.contains("Yay! You find it!"));

        driver.quit();
    }

}
