package back;

import java.util.ArrayList;
import java.util.List;

public class Lottery {
    static List<String> Runlottery(List<String> list, int num) {
        List<String> result = new ArrayList<>();
        while (num-- > 0 && list.size() > 0) {
            int index = (int)(Math.random() * list.size());
            result.add(list.get(index));
            list.remove(index);
        }
        return result;
    }
}
