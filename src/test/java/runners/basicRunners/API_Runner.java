package runners.basicRunners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin={"html:target/cucumber-html-reports/cucumber.html", // buradaki / \\ idi, degistirdim, emin degilim
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"}, // bu satir ile html,xml,json report olusturabiliyoruz
        features = "src/test/resources/features/apiFeatures", // YENI FERATURE OLUSTURURSAN BURAYI GUNCELLE
        glue = "apiStepdefinitions",
        tags = "@DEMO",
        dryRun = false // step definition olusturmak icin calistirdiginda burayı true yapmayi unutma
)

public class API_Runner
{
    // !!!!! EGER API VE DB ICIN FARKLI FEATURE FILE'LAR OLUSTURURSAN 145. SATIRDAKI FEATURES KISMINDAKİ PATH'I
    // GUNCELLEMEN GEREK !!!!!
}

