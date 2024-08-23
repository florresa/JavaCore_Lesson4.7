import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceTest {
    public static final Location localhostExpected = new Location(null, null, null, 0);
    public static final Location moscowExpected = new Location("Moscow",Country.RUSSIA, "Lenina", 15);
    public static final Location newYorkExpected = new Location("New York", Country.USA, " 10th Avenue", 32);
    public static final Location ip172Expected = new Location("Moscow", Country.RUSSIA, null, 0);
    public static final Location ip96Expected = new Location("New York", Country.USA, null,  0);


    @Test
    void localIpAddressTest() {
        GeoServiceImpl service = new GeoServiceImpl();
        Location location = service.byIp(GeoServiceImpl.LOCALHOST);
        String expected = localhostExpected.toString();
        String actual = location.toString();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void moscowIpAddressTest() {
        GeoServiceImpl service = new GeoServiceImpl();
        Location location = service.byIp(GeoServiceImpl.MOSCOW_IP);
        String expected = moscowExpected.toString();
        String actual = location.toString();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void newYorkIpAddressTest() {
        GeoServiceImpl service = new GeoServiceImpl();
        Location location = service.byIp(GeoServiceImpl.NEW_YORK_IP);
        String expected = newYorkExpected.toString();
        String actual = location.toString();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void ip1Address172Test() {
        GeoServiceImpl service = new GeoServiceImpl();
        Location location = service.byIp("172.0.32.12");
        String expected = ip172Expected.toString();
        String actual = location.toString();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void ip1Address96Test() {
        GeoServiceImpl service = new GeoServiceImpl();
        Location location = service.byIp("96.44.183.148");
        String expected = ip96Expected.toString();
        String actual = location.toString();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void randomIpAddressTest() {
        GeoServiceImpl service = new GeoServiceImpl();
        Location location = service.byIp("55.44.183.148");
        Assertions.assertNull(location);
    }
}
