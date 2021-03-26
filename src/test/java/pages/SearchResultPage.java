package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {

  SelenideElement resultTitle = $(".container h1");

  @Step("Страница содержит заголовок поискового запроса: {text}")
  public SelenideElement checkResultTitle(String text) {
    return resultTitle.shouldHave(text(text));
  }

}
