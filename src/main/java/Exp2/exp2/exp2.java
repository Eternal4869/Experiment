package Exp2.exp2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class exp2 {
    public static void main(String[] args) {
        System.out.print("请输入数塔高度 : ");
        Scanner in = new Scanner(System.in);
        int height = in.nextInt();
        if (height <= 0) System.out.println("高度有误，请重新输入");
        else {
            List<List<Integer>> tower = new ArrayList<List<Integer>>();
            for (int i = 0; i < height; i++) {
                tower.add(new ArrayList<Integer>());
            }
            System.out.println("请按照数塔规则输入步数 : ");
            for (int i = 0; i < height; i++) {
                for (int i1 = 0; i1 <= i; i1++) {
                    int step = in.nextInt();
                    tower.get(i).add(step);
                }
            }
            int i = 0;                                                                  //将tower转换为数组
            int[][] towerArray = new int[tower.size()][];
            for (List<Integer> integers : tower) {
                Object[] objects = integers.toArray();
                int[][] towerarray = new int[tower.size()][objects.length];
                for (int j = 0; j < objects.length; j++) {
                    towerarray[i][j] = (int) objects[j];
                }
                towerArray[i] = towerarray[i];
                i++;
            }
            towerMaxStep(towerArray);
        }
    }

    public static void towerMaxStep(int[][] tower) {
        int height = tower.length;
        int[][] towerCopy = new int[height][height];                                   //记录数塔最大步数
        for (int i = 0; i < height; i++) {                                             //复制原数塔
            for (int i1 = 0; i1 <= i; i1++) {
                towerCopy[i][i1] = tower[i][i1];
            }
        }
        for (int i = height - 2; i >= 0; i--) {                                         //从倒数第二层向上算
            for (int i1 = i; i1 >= 0; i1--) {                                           //每层从开始节点算
                int result1 = towerCopy[i][i1] + towerCopy[i + 1][i1];
                int result2 = towerCopy[i][i1] + towerCopy[i + 1][i1 + 1];
                towerCopy[i][i1] = Math.max(result1, result2);                           //将节点值改为当前节点所能达到的最大步数
            }
        }
        System.out.println("最大步数为 : " + towerCopy[0][0]);
        int maxStep = towerCopy[0][0];
        System.out.print("最大路径为(0, 0)->");
        maxStep -= tower[0][0];
        for (int i = 1; i < height; i++) {
            for (int i1 = 0; i1 <= i; i1++) {
                if (towerCopy[i][i1] == maxStep) {
                    System.out.print("(" + i + ", " + i1 + ")->");
                    maxStep -= tower[i][i1];
                }
            }
        }
        System.out.println("结束");
    }
}
