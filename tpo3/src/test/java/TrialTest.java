import org.junit.jupiter.api.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import su.arlet.ConfProperties;
import su.arlet.pages.TrialPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrialTest {
    public static WebDriver chromeDriver;
    private static TrialPage trialPage;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeEach
    public void beforeEachTest() throws InterruptedException {
        chromeDriver.get(ConfProperties.getProperty("mainpage") + "/getstarted");
        trialPage = new TrialPage(chromeDriver);
        Thread.sleep(40000);
    }

    @AfterAll
    public static void close() {
        chromeDriver.close();
    }

    @DisplayName("Check form labels")
    @Test
    public void checkFormLabels() {
        var expectedFirstNameLabel = "First Name";
        var expectedLastNameLabel = "Last Name";
        var expectedCompanyLabel = "Company";
        var expectedEmailAddressLabel = "Email Address";
        var expectedAvailabilityLabel = "Availability";

        assertEquals(expectedFirstNameLabel, trialPage.getFirstNameLabel().getText());
        assertEquals(expectedLastNameLabel, trialPage.getLastNameLabel().getText());
        assertEquals(expectedCompanyLabel, trialPage.getCompanyLabel().getText());
        assertEquals(expectedEmailAddressLabel, trialPage.getEmailAddressLabel().getText());
        assertEquals(expectedAvailabilityLabel, trialPage.getAvailabilityLabel().getText());
    }

    @DisplayName("Check form restrictions")
    @Test
    public void checkFormRestrictions() {
        var expectedFormWarning = "Form submission failed. Review the following information: " +
                "Name, Company, Email Address, and Availability .";
        var expectedNameWarning = "Name is required.";
        var expectedCompanyWarning = "Company is required.";
        var expectedEmailAddressWarning = "Email Address is required.";
        var expectedAvailabilityWarning = "Availability is required.";

        trialPage.getSubmitButton().click();

        assertEquals(expectedFormWarning, trialPage.getFormWarning().getText());

        assertEquals(expectedNameWarning, trialPage.getNameWarning().getText());
        assertEquals(expectedCompanyWarning, trialPage.getCompanyWarning().getText());
        assertEquals(expectedEmailAddressWarning, trialPage.getEmailAddressWarning().getText());
        assertEquals(expectedAvailabilityWarning, trialPage.getAvailabilityWarning().getText());
    }

    @DisplayName("Check form name restrictions")
    @Test
    public void checkFormNameRestrictions() {
        var expectedFormWarning = "Form submission failed. Review the following information: " +
                "Name.";
        var expectedNameWarning = "Name is required.";

        trialPage.getCompanyEntry().sendKeys("test");
        trialPage.getEmailAddressEntry().sendKeys("test@test.com");
        trialPage.getAvailabilityEntry().sendKeys("test");

        trialPage.getSubmitButton().click();

        assertEquals(expectedFormWarning, trialPage.getFormWarning().getText());
        assertEquals(expectedNameWarning, trialPage.getNameWarning().getText());
    }

    @DisplayName("Check form first name restrictions")
    @Test
    public void checkFormFirstNameRestrictions() {
        var expectedFormWarning = "Form submission failed. Review the following information: " +
                "Name.";
        var expectedFirstNameWarning = "First Name is required.";

        trialPage.getCompanyEntry().sendKeys("test");
        trialPage.getEmailAddressEntry().sendKeys("test@test.com");
        trialPage.getAvailabilityEntry().sendKeys("test");

        trialPage.getLastNameEntry().sendKeys("Test");
        trialPage.getSubmitButton().click();

        assertEquals(expectedFormWarning, trialPage.getFormWarning().getText());
        assertEquals(expectedFirstNameWarning, trialPage.getFirstNameWarning().getText());
    }

    @DisplayName("Check form last name restrictions")
    @Test
    public void checkFormLastNameRestrictions() {
        var expectedFormWarning = "Form submission failed. Review the following information: " +
                "Name.";
        var expectedLastNameWarning = "Last Name is required.";

        trialPage.getCompanyEntry().sendKeys("test");
        trialPage.getEmailAddressEntry().sendKeys("test@test.com");
        trialPage.getAvailabilityEntry().sendKeys("test");

        trialPage.getFirstNameEntry().sendKeys("Test");
        trialPage.getSubmitButton().click();

        assertEquals(expectedFormWarning, trialPage.getFormWarning().getText());
        assertEquals(expectedLastNameWarning, trialPage.getLastNameWarning().getText());
    }

    @DisplayName("Check form not valid email")
    @Test
    public void checkNotValidEmail() {
        var expectedFormWarning = "Form submission failed. Review the following information: " +
                "Email Address.";
        var expectedEmailWarning = "Email Address is not valid. Email addresses should follow the format user@domain.com.";

        trialPage.getFirstNameEntry().sendKeys("Test");
        trialPage.getLastNameEntry().sendKeys("Test");
        trialPage.getCompanyEntry().sendKeys("test");
        trialPage.getEmailAddressEntry().sendKeys("test");
        trialPage.getAvailabilityEntry().sendKeys("test");

        trialPage.getSubmitButton().click();

        assertEquals(expectedFormWarning, trialPage.getFormWarning().getText());
        assertEquals(expectedEmailWarning, trialPage.getEmailAddressWarning().getText());
    }

    @DisplayName("Check sending")
    @Test
    public void checkSending() throws InterruptedException {
        var expectedFinalLabel = "We'll be in touch soon.";

        trialPage.getFirstNameEntry().sendKeys("Test");
        trialPage.getLastNameEntry().sendKeys("Test");
        trialPage.getCompanyEntry().sendKeys("test");
        trialPage.getEmailAddressEntry().sendKeys("test@test.com");
        trialPage.getAvailabilityEntry().sendKeys("test");

        trialPage.getSubmitButton().click();
        Thread.sleep(5000);

        assertEquals(expectedFinalLabel, trialPage.getFinalLabel().getText());
    }
}
