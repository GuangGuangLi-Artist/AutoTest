package leecodeAns.hot_100.easy;


/**
 * 182.动态口令
 *  某公司门禁密码使用动态口令技术。初始密码为字符串 password，密码更新均遵循以下步骤：
 *      设定一个正整数目标值 target
 *      将 password 前 target 个字符按原顺序移动至字符串末尾
 *
 *     输入: password = "s3cur1tyC0d3", target = 4
 *     输出: "r1tyC0d3s3cu"
 */
public class Ques_182 {


    public static void main(String[] args) {
        Ques_182 ques182 = new Ques_182();
        String s = "s3cur1tyC0d3";
        int ta = 4;
        String s1 = ques182.dynamicPassword(s, ta);
        System.out.println(s1);

    }

    public String dynamicPassword(String password, int target) {
        int len = password.length();
        StringBuilder sb = new StringBuilder(password);
        reverString(sb,0,target-1);
        reverString(sb,target,len-1);
        return sb.reverse().toString();

    }

    public void reverString(StringBuilder sb,int start,int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
    }
}
