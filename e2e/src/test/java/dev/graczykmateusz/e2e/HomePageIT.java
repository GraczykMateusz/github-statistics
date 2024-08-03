package dev.graczykmateusz.e2e;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.imageio.ImageIO;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageIT {

  private WebDriverManager wdm;
  private WebDriver driver;

  @BeforeClass
  public void setupAll() {
    try {
      // Initialize WebDriverManager with Docker settings
      wdm = WebDriverManager.chromedriver()
              .dockerNetwork("github-statistics_default")
              .browserInDocker();
      System.out.println("WebDriverManager setup completed.");
    } catch (Exception e) {
      System.err.println("Error during WebDriverManager setup: " + e.getMessage());
      e.printStackTrace();
    }
  }

  @BeforeMethod
  public void setup() {
    try {
      // Create the WebDriver instance
      driver = wdm.create();
      driver.manage().window().maximize();
      System.out.println("WebDriver instance created and maximized.");
    } catch (Exception e) {
      System.err.println("Error during WebDriver creation: " + e.getMessage());
      e.printStackTrace();
    }
  }

  @AfterMethod
  public void teardown() {
    wdm.quit();
  }

  @Test
  public void shouldDisplayChartWithData() throws IOException, InterruptedException {
    try {
      // Navigate to the test application
      driver.get("http://github-statistics-app:8081");

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      // Wait for the chart to be visible
      WebElement chartCanvas = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("github-user-statistic-chart")));

      // Find the input field and send data
      WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));
      input.sendKeys("graczykmateusz");

      // Find and click the submit button
      WebElement submitLogin = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit-login")));
      submitLogin.click();

      // Sleep to allow chart to render (consider replacing with a more robust wait condition)
      Thread.sleep(3000);

      // Take screenshot of the entire page
      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      BufferedImage fullImage = ImageIO.read(screenshot);

      // Get the location and size of the chart
      Point point = chartCanvas.getLocation();
      int chartWidth = chartCanvas.getSize().getWidth();
      int chartHeight = chartCanvas.getSize().getHeight();

      // Crop the screenshot to get only the chart
      BufferedImage chartScreenshot = fullImage.getSubimage(point.getX(), point.getY(), chartWidth, chartHeight);

      // Get the center color of the chart
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

    } catch (Exception e) {
      System.err.println("Error during test execution: " + e.getMessage());
      e.printStackTrace();
      throw e; // Re-throw the exception to make sure the test fails
    }
  }
}
