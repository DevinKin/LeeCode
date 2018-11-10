package algorithm.easy;

public class ClimbStairs {
    public static int solution(int n) {
        int nums = 0;
        // 全1的情况
        int sum = 1;
        int nnums = 0;


        int N = n;
        while (N > 2) {
            N -= 2;
            nums++;
            int subsum = 1;
            // nums + N 为排列组合总数量
            for (int i = 1; i <= nums; i++) {
                subsum *= (nums + N - i + 1);
                subsum /= i;
            }
            sum += subsum;
        }

        // 全2的情况
        if (N % 2 == 0) {
            sum += 1;
        }

        return sum;
    }

    public static int solution2(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int[] ans = new int[n];
            ans[0] = 1;
            ans[1] = 2;
            for (int i = 2; i < n; i++) {
                ans[i] = ans[i - 1] + ans[i - 2];
            }
            return ans[n - 1];
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(42));
//        System.out.println(solution2(42));
//        System.out.println(solution2(4));
//        System.out.println(solution2(3));
//        System.out.println(solution2(2));
//        System.out.println(solution2(1));
    }
}


