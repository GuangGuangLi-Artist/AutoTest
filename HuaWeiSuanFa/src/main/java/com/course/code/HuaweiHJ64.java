package com.course.code;

import java.util.Scanner;

/**
 * MP3 光标位置
 * MP3 Player因为屏幕较小，显示歌曲列表的时候每屏只能显示几首歌曲，用户要通过上下键才能浏览所有的歌曲。为了简化处理，假设每屏只能显示4首歌曲，光标初始的位置为第1首歌。
 * 现在要实现通过上下键控制光标移动来浏览歌曲列表，控制逻辑如下：
 * 歌曲总数<=4的时候，不需要翻页，只是挪动光标位置。
 * 光标在第一首歌曲上时，按Up键光标挪到最后一首歌曲；光标在最后一首歌曲时，按Down键光标挪到第一首歌曲。
 * 其他情况下用户按Up键，光标挪到上一首歌曲；用户按Down键，光标挪到下一首歌曲
 * 2. 歌曲总数大于4的时候（以一共有10首歌为例）：
 * 特殊翻页：屏幕显示的是第一页（即显示第1 – 4首）时，光标在第一首歌曲上，用户按Up键后，屏幕要显示最后一页（即显示第7-10首歌），同时光标放到最后一首歌上。同样的，屏幕显示最后一页时，光标在最后一首歌曲上，用户按Down键，屏幕要显示第一页，光标挪到第一首歌上
 * 一般翻页：屏幕显示的不是第一页时，光标在当前屏幕显示的第一首歌曲时，用户按Up键后，屏幕从当前歌曲的上一首开始显示，光标也挪到上一首歌曲。光标当前屏幕的最后一首歌时的Down键处理也类似。
 *
 *
 * 输入说明：
 * 1 输入歌曲数量
 * 2 输入命令 U或者D
 *
 * 输出说明
 * 1 输出当前列表
 * 2 输出当前选中歌曲
 */

public class HuaweiHJ64 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            String s = sc.next();
            char[] c = s.toCharArray();
            int current = 1;//当前指示的值
            int index = 1;//指针在当前页位置
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < c.length; i++) {
                if(n <= 4){
                    if(c[i] == 'U' && current == 1){
                        current = n;
                    }else if(c[i] == 'D' && current == n){
                        current = 1;
                    }else  if(c[i] == 'U'){
                        current = current - 1;
                    }else  if(c[i] == 'D'){
                        current = current + 1;
                    }
                }else {
                    if (c[i] == 'U' && current == 1){
                        current = n;
                        index = 4;
                        sb.delete(0,sb.length());
                        sb.append(current - 3 + " ").append(current - 2 + " ").append(current - 1 + " ").append(current);
                    }else  if(c[i] == 'D' && current == n){
                        current = 1;
                        index = 1;
                        sb.delete(0,sb.length());
                        sb.append(current + " ").append(current+1 + " ").append(current+2 + " ").append(current+3);
                    }else if(c[i] == 'U' && index != 1){//不用翻页，当前也值不变，index-1
                        current = current -1;
                        index = index -1;
                    }else if(c[i] == 'U' && index == 1){//需要翻页，值发生变化,index不变
                        current = current - 1;
                        sb.delete(0,sb.length());
                        sb.append(current + " ").append(current+1 + " ").append(current+2 + " ").append(current+3);

                    }else if(c[i] == 'D' && index != 4){//不用翻页，当前也值不变，index+1
                        current = current + 1;
                        index = index + 1;

                    }else if(c[i] == 'D' && index == 4){//需要翻页，值发生变化,index不变
                        current = current + 1;
                        sb.delete(0,sb.length());
                        sb.append(current-3 + "").append(current-2 + "").append(current-1 + "").append(current);
                    }
                }
            }

            if(n<=4){
                for (int i = 1; i <=n ; i++) {
                    System.out.print(i + " ");
                }
            }
            System.out.println(sb);
            System.out.println(current);
        }
    }
}
