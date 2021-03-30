package tests;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static config.ConfigHelper.isVideoOn;
import static helpers.AttachmentsHelper.*;
import static helpers.DriverHelper.*;

public class TestBase {

  HomePage homePage = new HomePage();
  SearchResultPage searchResultPage = new SearchResultPage();
  ProductPage productPage = new ProductPage();
  CartPage cartPage = new CartPage();

  @BeforeAll
  public static void beforeAll() {
    configureDriver();
  }

  @AfterEach
  public void addAttachments(){
    String sessionId = getSessionId();
    attachScreenshot("Last screenshot");
    attachPageSource();
    attachAsText("Browser console logs", getConsoleLogs());
    if (isVideoOn()) attachVideo(sessionId);
    closeWebDriver();
  }
}
