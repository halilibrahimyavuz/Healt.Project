package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        // plugin={"html:target//cucumber-reports1.html"}, // bu satir ile html report olusturabiliyoruz,
        plugin={"html:target\\Pcucumber-reports1.html",
                "json:target/json-reports/Pcucumber1.json",
                "junit:target/xml-report/Pcucumber1.xml"}, // json ve xml formatta daha guzel raporlar olusturan pluggin
        features = "src/test/resources/features",
        glue = "uiStepdefinitions",
        tags = "@parallelTest1",
        dryRun = false
)




public class ParallelTestRunner1 {
}
