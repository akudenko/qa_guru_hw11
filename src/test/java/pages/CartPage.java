package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

  SelenideElement titleOfProduct = $(".cart-info__name a");
  SelenideElement cartTitle = $(".container h1");

  @Step("Проверить название продукта: {text}")
  public void checkTitleOfProduct(String text) {
    cartTitle.shouldBe(visible);
    titleOfProduct.shouldHave(text(text));
  }
}
