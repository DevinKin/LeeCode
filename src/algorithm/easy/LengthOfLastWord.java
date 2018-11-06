package algorithm.easy;

public class LengthOfLastWord {
    public static int solution(String s) {
       int len = 0;
       int tail = s.length() - 1;
       if (s == null || s.length() < 0) {
           return 0;
       }

       // 先去除尾部的空格,出现非空格字符串,跳出循环
       for (int i = tail; i >=0 ; i--) {
            if (s.charAt(i) == ' ') {
                tail--;
            } else {
                break;
            }
        }

        for (int i = tail; i >=0; i--) {
            if (s.charAt(i) == ' ') {
                return len;
            } else {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(solution("   day"));
    }
}
