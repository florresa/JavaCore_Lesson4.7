import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceTest {

    String expectedRus = "Добро пожаловать";
    String expectedEn = "Welcome";

    @Test
    void localeRussiaTest() {
        LocalizationServiceImpl service = new LocalizationServiceImpl();
        String actual = service.locale(Country.RUSSIA);
        Assertions.assertEquals(expectedRus, actual);
    }

    @Test
    void localeGermanyTest() {
        LocalizationServiceImpl service = new LocalizationServiceImpl();
        String actual = service.locale(Country.GERMANY);
        Assertions.assertEquals(expectedEn, actual);
    }

    @Test
    void localeUsaTest() {
        LocalizationServiceImpl service = new LocalizationServiceImpl();
        String actual = service.locale(Country.USA);
        Assertions.assertEquals(expectedEn, actual);
    }

    @Test
    void localeBrazilTest() {
        LocalizationServiceImpl service = new LocalizationServiceImpl();
        String actual = service.locale(Country.BRAZIL);
        Assertions.assertEquals(expectedEn, actual);
    }
}
