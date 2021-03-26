package tests;

import org.junit.jupiter.api.BeforeAll;
import pages.HomePage;
import pages.SearchResultPage;

import static helpers.DriverHelper.configureDriver;

public class TestBase {

  HomePage homePage = new HomePage();
  SearchResultPage searchResultPage = new SearchResultPage();

  @BeforeAll
  public static void beforeAll() {
    configureDriver();
  }
}
