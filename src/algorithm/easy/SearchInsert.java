package algorithm.easy;

public class SearchInsert {
    public static int solution(int[] nums, int target) {
        if (nums == null || nums.length < 1)
            return 0;

        // 使用二分查找法
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;


        // 如果数组中不存在target,则会遍历到start和end相等的情况时候,mid同样也在start处
        // 如果target大于nums[mid],插入位置在start后,start会自动加1,同样结束了循环.
        // 如果target小于nums[mid],插入位置在,插入在同样在start处,此时只是对end-1,同样结束了循环.
        while (start <= end) {
            // 中间元素是start和mid相加,mid是起始元素的索引+start到end长度的一半
            mid = start + (end - start)/ 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]){
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] test = {1,3,4,6};
        int[] test2 = {1,3,5,7,8,9,11};
        int [] test3 = {1,3};
        System.out.println(solution(test,5));
//        System.out.println(solution(test2,12));
    }
}
