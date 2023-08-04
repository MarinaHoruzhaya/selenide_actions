import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy="eager";
    }

    SelenideElement a = $("#column-a");
    SelenideElement b = $("#column-b");

    @Test
    void dragAndDropsWithActions(){ //не работает
        open("https://the-internet.herokuapp.com/drag_and_drop");

        actions().clickAndHold(a).moveToElement($(b)).release().build().perform();
        a.shouldHave(Condition.text("B"));
        b.shouldHave(Condition.text("A"));

    }

    @Test
    void dragAndDrops(){ // работает
        open("https://the-internet.herokuapp.com/drag_and_drop");

        a.dragAndDrop(to(b));
        a.shouldHave(Condition.text("B"));
        b.shouldHave(Condition.text("A"));
    }

}
