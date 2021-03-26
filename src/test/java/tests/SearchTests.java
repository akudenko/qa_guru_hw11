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
    homePage.findProductsByText("анальгин");
    searchResultPage.checkResultTitle("«анальгин»");
  }
}
