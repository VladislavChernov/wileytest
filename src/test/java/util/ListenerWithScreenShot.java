package util;

import guitestcases.BaseTestCase;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import static util.Utils.takeScreenShot;

public class ListenerWithScreenShot extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getName();
        if(!result.isSuccess()) {
           String screenShotOnFailure = takeScreenShot(BaseTestCase.driver, result.getName());
           Reporter.log("<a href='"+ screenShotOnFailure + "'> <img src='"+ screenShotOnFailure + "' height='100' width='100'/> </a>");
        }
    }
}
