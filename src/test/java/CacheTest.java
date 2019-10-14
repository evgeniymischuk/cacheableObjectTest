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

        map.add("������", 1.1);
        map.add("�����", 3.1);
        map.add("�������", 0.1);

        map.get("������");
        map.get("������");
        map.get("������");
        map.get("������");
        map.get("�������");
        map.get("�������");
        map.get("�����");

        map.add("�����", 0.000001);

        //�.� ������ ����� ���� ��������� � �����, ��� ������ ���������� ��������� �����
        Assertions.assertNull(map.get("�����"));
    }

    @Test
    public void testLru() {
        final CacheMap<String, Double> map = CacheUtils.getMapByMaxLengthAndStrategy(3, StrategyType.LRU);
        System.out.println("Strategy = " + map.getType());

        map.add("������", 1.1);
        map.add("�����", 3.1);
        map.add("�������", 0.1);

        map.get("������");
        map.get("������");
        map.get("������");
        map.get("������");
        map.get("�������");
        map.get("�������");
        map.get("�����");

        map.add("�����", 0.000001);

        //�.� ����. ��������� ���� � �����, ��� ������ ��������
        Assertions.assertNotNull(map.get("�����"));
    }
}
