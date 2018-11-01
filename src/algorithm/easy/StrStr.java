package algorithm.easy;

public class StrStr {
    public static int solution(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        int nLen = needle.length();
        for (int i = 0; i < haystack.length(); i++) {
            // 如果needle字符串的第一个字符与haystack的某个位置的字符相同时候
            if (haystack.charAt(i) == needle.charAt(0)) {
                // 取出haystack当前位置起始的,长度与needle相同的子字符串
                // 如果长度超出范围,不存在
                if (i + nLen > haystack.length()) {
                    return -1;
                }
                String compare = haystack.substring(i, i + nLen);
                if (needle.equals(compare)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "aaaaa";
        String b = "bba";
        String c = "hello";
        String d = "ll";
        System.out.println(solution(a,b));
        System.out.println(solution(c,d));
    }
}
