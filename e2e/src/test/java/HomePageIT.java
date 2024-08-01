import static org.assertj.core.api.Assertions.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.imageio.ImageIO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
    var chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--search-engine-choice-country");
    driver = new ChromeDriver(chromeOptions);
    driver.manage().window().setSize(new Dimension(1920, 1080));
  }

  @AfterEach
  void teardown() {
    driver.quit();
  }

  @Test
  void shouldDisplayChartWithData() throws IOException, InterruptedException {
    driver.get("http://0.0.0.0:8081");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Chart exists
    WebElement chartCanvas = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("github-user-statistic-chart")));

    // Find the button
    WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));

    // Send data to backend
    input.sendKeys("graczykmateusz");
    WebElement submitLogin =
        wait.until(ExpectedConditions.elementToBeClickable(By.id("submit-login")));
    submitLogin.click();

    Thread.sleep(3000); // todo need to find another way to wait for chart displaying

    // Make entire page screenshot
    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    BufferedImage fullImage = ImageIO.read(screenshot);

    // Get the location of chart on the page
    Point point = chartCanvas.getLocation();

    // Get width and height of the chart
    int chartWidth = chartCanvas.getSize().getWidth();
    int chartHeight = chartCanvas.getSize().getHeight();

    // Crop the entire page screenshot to get only chart screenshot
    BufferedImage chartScreenshot =
        fullImage.getSubimage(point.getX(), point.getY(), chartWidth, chartHeight);

    Dimension chartDimension = chartCanvas.getSize();
    int chartCenterX = chartDimension.getWidth() / 2;
    int chartCenterY = chartDimension.getHeight() / 2;

    int chartCenterColor = chartScreenshot.getRGB(chartCenterX, chartCenterY);

    int blue = chartCenterColor & 0xff;
    int green = (chartCenterColor & 0xff00) >> 8;
    int red = (chartCenterColor & 0xff0000) >> 16;
    int alpha = (chartCenterColor & 0xff000000) >>> 24;

    int tolerance = 25; // Allow a tolerance of +/- 25 for each color component

    // Expected color values
    List<Integer> expectedColor = List.of(175, 207, 243, 255);

    // Actual color values
    List<Integer> actualColor = List.of(red, green, blue, alpha);

    // Assert with tolerance
    for (int i = 0; i < expectedColor.size(); i++) {
      assertThat(actualColor.get(i))
          .isBetween(expectedColor.get(i) - tolerance, expectedColor.get(i) + tolerance);
    }
  }
}
