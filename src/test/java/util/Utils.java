package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Utils {

    //For some debug purposes
    public static String takeScreenShot(WebDriver driver, String testName){
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "./" + "\\target\\surefire-reports\\" + testName + ".png";
        try {
            FileUtils.copyFile(screenshot, new File(path));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return testName + ".png";
    }

}
