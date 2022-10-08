package Exp1.exp2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class exp2 {
    public static void main(String[] args) {
        List<Double> coins = new ArrayList<Double>();
        System.out.print("请输入硬币个数 : ");
        Scanner in = new Scanner(System.in);
        int nums = in.nextInt();
        System.out.print("请输入各硬币的质量 : ");
        double weight;
        for (int i = 0; i < nums; i++) {
            weight = in.nextDouble();
            coins.add(weight);
        }
        System.out.print("假币所在的序号为(序号从0开始,-1代表硬币数量不足以查询出假币位置) : ");
        counterfeitMoney(coins, 0, coins.size() - 1);
    }

    public static void counterfeitMoney(List<Double> coins, int begin, int end) {
        if (coins.size() == 1 || coins.size() == 0) {
            System.out.println("-1");
        } else {
            int mediumNum = begin + (end - begin) / 2;
            int length = end + 1 - begin;
            if (length % 2 == 0) {
                if (length == 2) {
                    if (coins.get(begin) > coins.get(end)) {
                        System.out.println(end);
                        System.exit(0);
                    } else {
                        System.out.println(begin);
                        System.exit(0);
                    }
                } else {
                    double coins1Weight = calcWeight(coins, begin, mediumNum);
                    double coins2Weight = calcWeight(coins, mediumNum + 1, end);
                    if (coins1Weight > coins2Weight) {
                        counterfeitMoney(coins, mediumNum + 1, end);
                    } else {
                        counterfeitMoney(coins, begin, mediumNum);
                    }
                }
            } else {
                if (length == 1) {
                    System.out.println(begin);
                } else {
                    double coins1Weight = calcWeight(coins, begin, mediumNum - 1);
                    double coins2Weight = calcWeight(coins, mediumNum + 1, end);
                    if (coins1Weight == coins2Weight) {
                        System.out.println(mediumNum);
                        System.exit(0);
                    }
                    if (coins1Weight < coins2Weight) {
                        counterfeitMoney(coins, begin, mediumNum - 1);
                    }
                    if (coins1Weight > coins2Weight) {
                        counterfeitMoney(coins, mediumNum + 1, end);
                    }
                }
            }
        }
    }

    public static double calcWeight(List<Double> coins, int begin, int end) {
        double result = 0;
        for (int i = begin; i <= end; i++) {
            result += coins.get(i);
        }
        return result;
    }
}
