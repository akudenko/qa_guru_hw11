package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {

  SelenideElement resultTitle = $(".container h1");
  ElementsCollection qtyOfFoundedProducts = $$(".cc-item--group section");

  @Step("Страница содержит заголовок поискового запроса: {text}")
  public SelenideElement checkResultTitle(String text) {
    return resultTitle.shouldHave(text(text));
  }

  @Step("Кол-во найденных продуктов больше или равно единице")
  public void checkQtyOfFoundedProducts() {
    qtyOfFoundedProducts.shouldHave(CollectionCondition.sizeGreaterThanOrEqual(1));
  }

}
