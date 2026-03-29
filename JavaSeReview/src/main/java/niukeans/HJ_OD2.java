package niukeans;

import java.util.*;

/**
 * 流浪地球计划在赤道上均匀部署了N个转向发动机，按位置顺序编号为0~N。
 * 1)初始状态下所有的发动机都是未启动状态;
 * 2)发动机启动的方式分为”手动启动”和”关联启动”两种方式;
 * 3)如果在时刻1一个发动机被启动，下一个时刻2与之相邻的两个发动机就会被”关联启动“
 * 4)如果准备启动某个发动机时，它已经被启动了，则什么都不用做;
 * 5) 发动机0与发动机N-1是相邻的;
 * 地球联合政府准备挑选某些发动机在某些时刻进行"手动启动”。当然最终所有的发动机都会被启动。
 * 哪些发动机最晚被启动呢?
 *
 * 输入描述
 * 第一行两个数字N和E，中间有空格
 * N代表部署发动机的总个数，E代表计划手动启动的发动机总个数
 * 1< N<= 1000,1<=E<= 1000,E<=N
 * 接下来共E行，每行都是两个数字T和P，中间有空格
 * T代表发动机的手动启动时刻，P代表此发动机的位置编号。
 * 0<=T<=N,0<=P<N
 *
 * 输出描述
 * 第一行一个数字N，以回车结束N代表最后被启动的发动机个数
 * 第二行N个数字，中间有空格，以回车结束
 * 每个数字代表发动机的位置编号，从小到大排序
 *
 * 示例1
 * 输入
 * 8 2
 * 0 2
 * 0 6
 * 输出
 * 2
 * 0 4
 * 说明
 * 8个发动机;
 * 时刻0启动(2,6);
 * 时刻1启动(1,3,5,7)(其中1,3被2关联启动，5,7被6关联启动);
 * 时刻2启动(0,4)(其中0被1,7关联启动，4被3,5关联启动);
 * 至此所有发动机都被启动，最后被启动的有2个，分别是0和4。
 */
public class HJ_OD2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// 发动机总数
        int e = sc.nextInt();// 手动启动的发动机数量

        Map<Integer, List<Integer>> manualSet = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < e; i++) {
            int t = sc.nextInt();// 启动时刻
            int p = sc.nextInt();// 位置
            manualSet.computeIfAbsent(t, k -> new ArrayList<Integer>()).add(p);
        }

        // 记录每个发动机的启动时刻，-1表示未启动
        int[] startTime = new int[n];
        Arrays.fill(startTime, -1);

        //模拟时间推进
        int currentTime = 0;
        boolean allStarted = false;

        while (!allStarted) {
            //检查是否所有发动机都已启动
            allStarted = true;
            for (int i = 0; i < n; i++) {
                if (startTime[i] == -1) {
                    allStarted = false;
                    break;
                }
            }
            if (allStarted) {
                break;
            }

            // 处理当前时刻的手动启动
            if (manualSet.containsKey(currentTime)){
                for (int pos:manualSet.get(currentTime)){
                    if(startTime[pos] == -1) {
                        startTime[pos] = currentTime;
                    }
                }
            }

            // 收集当前时刻已启动的发动机（用于下一时刻的关联启动）
            List<Integer> currentlyStarted = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (startTime[i] == currentTime) {
                    currentlyStarted.add(i);
                }
            }

            //下一时刻进行关联启动
            int nextTime =  currentTime + 1;
            for (int pos:currentlyStarted){
                //左邻居
                int left = (pos - 1 + n) % n;
                if(startTime[left] == -1) {
                    startTime[left] = nextTime;
                }

                //右邻居
                int right = (pos + 1) % n;
                if(startTime[right] == -1) {
                    startTime[right] = nextTime;
                }
            }
            currentTime++;
        }
        //找出最晚启动的时刻
        int maxStartTime = 0;
        for (int i = 0; i < n; i++) {
            maxStartTime = Math.max(maxStartTime, startTime[i]);
        }

        // 收集最晚启动的发动机位置
        List<Integer> lastEngines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (startTime[i] == maxStartTime) {
                lastEngines.add(i);
            }
        }

        System.out.println(lastEngines.size());

        for (int i = 0; i < lastEngines.size(); i++) {
            if(i > 0) {
                System.out.print(" ");
            }
            System.out.print(lastEngines.get(i));

        }
        System.out.println();

    }
}
