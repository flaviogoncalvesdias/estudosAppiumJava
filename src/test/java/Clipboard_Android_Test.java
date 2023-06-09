import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Clipboard_Android_Test {

    private AndroidDriver<WebElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("app", "/Users/mac/Documents/Projetos_Estudos/PrimeiroAppium/apps/selendroid.apk");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @Test
    public void clipboard_test() {
        String text = "Hello TAU";
        driver.setClipboardText(text);
        MobileElement nameTxt = (MobileElement) driver.findElementByAccessibilityId("my_text_fieldCD");
        nameTxt.sendKeys(driver.getClipboardText());
        Assert.assertEquals(text,nameTxt.getText());


    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

}