package algorithm.easy;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        // 如果是负数,不是回文数,直接返回false.
        if (x < 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        // 取出每一位数字
        while (x != 0) {
            list.add(x % 10);
            x /= 10;
        }
        // 对比,检验是否为回文数
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - i - 1)) {
                return false;
            }
        }
        // 是回文数
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121212));
    }
}
