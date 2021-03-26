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
}
