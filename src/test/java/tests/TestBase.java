package tests;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultPage;

import static helpers.DriverHelper.clearSession;
import static helpers.DriverHelper.configureDriver;

public class TestBase {

  HomePage homePage = new HomePage();
  SearchResultPage searchResultPage = new SearchResultPage();
  ProductPage productPage = new ProductPage();
  CartPage cartPage = new CartPage();

  @BeforeAll
  public static void beforeAll() {
    configureDriver();
  }

  @AfterEach
  public void clear() {
    clearSession();
  }
}
