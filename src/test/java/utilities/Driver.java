package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    /*
    POM'de Driver icin TestBase classına extends etmek yerine
    Driver classından static methodlar kullanarak
    driver olusturup ,ilgii ayarların yapılması
    ve en sonda driver'in kapatılması tercih edilmistir.

    POM'de Driver class'ındaki getDriver()'nin obje olusturularak kullanımasını
    engellemek icin
    singleton patern kullanımı benımsenmıstır

    sigleton pattern: tekli kullanım, bir classın farklı classlardan obje olusturularak kullanımını
    engellemek ıcın kullanılır

    bunu saglaamak icin yapmamız gereken sey
    obje olusturmak ıcın kullanılan constructor'ı provate yaptıgınızda
    basaka claslarda Driver classından obje olsuturulması mumkun OLAMAZ
     */
    private Driver(){

    }

    static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver==null) {
            switch(ConfigReader.getProperty("browser")){
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver =new FirefoxDriver();
                    break;
                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver =new EdgeDriver();
                    break;
                case "headless-chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;
    }

    public static void closeDriver(){
       if(driver!=null){
           driver.close();
           driver=null;
       }

    }

}
