package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utilities.LoggerApp;
import utilities.ReadConfig;


import java.util.concurrent.TimeUnit;

public class SetUp {


//    WebDriver driver = new ChromeDriver();
    WebDriver driver = new FirefoxDriver();

    ReadConfig readconfig = new ReadConfig();
    private static final Logger logger = LogManager.getLogger(LoggerApp.class);

    @Parameters("browser")
    @BeforeTest
    public void launchapp(String browser) {

        if (browser.equalsIgnoreCase("firefox")) {
            logger.info("Executing on FireFox");
            System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get(readconfig.getApplicationURL());
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("chrome")) {
            logger.info(" Executing on CHROME");
            logger.info("Executing on IE");
            System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(readconfig.getApplicationURL());
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("ie")) {
            logger.info("Executing on IE");
            System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            driver.get(readconfig.getApplicationURL());
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } else {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }
    }
}


