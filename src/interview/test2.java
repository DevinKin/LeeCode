package interview;

import java.util.Scanner;
import java.util.Stack;

public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int rec = 0;
        String code = in.next();
        System.out.println(N);
        System.out.println(K);
        System.out.println(code);
        Stack<Character> left = new Stack<>();
        String ct = "{()}";
        int counter = 0;
        for (int i = 0; i < N; i++) {
            char ch = code.charAt(i);
            if (!ct.contains(String.valueOf(ch))) {
                continue;
            }
            if (ch == '{' || ch == '(') {
                left.push(ch);
            }
            if (i == K) {
                rec = left.size();
            }
            if (ch == '}' || ch == ')') {
                left.pop();
                if (left.size() < rec) {
                    System.out.println(i);
                    System.exit(0);
                }
            }
        }
    }
}
