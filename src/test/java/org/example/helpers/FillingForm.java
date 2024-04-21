package org.example.helpers;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;

public class FillingForm {

  //паттерн DRY
  public static void fillFullForm(UserDataInput userDataInput) {
    SelenideElement name_input = $("[data-test-id=\"name\"] input");
    SelenideElement phone_input = $("[data-test-id=\"phone\"] input");
    SelenideElement confirm_agreement_checkbox = $("[data-test-id=\"agreement\"] input");
    SelenideElement continue_button = $("[role=button]");

    name_input
        .setValue(userDataInput.getName())
        .shouldHave(attribute("value", userDataInput.getName()));

    phone_input
        .setValue(userDataInput.getPhone())
        .shouldHave(attribute("value", userDataInput.getPhone()));

    confirm_agreement_checkbox
        .click(ClickOptions.usingDefaultMethod())
        .should(checked);

    continue_button
        .click();
  }

}
