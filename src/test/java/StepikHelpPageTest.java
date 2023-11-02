import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepikHelpPageTest {

    @CsvSource(value = {"Учащимся, Найдено 18 совпадений",
            "Авторам, Найдено 5 совпадений",
            "Организациям, Найдено 2 совпадения"})
    @ParameterizedTest(name = "Ищем статьи для {0}")
    @Tag("Smoke")
    void helpSearchTest(String cathegory, String expectedText) {
        open("https://help.stepik.org/");
        $("[name=query]").setValue(cathegory).pressEnter();
        $("[class=badge]").shouldHave(text(expectedText));
    }
}
