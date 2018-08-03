package listenerspackage;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class CustomListener3 implements ISuiteListener {

    @Override
    public void onStart(ISuite iSuite) {
        // When <Suite> tag starts
        System.out.println("onStart: Before suite starts");
    }

    @Override
    public void onFinish(ISuite iSuite) {
        // When <Suite> tag Completes
        System.out.println("onFinish: After suite completes");
    }
}
