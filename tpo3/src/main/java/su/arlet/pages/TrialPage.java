package su.arlet.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class TrialPage {
    @FindBy(xpath = "//*[@id=\"name-yui_3_17_2_3_1498059440404_5852\"]/div[1]/label/div/div")
    private WebElement firstNameLabel;

    @FindBy(xpath = "//*[@id=\"name-yui_3_17_2_3_1498059440404_5852-fname-field\"]")
    private WebElement firstNameEntry;

    @FindBy(xpath = "//*[@id=\"name-yui_3_17_2_3_1498059440404_5852\"]/div[2]/label/div/div")
    private WebElement lastNameLabel;

    @FindBy(xpath = "//*[@id=\"name-yui_3_17_2_3_1498059440404_5852-lname-field\"]")
    private WebElement lastNameEntry;

    @FindBy(xpath = "//*[@id=\"text-yui_3_17_2_1_1498059440404_48339\"]/label/div/div/span[1]")
    private WebElement companyLabel;

    @FindBy(xpath = "//*[@id=\"text-yui_3_17_2_1_1498059440404_48339-field\"]")
    private WebElement companyEntry;

    @FindBy(xpath = "//*[@id=\"email-yui_3_17_2_3_1498059440404_5853\"]/label/div/div/span[1]")
    private WebElement emailAddressLabel;

    @FindBy(xpath = "//*[@id=\"email-yui_3_17_2_3_1498059440404_5853-field\"]")
    private WebElement emailAddressEntry;

    @FindBy(xpath = "//*[@id=\"textarea-yui_3_17_2_3_1498059440404_5855\"]/label/div/div/span[1]")
    private WebElement availabilityLabel;

    @FindBy(xpath = "//*[@id=\"textarea-yui_3_17_2_3_1498059440404_5855-field\"]")
    private WebElement availabilityEntry;

    @FindBy(xpath = "//*[@id=\"block-yui_3_17_2_3_1498059440404_5847\"]/div/div[2]/form/div[3]/button")
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
