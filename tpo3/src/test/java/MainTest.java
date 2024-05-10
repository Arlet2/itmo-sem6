import org.junit.jupiter.api.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import su.arlet.ConfProperties;
import su.arlet.pages.MainPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    public static WebDriver chromeDriver;
    private static MainPage mainPage;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        chromeDriver.get(ConfProperties.getProperty("mainpage"));
        mainPage = new MainPage(chromeDriver);
    }

    @AfterAll
    public static void close() {
        chromeDriver.close();
    }

    @DisplayName("Check title")
    @Test
    public void checkTitle() {
        var expectedTitle = "A Powerful, Reliable and Affordable Web Chat Solution";

        assertEquals(expectedTitle, mainPage.getTitle().getText());
    }

    @DisplayName("Check learn more button")
    @Test
    public void checkLearnMoreButton() {
        var expectedValue = "LEARN MORE";
        var expectedLink = "https://www.engage.co/engage-features";

        assertEquals(expectedValue, mainPage.getLearnMoreButton().getText());
        assertEquals(expectedLink, mainPage.getLearnMoreButton().getAttribute("href"));
    }

    @DisplayName("Check search footer")
    @Test
    public void checkSearchFooter() {
        var expectedTitle = "Try Engage on Your Website Right Now";
        var expectedEntryHint = "www.yourwebsite.com";
        var expectedButtonLabel = "go";

        assertEquals(expectedTitle, mainPage.getSearchTitle().getText());
        assertEquals(expectedEntryHint, mainPage.getSearchEntry().getAttribute("placeholder"));
        assertEquals(expectedButtonLabel, mainPage.getSearchButton().getAttribute("value"));
    }

}
