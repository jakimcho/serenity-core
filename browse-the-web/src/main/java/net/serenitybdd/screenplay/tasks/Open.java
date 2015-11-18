package net.serenitybdd.screenplay.tasks;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.StepEventBus;

import static net.serenitybdd.screenplay.Tasks.instrumented;

//@Task("Opens theValue #targetPage {0}")
public class Open implements Performable {

    private PageObject targetPage;

    @Step("Opens the #targetPage")
    public <T extends Actor> void performAs(T theUser) {
        targetPage.setDriver(BrowseTheWeb.as(theUser).getDriver());
        targetPage.open();
    }

    public Open the(PageObject targetPage) {
        this.targetPage = targetPage;
        return this;
    }

    public static Open browserOn() {
        return instrumented(Open.class);
    }


}
