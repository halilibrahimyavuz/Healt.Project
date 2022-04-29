package runners.basicRunners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin={"html:target/cucumber-html-reports/API_cucumber.html", // buradaki / \\ idi, degistirdim, emin degilim
                "json:target/json-reports/API_cucumber.json",
                "junit:target/xml-report/API_cucumber.xml"}, // bu satir ile html,xml,json report olusturabiliyoruz
        features = "src/test/resources/features/apiFeatures", // YENI FERATURE OLUSTURURSAN BURAYI GUNCELLE
        glue = "stepdefinitions/apiStepdefinitions",
        tags = "",
        dryRun = false // step definition olusturmak icin calistirdiginda burayı true yapmayi unutma

)

public class API_Runner{
    // !!!!! EGER API VE DB ICIN FARKLI FEATURE FILE'LAR OLUSTURURSAN 145. SATIRDAKI FEATURES KISMINDAKİ PATH'I
    // GUNCELLEMEN GEREK !!!!!
}

