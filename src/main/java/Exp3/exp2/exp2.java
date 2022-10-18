package Exp3.exp2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class exp2 {
    public static void main(String[] args) {
        int sumLength = 0;
        List<Integer> begin = new ArrayList<Integer>();
        List<Integer> end = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        System.out.print("请输入线段条数 : ");
        int num = in.nextInt();
        if (num <= 0) System.out.println("数量有误，请正确输入");
        else {
            System.out.print("请输入各线段的起始坐标 : ");
            for (int i = 0; i < num; i++) {
                int t = in.nextInt();
                begin.add(t);
            }
            System.out.print("请输入各线段终点坐标 : ");
            for (int i = 0; i < num; i++) {
                int t = in.nextInt();
                end.add(t);
            }
            //对得到的坐标进行排序
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num - i - 1; j++) {
                    if (begin.get(j) > begin.get(j + 1)) {
                        int t = begin.get(j);
                        begin.set(j, begin.get(j + 1));
                        begin.set(j + 1, t);
                        t = end.get(j);
                        end.set(j, end.get(j + 1));
                        end.set(j + 1, t);
                    }
                }
            }
            //检查线段的正确性
            for (int i = 0; i < num; i++) {
                if (begin.get(i) > end.get(i)) {
                    System.out.println("第" + i + "条线段坐标不正确，请检查后重新输入。");
                    System.exit(0);
                }
            }
            //线段重合计算
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    if (i == j) continue;
                    //j线段完全在i内
                    if (begin.get(i) < begin.get(j) && end.get(i) > end.get(j))
                        sumLength = sumLength + end.get(j) - begin.get(j);
                    //i线段完全在j内
                    if (begin.get(j) < begin.get(i) && end.get(j) > end.get(i))
                        sumLength = sumLength + end.get(i) - begin.get(i);
                    //i的头在j的尾前
                    if (begin.get(i) < end.get(j) && begin.get(i) > begin.get(j) && end.get(i) > end.get(j))
                        sumLength = sumLength + end.get(j) - begin.get(i);
                    //j的头在i的尾巴前
                    if (begin.get(j) < end.get(i) && begin.get(j) > begin.get(i) && end.get(j) > end.get(i))
                        sumLength = sumLength + end.get(i) - begin.get(j);
                }
            }
            sumLength /= 2;
            System.out.println("线段的总重合长度为 : " + sumLength);
        }
    }
}
