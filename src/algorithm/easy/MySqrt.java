package algorithm.easy;

public class MySqrt {
    public static int solution(int a) {
        double sum = a;
        /**
         * 牛顿迭代法: xk+1 = 1/2(xk + a/xk)
         */
        while (Math.abs(sum * sum - a) >= 1.0) {
            sum = (a / sum + sum) / 2.0;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(8));
        System.out.println(solution(1));
        System.out.println(solution(0));
        System.out.println(solution(6));
        System.out.println(solution(2));
        System.out.println(solution(3));
    }
}

