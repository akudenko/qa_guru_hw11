package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.ConfigHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class DriverHelper {

  public static void configureDriver() {
    addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

    Configuration.baseUrl = ConfigHelper.getWebUrl();

    if (ConfigHelper.isRemoteWebDriver()) {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability("enableVNC", true);
      capabilities.setCapability("enableVideo", true);
      Configuration.browserCapabilities = capabilities;
      Configuration.remote = ConfigHelper.getWebRemoteDriver();
    }
  }

  public static void clearSession() {
    Selenide.clearBrowserCookies();
    Selenide.clearBrowserLocalStorage();
  }

}
