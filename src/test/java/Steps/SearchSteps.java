package Steps;

import Locators.MyLocators;
import ReuseableClass.BaseClass;
import ReuseableClass._Conditions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.List;

public class SearchSteps extends BaseClass implements MyLocators {
    @Given("user on homepage")
    public void userOnHomepage() {

        open("http://opencart.abstracta.us/index.php?route=common/home");
    }

    @Given("user search for {string}")
    public void userSearchFor(String text) {
        $(By.xpath(searhBox)).waitFor(_Conditions.visibilty,null).sendKeys(text);
        $(By.xpath(searchButton)).click();
        List<WebElement> elementList = $(By.xpath(searchPruductList)).getElementList();
        WebElement lastelement = elementList.get(elementList.size() - 1);
        String lastproductName = lastelement.findElement(By.xpath(".//h4")).getText();
        System.setProperty("lastProductName",lastproductName);
    }

    @Given("nagita to {string}")
    public void nagitaTo(String url) {
        driver.switchTo().newWindow(WindowType.TAB).navigate().to(url);
        wait.until(ExpectedConditions.urlContains("login"));
    }

    @And("should be succest login")
    public void shouldBeSuccestLogin() throws IOException {
        $(By.xpath(usernameInput)).sendKeys("Admin");
        $(By.xpath(passwordInput)).sendKeys("admin123");
        $(By.xpath(loginButton)).click();
        wait.until(ExpectedConditions.urlContains("dashboard"));
        $(By.xpath(adminButton)).click();
        wait.until(ExpectedConditions.urlContains("viewSystemUsers"));
        $(By.xpath(adminPageUsernameInput)).sendKeys(System.getProperty("lastProductName"));
        getScreenshot("UsernameInput");
        /*
Username : Admin
Password : admin123
 */
    }
}
