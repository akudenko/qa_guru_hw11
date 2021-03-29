package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

  SelenideElement searchInput = $("#search");
  SelenideElement searchBtn = $(byText("Найти"));
  SelenideElement firstSearchTip = $(".searchbar__tips div a");

  @Step("Открыть главную страницу")
  public void openHomePage() {
    open("/");
  }

  @Step("Ввести в строку поиска текст: {text}")
  public void fillSearchInput(String text) {
    searchInput.val(text);
  }

  @Step("Кликнуть по кнопке 'Найти'")
  public void clickByFindBtn() {
    searchBtn.click();
  }

  @Step("Кликнуть по первому элементу подсказки поиска")
  public void clickByFirstSearchTip() {
    firstSearchTip.click();
  }

}
