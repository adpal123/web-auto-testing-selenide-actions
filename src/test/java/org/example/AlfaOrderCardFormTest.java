package org.example;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;
import org.example.helpers.FillingForm;
import org.example.helpers.UserDataInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlfaOrderCardFormTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void shouldSubmitValidForm() {
        UserDataInput userDataInput = new UserDataInput("Василий", "+79270000000");
        SelenideElement order_success_alert = $("[data-test-id='order-success']");

        FillingForm.fillFullForm(userDataInput);

        order_success_alert
            .shouldHave(text("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void shouldValidateFormWithWrongPhone() {
        UserDataInput userDataInput = new UserDataInput("Василий", "+7927000");
        SelenideElement phone_input_sub = $("[data-test-id=\"phone\"] [class='input__sub']");

        FillingForm.fillFullForm(userDataInput);

        phone_input_sub
            .shouldHave(text("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

}