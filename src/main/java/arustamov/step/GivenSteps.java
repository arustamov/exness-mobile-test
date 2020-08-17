package arustamov.step;

import arustamov.context.SpringContextAware;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class GivenSteps implements SpringContextAware {

    @Step
    public void setSessionVariable(Object variableName, Object variableValue) {
        Serenity.setSessionVariable(variableName).to(variableValue);
    }
}
