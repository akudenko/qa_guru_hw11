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
  }

  @Step("Ввести в строку поиска текс: {text}")
  public void fillSearchInput(String text) {
    searchInput.val(text);
  }

  @Step("Кликнуть по кнопке 'Найти' в строке поиска")
  public void clickByFindBtn() {
    searchBtn.click();
  }

}
