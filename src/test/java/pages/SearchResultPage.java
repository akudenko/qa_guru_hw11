package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {

  SelenideElement resultTitle = $(".container h1");
  ElementsCollection qtyOfFoundedProducts = $$(".cc-item--group section");
  SelenideElement analginBrandFilter = $(By.linkText("Анальгин"));
  SelenideElement filteringLoader = $(".is-loading");
  SelenideElement firstTitleOfProductsList = $("section .cc-item--fields a");
  SelenideElement addToCartBtn = $(By.linkText("Купить"));
  SelenideElement cartIcon = $(".header--cart");

  @Step("Страница содержит заголовок поискового запроса: {text}")
  public SelenideElement checkResultTitle(String text) {
    return resultTitle.shouldHave(text(text));
  }

  @Step("Кол-во найденных продуктов больше или равно единице")
  public void checkQtyOfFoundedProducts() {
    qtyOfFoundedProducts.shouldHave(CollectionCondition.sizeGreaterThanOrEqual(1));
  }

  @Step("Получить кол-во найденных товаров")
  public int getQtyOfFoundedProducts() {
    return qtyOfFoundedProducts.size();
  }

  @Step("Применить фильтр: Бренд > Анальгин")
  public void pickAnalginBrandFilter() {
    analginBrandFilter.click();
    filteringLoader.shouldBe(disappear);
  }

  @Step("После применения фильтра кол-во товаров не должно совпадать")
  public void checkQtyOfProducts(int before, int after) {
    Assertions.assertNotEquals(before, after);
  }

  @Step("Получить название первого продукта из списка")
  public String getFirstTitleOfProductsList() {
    return firstTitleOfProductsList.getText();
  }

  @Step("Открыть первый товар из списка")
  public void openFirstProduct() {
    firstTitleOfProductsList.click();
  }

  @Step("Добавить первый продукт в коризну")
  public void addToCart() {
    addToCartBtn.click();
  }

  @Step("Открыть корзину")
  public void openCart() {
    cartIcon.click();
  }

}
