package algorithm.easy;

public class AddBinary {
    public static String solution(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int alen = a.length();
        int blen = b.length();
        int N = alen > blen ? alen : blen;
        char up = '0';
        char c = ' ';
        for (int i = 1; i <= N; i++) {
            int ai = a.length() - i;
            int bi = b.length() - i;
            if (ai < 0) {
                // b比a长
                // 有上一位的进位
                if (up == '1') {
                    c = (char) (b.charAt(bi) + up - '0');
                    if (c < '2') {
                        sb.insert(0, c);
                        // 恢复上一位进位
                        if (up != '0') {
                            up = '0';
                        }
                    } else {
                        if (up != '1') {
                            // 有进位
                            up = '1';
                        }
                        sb.insert(0, '0');
                    }
                    continue;
                } else {
                    // 没进位,直接把剩余的字符串插入即可
                    sb.insert(0, b.substring(0, bi + 1));
                    break;
                }
            }
            if (bi < 0) {
                // a比b长
                // 有上一位的进位
                if (up == '1') {
                    c = (char) (a.charAt(ai) + up - '0');
                    if (c < '2') {
                        sb.insert(0, c);
                        // 恢复上一位进位
                        if (up != '0') {
                            up = '0';
                        }
                    } else {
                        if (up != '1') {
                            // 有进位
                            up = '1';
                        }
                        sb.insert(0, '0');
                    }
                    continue;
                } else {
                    // 没进位,直接把剩余的字符串插入即可
                    sb.insert(0, a.substring(0, ai + 1));
                    break;
                }
            }
            c = (char) (a.charAt(ai) + b.charAt(bi) + up - '0' - '0');
            if (c < '2') {
                // 插入到sb中
                sb.insert(0, c);
                // 恢复上一位进位
                if (up != '0') {
                    up = '0';
                }
            } else {
                if (up != '1') {
                    // 有进位
                    up = '1';
                }
                c = (char) (c - '2' + '0');
                // 插入到sb中
                sb.insert(0, c);
            }
        }
        // 到最后还有进位,则插入1一个1,否则不插入
        if (up == '1') {
            sb.insert(0, '1');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("1010","1011"));
        System.out.println(solution("11","1"));
        System.out.println(solution("110","110010"));
        System.out.println(solution("101111","10"));
        System.out.println(solution("0", "0"));
        System.out.println(solution("100", "110010"));
    }
}
