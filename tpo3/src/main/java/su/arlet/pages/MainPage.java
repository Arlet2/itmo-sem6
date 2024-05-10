package su.arlet.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class MainPage {
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/h1/strong")
    private WebElement title;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/div/div/div/div[5]/div/div/a")
    private WebElement learnMoreButton;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/div/div/div/div[23]/div/div/h1/strong")
    private WebElement searchTitle;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/div/div/div/div[24]/div/form/input[1]")
    private WebElement searchEntry;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/div/div/div/div[24]/div/form/input[2]")
    private WebElement searchButton;

    @FindBy(xpath = "/html/body/div/div/div[1]/div/div[1]/div/nav/ul/li[5]/a")
    private WebElement trialButton;

    public WebDriver webDriver;

    public MainPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
}
