import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.CacheUtils;
import utils.api.CacheMap;
import utils.enums.StrategyType;

public class CacheTest {
    @Test
    public void testLfu() {
        final CacheMap<String, Double> map = CacheUtils.getMapByMaxLengthAndStrategy(3, StrategyType.LFU);
        Assertions.assertEquals(map.getType(), StrategyType.LFU);

        Assertions.assertTrue(map.add("яблоко", 1.1));
        Assertions.assertTrue(map.add("√руша", 3.1));
        Assertions.assertTrue(map.add("јбрикос", 0.1));

        Assertions.assertNotNull(map.get("яблоко"));
        Assertions.assertNotNull(map.get("яблоко"));
        Assertions.assertNotNull(map.get("яблоко"));
        Assertions.assertNotNull(map.get("яблоко"));
        Assertions.assertNotNull(map.get("јбрикос"));
        Assertions.assertNotNull(map.get("јбрикос"));
        Assertions.assertNotNull(map.get("√руша"));

        Assertions.assertTrue(map.add(" вант", 0.000001));

        //т.к меньше всего было обращений к груша, она должна заменитьс€ элементом  вант
        Assertions.assertNull(map.get("√руша"));
    }

    @Test
    public void testLru() {
        final CacheMap<String, Double> map = CacheUtils.getMapByMaxLengthAndStrategy(3, StrategyType.LRU);
        Assertions.assertEquals(map.getType(), StrategyType.LRU);

        Assertions.assertTrue(map.add("яблоко", 1.1));
        Assertions.assertTrue(map.add("√руша", 3.1));
        Assertions.assertTrue(map.add("јбрикос", 0.1));

        Assertions.assertNotNull(map.get("яблоко"));
        Assertions.assertNotNull(map.get("яблоко"));
        Assertions.assertNotNull(map.get("яблоко"));
        Assertions.assertNotNull(map.get("яблоко"));
        Assertions.assertNotNull(map.get("јбрикос"));
        Assertions.assertNotNull(map.get("јбрикос"));
        Assertions.assertNotNull(map.get("√руша"));

        Assertions.assertTrue(map.add(" вант", 0.000001));

        //т.к посл. обращение была к груша, она должна остатьс€
        Assertions.assertNotNull(map.get("√руша"));
    }
}
