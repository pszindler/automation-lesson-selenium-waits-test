import org.junit.jupiter.api.Test;

public class TestCase extends TestBase {

    @Test
    void testBrowser() {
        driver.get("https://www.google.pl/");
        System.out.println("TEST");
    }
}
