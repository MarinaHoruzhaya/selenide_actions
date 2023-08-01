import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EnterpriseTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy="eager";
    }

    @Test
    void openEnterprise() {
        open("https://github.com/");
        $(".header-menu-wrapper").$(Selectors.byText("Solutions")).hover();
        $(".border-bottom").$(Selectors.byText("Enterprise")).click();
        $(".application-main ").shouldHave(Condition.text("Build like the best"));
    }
}
