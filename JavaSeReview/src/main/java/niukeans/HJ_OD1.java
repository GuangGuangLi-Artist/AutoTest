package niukeans;

import java.util.Scanner;


/**
 * 假设你是一家大型科技公司的部门负责人，负责管理公司内部员工的工作状态。公司使用一个系统来记录员工的登录和登出时间。现在你需要编写一个函数来计算在给
 * 定时间段内有多少不同的员工处于活跃状态。每个员工都有一个唯一的D，并且这些ID与登录和登出时间戳是一一对应的。此外，系统还会记录员工的活动类型
 * (例如，工作、会议、休息等)，你需要根据活动类型过滤员工。
 * 输入描述
 * in[]employeelDs:一个整数数组，表示员工的唯一ID。
 * int[]logins:一个整数数组，表示员工的登录时间戳(单位为秒)。时间戳是从某个固定时间点开始的相对时间如，从服务器启动到现在的秒数)。
 * in]logouts:一个整数数组，表示员工的登出时间戳(单位为秒)。时间戳是从某个固定时间点开始的相对时间(例如，从服务器启动到现在的秒数)
 * Stringl]activities:一个字符串数组，表示员工的活动类型(例如，"work","meeting","break").
 * <p>
 * int start:查询开始的时间戳。
 * int end:查询结束的时间戳。
 * StringactivityType:需要过滤的活动类型
 * 输出描述
 * int:在给定时间段内特定活动类型的不同活跃员工数量。
 * 补充说明
 * 数据内各元素一-对应，且各数组内元素非空;时间戳重合不算符合要求
 *
 * 示例2
 * 输入
 * 101 202 303 404 505
 * 7 10 15 20 25
 * 12 18 22 28 30
 * work meeting break work meeting
 * 5
 * 24
 * work
 * 输出
 * 2
 *
 * employeelDs = [101, 202, 303, 404, 505], logins = [7, 10, 15, 20, 25), 1ogouts = [12, 18, 22, 28, 30], activities =["'work", "meeting", "break", "work", "meeting"l, start = 5, end = 24, activityType = "work"
 * 在时间区间[20,100]内，有一个员工(1D为101)进行了"work”活动。
 */
public class HJ_OD1 {

    public static int getNum(int[] employIds, int[] logins, int[] logouts, String[] actions, int start, int end, String type) {

        int num = 0;
        for (int i = 0; i < employIds.length; i++) {

            //查询状态 不是查询状态的跳出本次循环
            if (!type.equals(actions[i])) {
                continue;
            }
            //时间重叠判断：判断员工的活动时间 [login, logout] 与查询时间 [start, end] 是否有重叠。
            //两个区间 没有重叠 的情况只有两种： 员工在查询开始前就已经结束了（logout <= start）,员工在查询结束后才开始（login >= end）。
            //因此，有重叠 的条件是取反：!(logout <= start || login >= end)，简化后即为 login < end && logout > start。
            if (logins[i] < end && logouts[i] > start) {
                num++;
            }
        }

        return num;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] inputFirst = sc.nextLine().split(" ");
        int input = inputFirst.length;
        int[] employIds = new int[input];
        for (int i = 0; i < employIds.length; i++) {
            employIds[i] = Integer.parseInt(inputFirst[i]);
        }

        int[] logins = new int[input];
        for (int i = 0; i < logins.length; i++) {
            logins[i] = sc.nextInt();
        }

        int[] logouts = new int[input];
        for (int i = 0; i < logouts.length; i++) {
            logouts[i] = sc.nextInt();
        }

        String[] actions = new String[input];
        for (int i = 0; i < actions.length; i++) {
            actions[i] = sc.next();
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        String type = sc.next();
        int num = getNum(employIds, logins, logouts, actions, start, end, type);
        System.out.println(num);


    }
}
