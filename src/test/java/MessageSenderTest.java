import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderTest {

    String expectedRus = "Добро пожаловать";
    String expectedEn = "Welcome";

    @Test
    void moscowIpAddressMessageTest () {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("172.0.32.11"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn(expectedRus);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String actual = messageSender.send(headers);
        Assertions.assertEquals(actual, expectedRus);
    }

    @Test
    void newYorkIpAddressMessageTest () {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("96.44.183.149"))
                .thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn(expectedEn);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String actual = messageSender.send(headers);
        Assertions.assertEquals(actual, expectedEn);
    }

    @Test
    void russianIpAddressMessageTest () {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("172.0.33.11"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn(expectedRus);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.33.11");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String actual = messageSender.send(headers);
        Assertions.assertEquals(actual, expectedRus);
    }

    @Test
    void foreignIpAddressMessageTest () {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("96.45.183.149"))
                .thenReturn(new Location("New York", Country.USA, null,  0));

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn(expectedEn);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.45.183.149");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String actual = messageSender.send(headers);
        Assertions.assertEquals(actual, expectedEn);
    }

    @Test
    void germanyIpAddressMessageTest () {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("55.45.183.149"))
                .thenReturn(new Location("Berlin", Country.GERMANY, null,  0));

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.GERMANY))
                .thenReturn(expectedEn);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "55.45.183.149");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String actual = messageSender.send(headers);
        Assertions.assertEquals(actual, expectedEn);
    }

    @Test
    void brazilIpAddressMessageTest () {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("66.45.183.149"))
                .thenReturn(new Location("Brazilia", Country.BRAZIL, null,  0));

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.BRAZIL))
                .thenReturn(expectedEn);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "66.45.183.149");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String actual = messageSender.send(headers);
        Assertions.assertEquals(actual, expectedEn);
    }

    @Test
    void localhostIpAddressMessageTest () {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("127.0.0.1"))
                .thenReturn(new Location(null, null, null, 0));

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(null))
                .thenReturn(expectedEn);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "127.0.0.1");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String actual = messageSender.send(headers);
        Assertions.assertEquals(actual, expectedEn);
    }

}
