package algorithm.easy;

public class RemoveElement {
    public static int solution(int[] nums, int val) {
        int i = 0;
        // i 是慢指针,j是快指针
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                // 如果不是val,将当前值放在数组首部,慢指针加1
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {3,2,2,3};
        int[] nums2 = new int[] {0,1,2,2,3,0,4,2};
        System.out.println(solution(nums1, 3));
        System.out.println(solution(nums2, 2));
    }
}
