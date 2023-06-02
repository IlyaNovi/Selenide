package ru.netology.selenide;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {
    String generateDate (int dayToAdd, String pattern) {
        return LocalDate.now().plusDays(dayToAdd).format(DateTimeFormatter.ofPattern(pattern));
    }
    @Test
    public void shouldReturnSuccessPage(){
        open("http://localhost:9999");
        $("[data-test-id='city']input").setValue("Москва");
        $("[data-test-id='date']").setValue(generateDate(3, "dd.MM.yy"));
        $("[data-test-id='name']input").setValue("Попов Иван");
        $("[data-test-id='phone']input").setValue("+79505005050");
        $("['checkbox__box']").click();
        $("['button__content']").click();
        $(byText("Успешно")).shouldBe(visible, Duration.ofSeconds(15));

    }
}
