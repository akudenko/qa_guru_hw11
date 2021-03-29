package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

  SelenideElement title = $(".container h1");

  @Step("Проверить название товара: {text}")
  public void checkTitle(String text) {
    title.shouldHave(text(text));
  }
}
