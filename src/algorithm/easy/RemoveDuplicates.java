package algorithm.easy;

public class RemoveDuplicates {

    public static int Solution(int[] nums) {
        // len最小长度是1,从1开始记录
        int len = 1;
        // 数组长度小于2
        if (nums.length < 2) {
            // 数组长度小于1
            if (nums.length < 1)
                return 0;
            else {
                return 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            // 到达数组尾部
            if (i == nums.length - 1) {
                // 修改数组的值,让最后一个元素与尾部的元素相等
                nums[len - 1] = nums[i];
                // 跳出循环
                break;
            }
            if (nums[i] != nums[i + 1]) {
                // 修改数组的值
                nums[len - 1] = nums[i];
                len += 1;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {0,0, 0,1,1,1,2,2,3,3,4,4,5,5,5,5,5};
        System.out.println(Solution(nums1));
    }
}
