package su.arlet.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class MainPage {
    @FindBy(xpath = "//*[@id=\"block-yui_3_17_2_1_1563245658595_11842\"]/div/div/h1/strong")
    private WebElement title;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/div/div/div/div[5]/div/div/a")
    private WebElement learnMoreButton;

    @FindBy(xpath = "//*[@id=\"block-yui_3_17_2_1_1643315368946_28759\"]/div/div/h1/strong")
    private WebElement searchTitle;

    @FindBy(xpath = "//*[@id=\"tbp_website\"]")
    private WebElement searchEntry;

    @FindBy(xpath = "//*[@id=\"tbp_submit\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"main-navigation\"]/ul/li[5]/a")
    private WebElement trialButton;

    public WebDriver webDriver;

    public MainPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
}
