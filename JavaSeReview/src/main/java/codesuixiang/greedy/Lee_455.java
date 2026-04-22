package codesuixiang.greedy;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * 贪心算法 分发饼干
 */
public class Lee_455 {


    @Test
    public void  testFind() {
        int []  g = {1,2};
        int []  s = {1,2,3};
        System.out.println(findContentChildren(g,s));
    }

    //优先考虑胃口，先喂饱大胃口

    /**
     *
     * @param g 胃口值
     * @param s 饼干大小
     * @return 满足人数
     */
    public int findContentChildren(int[] g,int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int start = s.length - 1;//饼干数组的下标

        //遍历胃口
        for (int i = g.length - 1; i >= 0 ; i--) {
            if (start >= 0 && g[i] <= s[start]) {
                start--;
                count++;
            }
        }
        return count;


    }
}
