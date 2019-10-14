import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.CacheUtils;
import utils.api.CacheMap;
import utils.enums.StrategyType;

public class CacheTest {
    @Test
    public void testLfu() {
        final CacheMap<String, Double> map = CacheUtils.getMapByMaxLengthAndStrategy(3, StrategyType.LFU);
        System.out.println("Strategy = " + map.getType());

        map.add("яблоко", 1.1);
        map.add("√руша", 3.1);
        map.add("јбрикос", 0.1);

        map.get("яблоко");
        map.get("яблоко");
        map.get("яблоко");
        map.get("яблоко");
        map.get("јбрикос");
        map.get("јбрикос");
        map.get("√руша");

        map.add(" вант", 0.000001);

        //т.к меньше всего было обращений к груша, она должна заменитьс€ элементом  вант
        Assertions.assertNull(map.get("√руша"));
    }

    @Test
    public void testLru() {
        final CacheMap<String, Double> map = CacheUtils.getMapByMaxLengthAndStrategy(3, StrategyType.LRU);
        System.out.println("Strategy = " + map.getType());

        map.add("яблоко", 1.1);
        map.add("√руша", 3.1);
        map.add("јбрикос", 0.1);

        map.get("яблоко");
        map.get("яблоко");
        map.get("яблоко");
        map.get("яблоко");
        map.get("јбрикос");
        map.get("јбрикос");
        map.get("√руша");

        map.add(" вант", 0.000001);

        //т.к посл. обращение была к груша, она должна остатьс€
        Assertions.assertNotNull(map.get("√руша"));
    }
}
