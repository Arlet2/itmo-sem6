package su.arlet.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class TrialPage {
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div/div[2]/form/div[2]/fieldset/div[1]")
    private WebElement firstNameLabel;

    @FindBy(xpath = "//*[@id=\"name-yui_3_17_2_3_1498059440404_5852-fname-field\"]")
    private WebElement firstNameEntry;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div/div[2]/form/div[2]/fieldset/div[2]")
    private WebElement lastNameLabel;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div/div[2]/form/div[2]/fieldset/div[2]/input")
    private WebElement lastNameEntry;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div/div[2]/form/div[2]/div[1]")
    private WebElement companyLabel;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div/div[2]/form/div[2]/div[1]/input")
    private WebElement companyEntry;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div/div[2]/form/div[2]/div[2]")
    private WebElement emailAddressLabel;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div/div[2]/form/div[2]/div[2]/input")
    private WebElement emailAddressEntry;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div/div[2]/form/div[2]/div[3]")
    private WebElement availabilityLabel;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div/div[2]/form/div[2]/div[3]/textarea")
    private WebElement availabilityEntry;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div/div[2]/form/div[3]/button")
    private WebElement submitButton;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div/div[2]/form/div[1]/div/div/p")
    private WebElement formWarning;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div/div[2]/form/div[2]/fieldset/legend/div/p")
    private WebElement nameWarning;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div/div[2]/form/div[2]/fieldset/div[1]/label/div/p")
    private WebElement firstNameWarning;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div/div[2]/form/div[2]/fieldset/div[2]/label/div/p")
    private WebElement lastNameWarning;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div/div[2]/form/div[2]/div[1]/label/div/p")
    private WebElement companyWarning;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div/div[2]/form/div[2]/div[2]/label/div/p")
    private WebElement emailAddressWarning;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div/div[2]/form/div[2]/div[3]/label/div/p")
    private WebElement availabilityWarning;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div/div[2]/div/div/p")
    private WebElement finalLabel;

    public WebDriver webDriver;

    public TrialPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
}
