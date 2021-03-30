package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

  SelenideElement title = $(".product__heading h1");

  @Step("Product should have title: {text}")
  public void checkTitle(String text) {
    title.shouldHave(text(text));
  }
}
