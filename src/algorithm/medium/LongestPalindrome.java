package algorithm.medium;

import java.util.Arrays;

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

    /**
     * ,* Transform S to T
     * ,* For example, S = "abba", T="^#a#b#b#a#$".
     * ,* ^ and $ signs are sentinels appended to each end to avoid bounds check
     * ,
     */
    public static String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        StringBuilder ret = new StringBuilder("^");
        for (int i = 0; i < n; i++) {
            ret.append("#").append(s.charAt(i));
        }
        ret.append("#$");
        return ret.toString();
    }

    public static String longestPalindrome(String s) {
        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n];
        // Center point
        int C = 0;
        // Right border
        int R = 0;
        // first character is $
        for (int i = 1; i < n - 1; i++) {
            // equals to i' = C - (i - C)
            int iMirror = 2 * C - i;
            P[i] = (R > i) ? Math.min(R - i, P[iMirror]) : 0;

            // Attempt to expand palindrome centered at i
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }


            // if palindrome centered at 1 expand past R,
            // adjust center based on expanded palindrome.
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }
        System.out.println(Arrays.toString(P));

        // Find the maximum element in P.
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        return s.substring((centerIndex - 1 - maxLen) / 2, maxLen);
    }

    public static void main(String[] args) {
//        System.out.println(solution("babad"));
//        System.out.println(solution("cccccc"));
        System.out.println(longestPalindrome("cccccc"));
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
