package java_Basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//9-51
public class ReadingProperties {

    public static void main(String[] args) throws IOException {

        String path = "C:\\automation-workspace\\Selenium_Info\\src\\java_Basic\\test.properties";
        Properties prop = new Properties();
        //To read file and locate it
        FileInputStream fs = new FileInputStream(path);
        //To read the file inside
        prop.load(fs);
        System.out.println(prop.getProperty("name"));
        System.out.println(prop.getProperty("course"));
    }

}
