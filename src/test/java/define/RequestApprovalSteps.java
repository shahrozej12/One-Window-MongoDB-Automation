package define;

import locators.XPathLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;

import java.time.Duration;

public class RequestApprovalSteps {
     WebDriver driver;
    private WebDriverWait wait;

    public RequestApprovalSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));  // 30-second timeout
    }

    public void enterComments(String comments) {
        try {
            WebElement commentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPathLocators.Enter_Comments)));
            commentField.clear();
            commentField.sendKeys(comments);
            System.out.println("Entered comment: " + comments);
        } catch (Exception e) {
            System.out.println("Error entering comments: " + e.getMessage());
        }
    }

    public void clickRequestButton(String buttonText) {
        try {
            // Use the dynamic XPath to find the button with the provided text (e.g., "Request Approve")
            String requestButtonXPath = String.format(XPathLocators.Request, buttonText);
            WebElement requestButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(requestButtonXPath)));
            requestButton.click();
            System.out.println("Clicked the '" + buttonText + "' button.");
        } catch (Exception e) {
            System.out.println("Error clicking the request button: " + e.getMessage());
        }
    }

    public void handleYesNoDialog(String decision) {
        try {
            // Use the dynamic XPath to find the Yes/No button based on the provided decision
            String yesNoButtonXPath = String.format(XPathLocators.Checker_YES_NO, decision);
            WebElement yesNoButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(yesNoButtonXPath)));
            yesNoButton.click();
            System.out.println("Clicked '" + decision + "' in the dialog.");
        } catch (Exception e) {
            System.out.println("Error handling the Yes/No dialog: " + e.getMessage());
        }
    }
}
