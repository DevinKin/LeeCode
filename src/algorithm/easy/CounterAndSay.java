package algorithm.easy;

public class CounterAndSay {
    public static String solution(int n) {
        String old = "1";
        while (n > 1) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < old.length(); ) {
                int j = i;
                while (j < old.length() && old.charAt(i) == old.charAt(j)) {
                    j++;
                }
                result.append(j - i).append(old.charAt(i));
                i = j;
            }
            old = result.toString();
            n--;
        }
        return old;
    }

    public static void main(String[] args) {
        System.out.println(solution(4));

    }
}
