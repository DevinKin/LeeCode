package algorithm.easy;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isVaild(String s) {
        String left = "([{";
        String right = ")]}";
        Stack<Integer> vs = new Stack<Integer>();
        boolean result = false;
        int leftPos = 0;
        int rightPos = 0;
        // 空字符串,返回true
        if (s.equals("")) {
            return true;
        }
        // 第一个字符串为空或字符串长度小于2或第一个字符是右括号,返回false
        if (s == null || s.length() < 2 || (right.indexOf(s.charAt(0)) != -1))
            return false;
        for (int i = 0; i < s.length(); i++) {
            // 如果该字符包含在左括号列表中,push到栈中
            leftPos = left.indexOf(s.charAt(i));
            if (leftPos != -1) {
                vs.push(leftPos);
            }
            // 如果该字符包含在右括号列表中,从栈中pop出来,并用来对比左括号与右括号的索引值是否相同
            rightPos = right.indexOf(s.charAt(i));
            if (rightPos != -1) {
                // 如果此时还是右括号,栈为空的话,说明右括号数量多于左括号数量,返回false
                if (vs.empty() || rightPos != vs.pop()) {
                    return false;
                }
            }
        }
        // 如果栈为空,返回true,否则返回false
        if (vs.empty()) {
            // 遍历均成功后,返回为有效字符串
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(isVaild("()"));
        System.out.println(isVaild("()[]{}"));
        System.out.println(isVaild("(]"));
        System.out.println(isVaild("([)]"));
        System.out.println(isVaild("{[]}"));
    }
}
