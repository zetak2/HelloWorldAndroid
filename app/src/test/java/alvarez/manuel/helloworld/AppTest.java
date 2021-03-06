package alvarez.manuel.helloworld;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class AppTest {

    @Test
    public void test()  throws MalformedURLException
    {
        System.out.println("Ejecutando clase: "+this.getClass().getSimpleName().toString());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("deviceName", "test");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("appPackage", "alvarez.manuel.helloworld");
        capabilities.setCapability("appActivity", ".MainActivity");
        capabilities.setCapability("newCommandTimeout","10");

        AndroidDriver driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        MobileElement el1 = (MobileElement) driver.findElementById("alvarez.manuel.helloworld:id/fab");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("alvarez.manuel.helloworld:id/txtName");
        el2.setValue("Manuel");
        driver.navigate().back();
        MobileElement el4 = (MobileElement) driver.findElementById("alvarez.manuel.helloworld:id/fab");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("alvarez.manuel.helloworld:id/fab");
        el5.click();
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementByAccessibilityId("More options");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el7.click();

        Assert.assertEquals(driver.findElementById("alvarez.manuel.helloworld:id/txtName").getText(), "Manuel");
        driver.closeApp();
    }
}
