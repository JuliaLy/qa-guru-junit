import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StepikTest {
    @BeforeEach
    void setup() {
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        open("https://stepik.org");
    }

    @ValueSource(strings = {"Java", "Python"})
    @ParameterizedTest(name = "Ищем курс по {0}")
    void searchCourse (String name){
        $("[type=search]").setValue(name).pressEnter();
        $("[class=course-card__title]").shouldHave(text(name));
    }


    @EnumSource(Languages.class)
    @ParameterizedTest
    void languageSwitchTest(Languages language) {
        $("[id=ember24]").click();
        $("[class=drop-down__body]").$(byText(language.getLanguage())).click();
        $("[id=ember27]").shouldHave(text(language.getExpectedText()));

    }
}
