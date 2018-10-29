package algorithm.easy;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanToInt {
    private static Map<Character, Integer> romans = new LinkedHashMap<>();
    private static Map<String, Integer> special = new LinkedHashMap<>();

    static {
        romans.put('M', 1000);
        romans.put('D', 500);
        romans.put('C', 100);
        romans.put('L', 50);
        romans.put('X', 10);
        romans.put('V', 5);
        romans.put('I', 1);

        special.put("CM", 900);
        special.put("CD", 400);
        special.put("XC", 90);
        special.put("XL", 40);
        special.put("IX", 9);
        special.put("IV", 4);
    }

    public static int RomanToInt(String s) {
        int res = 0;
        for (String sp : special.keySet()) {
            // 包含特殊的情况,先去除
            if (s.indexOf(sp) != -1) {
                s = s.substring(0, s.indexOf(sp)) + s.substring(s.indexOf(sp) + 2);
                res += special.get(sp);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            Integer base = romans.get(s.charAt(i));
            res+= base;
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        RomanToInt("III");
        RomanToInt("IV");
        RomanToInt("IX");
        RomanToInt("LVIII");
        RomanToInt("MCMXCIV");
        RomanToInt("MMMCMXCIII");
    }
}
