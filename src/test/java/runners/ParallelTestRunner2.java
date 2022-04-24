package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
       // plugin={"html:target//cucumber-reports2.html"}, // bu satir ile html report olusturabiliyoruz
        plugin={"html:target\\Pcucumber-reports2.html",
                "json:target/json-reports/Pcucumber2.json",
                "junit:target/xml-report/Pcucumber2.xml"}, // json ve xml formatta daha guzel raporlar olusturan pluggin
        features = "src/test/resources/features",
        glue = "uiStepdefinitions",
        tags = "@parallel2",
        dryRun = false
)


public class ParallelTestRunner2 {
}

// runner'larda bulunan tag'lar ayni olursa ayni dosyalari calistirir
// isimize yaramaz
// o yuzden parallel test icin taglar farkli olmali