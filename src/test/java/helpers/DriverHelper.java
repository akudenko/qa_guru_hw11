package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class DriverHelper {

  public static void configureDriver() {
    addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

    Configuration.baseUrl = "https://www.eapteka.ru";
  }

  public static void clearSession() {
    Selenide.clearBrowserCookies();
    Selenide.clearBrowserLocalStorage();
  }

}
