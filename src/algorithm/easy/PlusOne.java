package algorithm.easy;

public class PlusOne {
    public static int[] solution(int[] digits) {
        int tail = digits.length - 1;
        boolean flag = false;
        // 全为9的时候,需要重新构建数组返回
        for (int i = 0; i <= tail; i++) {
            if (digits[i] != 9) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            // 重新构建数组
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 1; i < res.length; i++) {
                res[i] = 0;
            }
            return res;
        } else {
            // 末尾元素小于9
            if (digits[tail] < 9) {
                digits[tail] += 1;
                return digits;
            }
            for (int i = tail; i > 0; i--) {
                // 如果当前元素大于等于9,进位,下一位加1,当前位为0
                if (digits[i] >= 9) {
                    digits[i] = 0;
                    digits[i - 1] += 1;
                    // 没有进位,跳出循环
                    if (digits[i - 1] < 10) {
                        break;
                    }
                }
            }
        }

        return digits;
    }

    public static void main(String[] args) {

    }
}
