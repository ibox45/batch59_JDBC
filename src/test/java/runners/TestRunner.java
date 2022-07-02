package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target/cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"
        },
        features = "src/test/resources/features",
        glue="stepDefinitions",
        tags ="@db",
        dryRun = false
)

public class TestRunner {
    /*
    Bir framework'de bir tek Runner class'i yeterli olabilir
    Runner Classında class body'sinde hiç bir şey olmaz
    Runner classımızı onemli yapan 2 adet annotaion vardir
    @RunWith(Cucumber.class) notasyonu Runner classında calısma ozellıgı katar
    Bu notasyon oldugu icin Cucumber framework'umuzde JUnit kullanmayi tercih ediyoruz.

    features : Runner dosyasının feature  dosyalarını nereden bulacagını tarif eder
    glue: step definitions dosyalarını nerede bulacagımızı gosterir
    tags: o an hangi tag'i çalıstırmak istiyorsak onu belli eder

    dryRun : iki secenek var
    dryRun=true; yazdıgımızda Testimizi calıstırmadan sadece eksik adımları bize verir
    dryRun=false; yazdıgımızda testlerimizi çalistirir.


     */
}
