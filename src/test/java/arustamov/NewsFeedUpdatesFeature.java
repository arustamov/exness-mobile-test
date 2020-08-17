package arustamov;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    plugin = {"pretty", "json:target/cucumber/report/news_feed_updates.json", "html:target/cucumber"},
    glue = "arustamov.step.definition",
    features = "classpath:features/news_feed_updates.feature"
)
public class NewsFeedUpdatesFeature {
}
