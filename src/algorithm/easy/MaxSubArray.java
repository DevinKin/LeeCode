package algorithm.easy;

public class MaxSubArray {
    public static int solution(int[] nums) {
        // 记录子序列的和
        int sum = nums[0];
        // 记录子序列中最大的和
        int maxSum = sum;
        for (int i = 1; i < nums.length; i++) {
            // 如果子序列和小于或者等于零,则将其设置为下一个数
            if (sum <= 0) {
                sum = nums[i];
            } else {
                // 子序列和大于等于零,和下一个数相加
                sum += nums[i];
            }

            // 如果自序列的和大于记录的最大和,则将其当前的最大sum设置为sum
            if (maxSum < sum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }


    public static void main(String[] args) {
        int[] test1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution(test1));
    }
}
