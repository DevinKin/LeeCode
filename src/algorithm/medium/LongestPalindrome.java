package algorithm.medium;

public class LongestPalindrome {
    public static String solution(String s) {
        if (s.length() < 1) {
            return "";
        }
        // 用作遍历字符串s
        int i;
        // 用来记录折半位置
        int len;
        int maxlen = 1;
        int ms = 0;

        // 奇数的回文子串
        for (i = 0; i < s.length(); i++) {
            int j = i + 1;
            int k = i - 1;
            while (j < s.length() && k >= 0 && s.charAt(j) == s.charAt(k)) {
                len = j - k + 1;
                if (len > maxlen) {
                   // 有更长的回文串,记录起始位置
                    maxlen = len;
                    // 回文从k开始
                    ms = k;
                }
                j++;
                k--;
            }
        }

        // 偶数的回文子串
        for (i = 0; i < s.length(); i++) {
            int k = i;
            int j = i + 1;
            while (j < s.length() && k >= 0 && s.charAt(k) == s.charAt(j)) {
                len = j - k + 1;
                if (len > maxlen) {
                    maxlen = len;
                    // 回文从k开始
                    ms = k;
                }
                k--;
                j++;
            }
        }

        return s.substring(ms, ms + maxlen);
    }

    public static void main(String[] args) {
//        System.out.println(solution("babad"));
        System.out.println(solution("cccccc"));
//        System.out.println(solution("cbb"));
//        System.out.println(solution(""));
//        System.out.println(solution("bb"));
//        System.out.println(solution("a"));
//        System.out.println(solution("abcda"));
//        System.out.println(solution("bananas"));
//        System.out.println(solution("abacab"));
//        System.out.println(solution("eabcb"));
    }
}
