package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

  SelenideElement searchInput = $("[name='search']");
  SelenideElement searchBtn = $(byText("Знайти"));
  SelenideElement firstSearchTip = $(".searchbar__tips div a");

  @Step("Open the home page")
  public void openHomePage() {
    open("/");
  }

  @Step("Fill a request in the search: {text}")
  public void fillSearchInput(String text) {
    searchInput.val(text);
  }

  @Step("Click on the search button")
  public void clickByFindBtn() {
    searchBtn.click();
  }

  @Step("Кликнуть по первому элементу подсказки поиска")
  public void clickByFirstSearchTip() {
    firstSearchTip.click();
  }

}
