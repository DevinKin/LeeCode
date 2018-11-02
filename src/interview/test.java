package interview;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        int slow = 0;
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] a = new int[N];
        for(int i = 0; i < N; i++) {
            a[i] = in.nextInt();
        }
        int counter = 1;

        int pos = ((N % 2) == 0 )? N : N - 1;
        while (N >= 2) {
            for(int i = 0; i < N; i+=2) {
                a[slow] = a[i];
                slow++;
                counter++;
            }
            slow = 0;
            N /= 2;
        }
        System.out.println(a[0]);
        System.out.println(counter);
    }
}
