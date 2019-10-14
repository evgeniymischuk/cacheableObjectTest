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

        Assertions.assertTrue(map.add("Яблоко", 1.1));
        Assertions.assertTrue(map.add("Груша", 3.1));
        Assertions.assertTrue(map.add("Абрикос", 0.1));

        Assertions.assertNotNull(map.get("Яблоко"));
        Assertions.assertNotNull(map.get("Яблоко"));
        Assertions.assertNotNull(map.get("Яблоко"));
        Assertions.assertNotNull(map.get("Яблоко"));
        Assertions.assertNotNull(map.get("Абрикос"));
        Assertions.assertNotNull(map.get("Абрикос"));
        Assertions.assertNotNull(map.get("Груша"));

        Assertions.assertTrue(map.add("Квант", 0.000001));

        //т.к меньше всего было обращений к груша, она должна замениться элементом Квант
        Assertions.assertNull(map.get("Груша"));
    }

    @Test
    public void testLru() {
        final CacheMap<String, Double> map = CacheUtils.getMapByMaxLengthAndStrategy(3, StrategyType.LRU);
        Assertions.assertEquals(map.getType(), StrategyType.LRU);

        Assertions.assertTrue(map.add("Яблоко", 1.1));
        Assertions.assertTrue(map.add("Груша", 3.1));
        Assertions.assertTrue(map.add("Абрикос", 0.1));

        Assertions.assertNotNull(map.get("Яблоко"));
        Assertions.assertNotNull(map.get("Яблоко"));
        Assertions.assertNotNull(map.get("Яблоко"));
        Assertions.assertNotNull(map.get("Яблоко"));
        Assertions.assertNotNull(map.get("Абрикос"));
        Assertions.assertNotNull(map.get("Абрикос"));
        Assertions.assertNotNull(map.get("Груша"));

        Assertions.assertTrue(map.add("Квант", 0.000001));

        //т.к посл. обращение была к груша, она должна остаться
        Assertions.assertNotNull(map.get("Груша"));
    }
}
