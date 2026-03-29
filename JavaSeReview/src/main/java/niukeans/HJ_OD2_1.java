package niukeans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HJ_OD2_1 {
    static List<int[]> tp;// tp 用来存储所有的“手动启动计划” (Time, Position)
    static List<Integer> res;// res 用来存储最终结果（最晚启动的发动机位置列表）
    static int[] time;// time 数组用来记录每个发动机最终被启动的时刻
    public static int getTime(int n) {
        for (int i = 0; i < n; i++) {// 第一层循环：遍历每一个发动机（也就是计算每一个位置 i 的启动时间）
            for (int[] m: tp){
                // 第二层循环：遍历每一个“手动启动计划”
                // 我们要找出：对于发动机 i 来说，哪一个手动启动点传过来的波最快？
                // m[0] 是手动启动的时刻 (T)
                // m[1] 是手动启动的位置 (P)
                // --- 关键步骤 1: 计算环上两点的最短距离 ---
                int d = Math.abs(i - m[1]);// 直线距离（或者说顺时针/逆时针中的一种）
                d = Math.min(d, n -d);// 环上最短距离 = min(顺时针距离, 逆时针距离)

                // --- 关键步骤 2: 更新发动机 i 的最早启动时间 ---
                // 发动机 i 被启动的时间 = 源头启动时间(m[0]) + 传递过来的耗时(d)
                // 因为可能有多个源头，我们要取最小值（谁先传到就算谁的）
                time[i] = Math.min(time[i],m[0] + d);
            }
        }
        // --- 寻找最大值 ---
        // 计算完所有发动机的启动时间后，找出其中最晚的一个时间
        int maxx = -1;
        for (int i = 0; i < time.length; i++) {
            if(time[i] > maxx){
                maxx = time[i];
            }
        }
        return maxx;// 返回最晚启动的时刻
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        tp = new ArrayList<int[]>();


        // 读取输入数据
        for (int i = 0; i < e; i++) {
            int t = sc.nextInt();// 发动机总数
            int p = sc.nextInt();// 手动启动个数
            int[] temp = new int[]{t,p};
            tp.add(temp);
        }


        // 初始化 time 数组，全部设为无穷大
        // 意思是：初始假设所有发动机都还没被启动
        time = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);
        res = new ArrayList<>();
        // 1. 先调用方法，把所有发动机的启动时间算出来，并拿到最晚的时间点
        int lastTime = getTime(n);
        // 2. 再次遍历，找出所有启动时间等于“最晚时间点”的发动机位置
        for (int i = 0; i < n; i++) {
            if(time[i] == lastTime){
                res.add(i);
            }
        }

        // 输出结果
        int sum = res.size();
        System.out.println(sum);
        for (int i = 0; i < sum; i++) {
            System.out.print(res.get(i) + " ");
        }

    }
}
