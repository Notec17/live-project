package back;

import java.util.ArrayList;
import java.util.List;

public class Lottery {

    /**
     * 获取中号的List 并且传进来的参数会处理成没有摇中的List
     * @param list 参与摇号的列表
     * @param num 摇号的数量
     * @return
     */
    static List<String> runlottery(List<String> list, int num) {
        List<String> result = new ArrayList<>();
        while (num-- > 0 && list.size() > 0) {
            int index = (int)(Math.random() * list.size());
            result.add(list.get(index));
            list.remove(index);
        }
        return result;
    }
}
