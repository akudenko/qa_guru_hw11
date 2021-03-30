package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SearchTests extends TestBase {

  private static String SEARCH_REQUEST = "macbook pro m1";

  @Test
  @DisplayName("Check the search title on the result page")
  @Tag("web")
  void searchTitleTest() {
    homePage.openHomePage();
    homePage.fillSearchInput(SEARCH_REQUEST);
    homePage.clickByFindBtn();
    searchResultPage.checkResultTitle(SEARCH_REQUEST);
  }

  @Test
  @DisplayName("Result page should contain products")
  @Tag("web")
  void searchResultContainProducts() {
    homePage.openHomePage();
    homePage.fillSearchInput(SEARCH_REQUEST);
    homePage.clickByFindBtn();
    searchResultPage.checkQtyOfFoundedProducts();
  }

  @Test
  @DisplayName("Filter products by brand 'Rozetka' on the result page")
  @Tag("web")
  void filterTest() {
    homePage.openHomePage();
    homePage.fillSearchInput(SEARCH_REQUEST);
    homePage.clickByFindBtn();
    searchResultPage.checkResultTitle(SEARCH_REQUEST);
    int before = searchResultPage.getQtyOfFoundedProducts();
    searchResultPage.filteringByRozetkaBrand();
    int after = searchResultPage.getQtyOfFoundedProducts();
    searchResultPage.checkQtyOfProducts(before, after);
  }

  @Test
  @DisplayName("Products can be opened from the result page")
  @Tag("web")
  void openProductFromResultPageTest() {
    homePage.openHomePage();
    homePage.fillSearchInput(SEARCH_REQUEST);
    homePage.clickByFindBtn();
    searchResultPage.checkResultTitle(SEARCH_REQUEST);
    String name = searchResultPage.getFirstTitleOfProductsList();
    searchResultPage.openFirstProduct();
    productPage.checkTitle(name);
  }

  @Test
  @DisplayName("Products can be added to the cart from the result page")
  @Tag("web")
  void addToCartTest() {
    homePage.openHomePage();
    homePage.fillSearchInput(SEARCH_REQUEST);
    homePage.clickByFindBtn();
    searchResultPage.checkResultTitle(SEARCH_REQUEST);
    String name = searchResultPage.getFirstTitleOfProductsList();
    searchResultPage.addToCart();
    searchResultPage.openCart();
    cartPage.checkTitleOfProduct(name);
  }
}
