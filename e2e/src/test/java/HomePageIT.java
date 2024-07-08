import static org.assertj.core.api.Assertions.assertThat;

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

    // Chart exists
    WebElement chart = driver.findElement(By.id("github-user-statistic-chart"));
    assertThat(chart.isDisplayed()).isTrue();

    // Find the button using XPath
    WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));

    // Click the button
    input.sendKeys("graczykmateusz");

    WebElement submitLogin =
        wait.until(ExpectedConditions.elementToBeClickable(By.id("submit-login")));

    submitLogin.click();

    driver.quit();
  }
}
