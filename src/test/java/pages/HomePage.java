package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

  SelenideElement submitCityBtn = $(".header__tower-panel a");
  SelenideElement searchInput = $("#search");
  SelenideElement searchBtn = $(byText("Найти"));

  @Step("Открыть главную страницу")
  public void openHomePage() {
    open("/");
    submitCityBtn.click();
  }

  @Step("Найти товары по запросу: {text}")
  public void findProductsByText(String text) {
    searchInput.val(text);
    searchBtn.click();
  }

}
