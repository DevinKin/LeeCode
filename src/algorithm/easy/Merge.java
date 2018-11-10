package algorithm.easy;

import java.util.Arrays;

public class Merge {
    public static void solution(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int[] res = new int[m + n];
        // 遍历数组nums1
        int i = 0;
        // 遍历数组nums2
        int j = 0;
        // 遍历数组res
        int k = 0;


        while (i < m && j < n) {
            res[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            if (i >= m) {
                // nums1到达尾部,将nums2中剩余的元素转移到res中
                while (j < n) {
                    res[k++] = nums2[j++];
                }
                break;
            }
            if (j >= n) {
                // nums2到达尾部,将nums1中剩余的元素转移到res中
                while (i < m) {
                    res[k++] = nums1[i++];
                }
                break;
            }
        }

        for (int l = 0; l < m + n; l++) {
            nums1[l] = res[l];
        }
    }


    public static void main(String[] args) {
//        int[] nums1 = {1,2,3,0,0,0};
//        int[] nums2 = {2,5,6};
        int[] nums1 = {0,0,0,0,0};
        int[] nums2 = {1,2,3,4,5};
        solution(nums1,0, nums2,1);
        System.out.println(Arrays.toString(nums1));
    }
}
