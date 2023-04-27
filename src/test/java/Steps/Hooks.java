package Steps;


import Utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



public class Hooks {





    @After(order = 0)
    public void after0(){
        Driver.quit();
    }


}
