package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SearchTests extends TestBase {

  @Test
  @DisplayName("Проверка заголовка на странице результатов поиска")
  @Tag("web")
  void searchTitleTest() {
    homePage.openHomePage();
    homePage.fillSearchInput("анальгин");
    homePage.clickByFindBtn();
    searchResultPage.checkResultTitle("«анальгин»");
  }

  @Test
  @DisplayName("Страница результатов поиска содержит товары")
  @Tag("web")
  void searchResultContainProducts() {
    homePage.openHomePage();
    homePage.fillSearchInput("анальгин");
    homePage.clickByFindBtn();
    searchResultPage.checkQtyOfFoundedProducts();
  }

  @Test
  @DisplayName("Отфильтровать найденные результаты")
  @Tag("web")
  void filteringTest() {
    homePage.openHomePage();
    homePage.fillSearchInput("анальгин");
    homePage.clickByFindBtn();
    searchResultPage.checkResultTitle("«анальгин»");
    int before = searchResultPage.getQtyOfFoundedProducts();
    searchResultPage.pickAnalginBrandFilter();
    int after = searchResultPage.getQtyOfFoundedProducts();
    searchResultPage.checkQtyOfProducts(before, after);
  }

  @Test
  @DisplayName("Открыть первый продукт из списка")
  @Tag("web")
  void openProductFromResultPageTest() {
    homePage.openHomePage();
    homePage.fillSearchInput("анальгин");
    homePage.clickByFindBtn();
    searchResultPage.checkResultTitle("«анальгин»");
    String name = searchResultPage.getFirstTitleOfProductsList();
    searchResultPage.openFirstProduct();
    productPage.checkTitle(name);
  }

  @Test
  @DisplayName("Добавить первый продукт из поиска в коризну")
  @Tag("web")
  void addProductTest() {
    homePage.openHomePage();
    homePage.fillSearchInput("анальгин");
    homePage.clickByFindBtn();
    searchResultPage.checkResultTitle("«анальгин»");
    String name = searchResultPage.getFirstTitleOfProductsList();
    searchResultPage.addToCart();
    searchResultPage.openCart();
    cartPage.checkTitleOfProduct(name);
  }
}
