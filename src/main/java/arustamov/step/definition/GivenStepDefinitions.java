package arustamov.step.definition;

import arustamov.context.SpringContextAware;
import arustamov.entities.Users;
import arustamov.entity.Entity;
import arustamov.entity.User;
import arustamov.enums.SessionVariable;
import arustamov.step.GivenSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Shared;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("unchecked")
public class GivenStepDefinitions implements SpringContextAware {

    @Autowired
    private Users users;

    @Shared
    private GivenSteps givenSteps;

    @When("^there is a random \"([^\"]*)\" among the \"([^\"]*)\"$")
    public void i_select_a_random_entity_from_the_entities(String variableName, String variablesName) {
        List<Entity> entities = Serenity.sessionVariableCalled(SessionVariable.of(variablesName));

        Entity entity = (Entity) users.random(entities);

        givenSteps.setSessionVariable(SessionVariable.of(variableName), entity);
    }

    @Given("^there are users$")
    public void there_are_users() {
        final List<User> userList = users.getAll();

        givenSteps.setSessionVariable(SessionVariable.USERS, userList);
    }
}
