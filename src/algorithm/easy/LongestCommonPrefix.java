package algorithm.easy;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        String first = strs[0];
        // rec记录其余字符串与第一个字符串相同的长度
        int rec = first.length();


        for (String str : strs) {
            for (int i = 0; i < rec; i++) {
                // i的长度等于其余字符串长度时,遍历下一个字符串
                if (i >= str.length())  {
                    rec = i;
                    break;
                }
                if (str.charAt(i) != first.charAt(i)) {
                    // 遍历数组下字符串的范围变小
                    rec = i;
                    // 到下一个字符串
                    break;
                }
            }
        }
        // 直接返回记录索引结果
        return first.substring(0,rec);
    }

    public static void main(String[] args) {
        String[] strs = new String[] {"flower","flow","flight"};
        String[] strs2 = new String[] {"dog","racecar","car"};
        String[] strs3 = new String[] {"aa", "a"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix(strs2));
        System.out.println(longestCommonPrefix(strs3));
    }
}
