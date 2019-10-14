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

        Assertions.assertTrue(map.add("������", 1.1));
        Assertions.assertTrue(map.add("�����", 3.1));
        Assertions.assertTrue(map.add("�������", 0.1));

        Assertions.assertNotNull(map.get("������"));
        Assertions.assertNotNull(map.get("������"));
        Assertions.assertNotNull(map.get("������"));
        Assertions.assertNotNull(map.get("������"));
        Assertions.assertNotNull(map.get("�������"));
        Assertions.assertNotNull(map.get("�������"));
        Assertions.assertNotNull(map.get("�����"));

        Assertions.assertTrue(map.add("�����", 0.000001));

        //�.� ������ ����� ���� ��������� � �����, ��� ������ ���������� ��������� �����
        Assertions.assertNull(map.get("�����"));
    }

    @Test
    public void testLru() {
        final CacheMap<String, Double> map = CacheUtils.getMapByMaxLengthAndStrategy(3, StrategyType.LRU);
        Assertions.assertEquals(map.getType(), StrategyType.LRU);

        Assertions.assertTrue(map.add("������", 1.1));
        Assertions.assertTrue(map.add("�����", 3.1));
        Assertions.assertTrue(map.add("�������", 0.1));

        Assertions.assertNotNull(map.get("������"));
        Assertions.assertNotNull(map.get("������"));
        Assertions.assertNotNull(map.get("������"));
        Assertions.assertNotNull(map.get("������"));
        Assertions.assertNotNull(map.get("�������"));
        Assertions.assertNotNull(map.get("�������"));
        Assertions.assertNotNull(map.get("�����"));

        Assertions.assertTrue(map.add("�����", 0.000001));

        //�.� ����. ��������� ���� � �����, ��� ������ ��������
        Assertions.assertNotNull(map.get("�����"));
    }
}
