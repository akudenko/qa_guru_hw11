package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

  SelenideElement titleOfProduct = $(".cart-list__item a");

  @Step("Cart should have product: {text}")
  public void checkTitleOfProduct(String text) {
    titleOfProduct.shouldHave(text(text));
  }
}
