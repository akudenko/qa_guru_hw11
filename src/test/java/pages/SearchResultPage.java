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

  SelenideElement resultTitle = $(".search-header h1");
  ElementsCollection qtyOfFoundedProducts = $$(".catalog-grid li");
  SelenideElement filterBrandRozetka = $("[for=Rozetka]");
  SelenideElement loader = $(".preloader");
  SelenideElement firstTitleOfProductsList = $(".catalog-grid .goods-tile__title");
  SelenideElement addToCartBtn = $(".catalog-grid .goods-tile__buy-button");
  SelenideElement cartIcon = $(".header__button--active");

  @Step("Result page contains the title: {text}")
  public SelenideElement checkResultTitle(String text) {
    return resultTitle.shouldHave(text("«" + text + "»"));
  }

  @Step("Quantity of found products should be greater or equal 1")
  public void checkQtyOfFoundedProducts() {
    qtyOfFoundedProducts.shouldHave(CollectionCondition.sizeGreaterThanOrEqual(1));
  }

  @Step("Get qty of found products")
  public int getQtyOfFoundedProducts() {
    return qtyOfFoundedProducts.size();
  }

  @Step("Apply filtering by brand: Rozetka")
  public void filteringByRozetkaBrand() {
    filterBrandRozetka.click();
    loader.should(disappear);
  }

  @Step("Qty of found products should not equal that was before filtering")
  public void checkQtyOfProducts(int before, int after) {
    Assertions.assertNotEquals(before, after);
  }

  @Step("Get the title of the first product from a list")
  public String getFirstTitleOfProductsList() {
    return firstTitleOfProductsList.getText();
  }

  @Step("Open the first product from a list")
  public void openFirstProduct() {
    firstTitleOfProductsList.click();
  }

  @Step("Add a first product to the cart")
  public void addToCart() {
    addToCartBtn.click();
  }

  @Step("Open the cart")
  public void openCart() {
    cartIcon.click();
  }

}
