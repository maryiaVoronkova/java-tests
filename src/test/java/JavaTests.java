import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.TakeScreenshot;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class JavaTests {

    @BeforeAll
    public static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    @Description("Test with GitHub description")
    public void testExample() {
        step("Open main page", () -> {
            open("https://github.com/");
            getWebDriver().manage().window().maximize();
            webdriver().driver().browser();
            attachment("Source", webdriver().driver().source());
        });

        $(".search-input").click();
        $(".search-input").sendKeys("allure");
        $(".search-input").submit();

        $$x("//*[@data-testid='results-list']//h3").first().click();
    }

    @Test
    @Description("Test with GitHub description")
    public void testExample2() {
        open("https://github.com/");
        $(".search-input").click();
        $(".search-input").sendKeys("allure");
        $(".search-input").submit();

        $$x("//*[@data-testid='results-list']//h3").first().click();
    }

    /*@Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakeScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }*/
}
