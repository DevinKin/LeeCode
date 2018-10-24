package algorithm.easy;

import java.util.ArrayList;
import java.util.List;

public class ReverseInteger {
    public static int reverse(int x) {
        Long r = new Long(0);
        List<Integer> list = new ArrayList<Integer>();

        while(x != 0) {
            // 取最后一位数字
            list.add(x % 10);
            x /= 10;
        }

        for (int li : list) {
            r = r * 10 + li;
            if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return r.intValue();
    }

    public static void main(String[] args) {
        System.out.println(reverse(-483647));
    }
}
