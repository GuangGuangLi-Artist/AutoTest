package niukeans;

import java.util.*;

public class HJ49 {

    public static class Candidate{
        int id;
        int score;

        public Candidate(int id, int score){
            this.id = id;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
       int n = in.nextInt();
       int m = in.nextInt();
       List<Candidate> candidates = new ArrayList<Candidate>();
       for(int i = 0; i < n; i++){
           int id = in.nextInt();
           int score = in.nextInt();
           candidates.add(new Candidate(id,score));
       }

       //排序  --- 重要
        Collections.sort(candidates,(a,b) ->{
            if(a.score != b.score) {
                return b.score - a.score;//成绩高的在前
            }else {
                return a.id - b.id;//报名号小的在前
            }
        });

       //计算面试名额 t = floor(1.5 * m)  ---向下取整的办法 重要
        int t = (int) (m * 1.5);

        //第 t 名的成绩就是分数线（注意：t 是人数，索引是 t-1）
        int line = candidates.get(t -1).score;

        //统计实际入围人数（所有 >= line 的）
        int cnt = 0;
        for (Candidate c : candidates) {
            if(c.score >= line) {
                cnt++;
            }
        }

        //输出第一行
        System.out.println(line + " " + cnt);

        //输出所有入围者
        for (Candidate c : candidates) {
            if(c.score >= line) {
                System.out.println(c.id + " " + c.score);
            }
        }

        in.close();
    }
}
