import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class HomePageIT {

  private WebDriver driver;

  @BeforeAll
  static void setupAll() {
    WebDriverManager.chromedriver().setup();
  }

  @BeforeEach
  void setup() {
    driver = new ChromeDriver();
  }

  @AfterEach
  void teardown() {
    driver.quit();
  }

  @Test
  void test() {
    driver.get("http://localhost:8080");
    
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    
    // Find the button using XPath
    WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/button")));
    
    // Click the button
    button.click();
    
    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h1"), "x"));
    
    // Get the h1 element
    WebElement h1Element = driver.findElement(By.tagName("h1"));
    
    // Get the text inside the h1 element
    String h1Text = h1Element.getText();
    
    assertEquals("x", h1Text);
    
    driver.quit();
  }
}
